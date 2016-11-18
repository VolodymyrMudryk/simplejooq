package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.google.common.collect.Lists;
import com.mudryk.simplejooq.businesslayer.businessentities.Entity;
import com.mudryk.simplejooq.infra.platform.ApplicationContextTestBase;
import org.jooq.DSLContext;
import org.jooq.UpdatableRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public abstract class JooqBaseRepositoryTest<E extends Entity<K>, K extends Serializable, R extends UpdatableRecord> extends ApplicationContextTestBase {

    @Autowired
    protected DSLContext dslContext;

    protected abstract BaseRepository<E, K, R> getRepository();

    protected abstract E createEntity();

    protected abstract E modifyEntity(E entity);

    @Test
    public void testCreateAndFindOne() throws Exception {
        E expected = getRepository().create(createEntity());
        E actual = getRepository().findOne(expected.getId()).get();
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdate() throws Exception {
        E initial = getRepository().create(createEntity());
        E actual = getRepository().update(modifyEntity(initial));
        assertThat(actual, is(not(initial)));
    }

    @Test
    public void testFindOneNotExists() {
        E entity = createEntity();
        Optional<E> record = getRepository().findOne(entity.getId());
        assertThat(record.isPresent(), is(false));
    }

    @Test
    public void testFindAll() throws Exception {
        List<E> expected = getRepository().create(Lists.newArrayList(createEntity(), createEntity(), createEntity()));
        List<K> ids = expected.stream().map(Entity::getId).collect(Collectors.toList());
        Iterable<E> actual = getRepository().findAll(ids);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testDeleteById() throws Exception {
        E entity = getRepository().create(createEntity());
        getRepository().delete(entity.getId());
        assertThat(getRepository().findOne(entity.getId()), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNull() {
        getRepository().create((E) null);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullCollection() {
        getRepository().create((Iterable<E>) null);
    }

    @Test
    public void testDeleteAll() throws Exception {
        List<E> saved = getRepository().create(Lists.newArrayList(createEntity(), createEntity(), createEntity()));
        List<K> ids = saved.stream().map(Entity::getId).collect(Collectors.toList());
        getRepository().delete(saved);
        Iterable<E> actual = getRepository().findAll(ids);
        assertThat(actual, emptyIterable());
    }

    @Test
    public void testCount() throws Exception {
        getRepository().create(createEntity());
        getRepository().create(createEntity());
        long count = getRepository().count();
        assertThat(count, is(2L));
    }

    @Test(expected = org.jooq.exception.DataAccessException.class)
    public void testPrimaryKeyIsDefined() throws Exception {
        E initial = getRepository().create(createEntity());
        getRepository().create(modifyEntity(initial));
    }

    @Test
    public void testUpsertNew() throws Exception {
        E expected = getRepository().upsert(createEntity());
        Optional<E> actual = getRepository().findOne(expected.getId());
        assertThat(actual.get(), is(expected));
    }

    @Test
    public void testUpsertExisting() throws Exception {
        E entity = createEntity();
        getRepository().create(entity);
        E updated = createEntity();
        modifyEntity(updated);
        E actual = getRepository().upsert(updated);
        assertThat(actual, is(updated));
    }

    @Test
    public void testFindAllFromEmptyCollection() {
        List<E> actual = getRepository().findAll(Lists.newArrayList());
        assertThat(actual, empty());
    }
}