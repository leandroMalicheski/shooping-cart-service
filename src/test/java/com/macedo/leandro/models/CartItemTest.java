package com.macedo.leandro.models;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartItemTest {
    private final int ITEM_QUANTITY = 10;
    private CartItem cartItem;
    private String cartIdAsString;
    private String cartItemIdAsString;
    private String itemIdAsString;

    @Before
    public void createCartItem(){
        ObjectId cartId = ObjectId.get();
        cartIdAsString = cartId.toHexString();
        ObjectId cartItemId = ObjectId.get();
        cartItemIdAsString = cartItemId.toHexString();
        ObjectId itemId = ObjectId.get();
        itemIdAsString = itemId.toHexString();

        cartItem = new CartItem(cartItemId, cartId, itemId, ITEM_QUANTITY);
    }

    @Test
    public void itemMustHaveCartIdItemCartIdItemIdAndQuantity(){
        Assert.assertEquals(itemIdAsString,cartItem.getItemId());
        Assert.assertEquals(cartIdAsString,cartItem.getCartId());
        Assert.assertEquals(cartItemIdAsString,cartItem.get_id());
        Assert.assertEquals(ITEM_QUANTITY,cartItem.getQuantity());
    }

}
