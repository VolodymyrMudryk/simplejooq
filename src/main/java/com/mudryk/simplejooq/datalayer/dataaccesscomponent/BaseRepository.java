package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.mudryk.simplejooq.businesslayer.businesscomponents.convertors.RecordConverter;
import com.mudryk.simplejooq.businesslayer.businessentities.Entity;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class BaseRepository<E extends Entity<K>, K extends Serializable, R extends UpdatableRecord> {

    protected final DSLContext dslContext;
    protected final RecordConverter<E, R> recordConverter;
    private final Table<R> table;

    protected BaseRepository(DSLContext dslContext, RecordConverter<E, R> recordConverter, Table<R> table) {
        this.dslContext = dslContext;
        this.recordConverter = recordConverter;
        this.table = table;
    }

    public abstract Condition idEq(K id);

    public abstract Condition idIn(Collection<K> ids);

    public E create(E entity) {
        R record = dslContext.newRecord(table);
        return storeRecord(entity, record);
    }

    public List<E> create(Iterable<E> entities) {
        return stream(entities.spliterator(), false)
                .map(this::create)
                .collect(Collectors.toList());
    }

    public E update(E entity) {
        R record = fetchRecord(entity.getId());
        return storeRecord(entity, record);
    }

    private E storeRecord(E entity, R record) {
        recordConverter.updateRecord(entity, record);
        record.store();
        return recordConverter.record2entity(record);
    }

    public Optional<E> findOne(K id) {
        R record = fetchRecord(id);
        return Optional.ofNullable(record).map(recordConverter::record2entity);
    }

    public List<E> findAll() {
        return dslContext
                .fetch(table)
                .map(recordConverter::record2entity);
    }

    public List<E> findAll(Collection<K> ids) {
        return dslContext
                .fetch(table, idIn(ids))
                .map(recordConverter::record2entity);
    }

    public void delete(K id) {
        dslContext
                .delete(table)
                .where(idEq(id)).execute();
    }

    public void delete(Iterable<? extends E> entities) {
        dslContext
                .delete(table)
                .where(idIn(
                        stream(entities.spliterator(), false)
                                .map(Entity::getId)
                                .collect(Collectors.toList())))
                .execute();
    }

    public int count() {
        return dslContext
                .selectCount()
                .from(table)
                .fetchOne().value1();
    }

    public <S extends E> S upsert(S entity) {
        R record = recordConverter.entity2record(entity);
        dslContext
                .insertInto(table, record.fields())
                .values(record.valuesRow().fields())
                .onDuplicateKeyUpdate()
                .set(record)
                .execute();
        return entity;
    }

    private R fetchRecord(K id) {
        return dslContext
                .fetchOne(table, idEq(id));
    }
}
