package com.mudryk.simplejooq.businesslayer.businessentities;

import java.io.Serializable;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public interface Entity<K extends Serializable> {

    K getId();
}
