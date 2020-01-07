package com.macedo.leandro.models;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private final String USER_NAME = "TestName";
    private final String USER_EMAIL = "test@test.com";

    private String userIdAsString;
    private User user;

    @Before
    public void createUser(){
        ObjectId userId = ObjectId.get();
        userIdAsString = userId.toHexString();
        user = new User(userId, USER_NAME, USER_EMAIL);
    }

    @Test
    public void userMustHaveIdNameAndEmail(){
        Assert.assertEquals(USER_EMAIL,user.getEmail());
        Assert.assertEquals(USER_NAME, user.getName());
        Assert.assertEquals(userIdAsString, user.get_id());
    }

}
