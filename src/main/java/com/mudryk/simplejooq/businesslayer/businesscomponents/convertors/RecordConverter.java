package com.mudryk.simplejooq.businesslayer.businesscomponents.convertors;

import org.jooq.Record;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public interface RecordConverter<E, R extends Record> {

    R entity2record(E entity);

    void updateRecord(E entity, R record);

    E record2entity(R record);
}
