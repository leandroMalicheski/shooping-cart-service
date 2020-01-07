package com.macedo.leandro.models;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
    private String userIdAsString;
    private String cartIdAsString;
    private Cart cart;

    @Before
    public void createCart(){
        ObjectId userId = ObjectId.get();
        userIdAsString = userId.toHexString();
        ObjectId cartId = ObjectId.get();
        cartIdAsString = cartId.toHexString();

        Cart cart = new Cart(userId, cartId);
    }

    @Test
    public void cartMustHaveAUserId(){
        Assert.assertEquals(userIdAsString, cart.getUserId());
    }

    @Test
    public void CartMustHaveAUserIdAndCartId(){
        Assert.assertEquals(userIdAsString, cart.getUserId());
        Assert.assertEquals(cartIdAsString, cart.get_id());
    }
}
