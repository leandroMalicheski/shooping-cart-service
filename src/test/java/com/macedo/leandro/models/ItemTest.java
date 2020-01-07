package com.macedo.leandro.models;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private final float ITEM_VALUE = 2.99f;
    private final float FLOAT_DELTA = 0.01f;
    private final String ITEM_NAME = "Mouse";

    private Item item;
    private String itemIdAsString;

    @Before
    public void createItem(){
        ObjectId itemId = ObjectId.get();
        itemIdAsString = itemId.toHexString();
        item = new Item(itemId, ITEM_NAME, ITEM_VALUE);
    }

    @Test
    public void itemMustHaveNameValueAndId(){
        Assert.assertEquals(itemIdAsString, item.get_id());
        Assert.assertEquals(ITEM_NAME, item.getName());
        Assert.assertEquals(ITEM_VALUE, item.getValue(), FLOAT_DELTA);
    }

}
