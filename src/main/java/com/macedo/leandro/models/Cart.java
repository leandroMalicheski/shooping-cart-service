package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter @Setter
public class Cart {

    @Id
    private ObjectId id;
    private ObjectId userId;
    List<Item> items;

    public Cart(ObjectId userId){
        this.userId = userId;
    }

    public Cart(ObjectId userId, ObjectId id){
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id.toHexString();
    }
    public String getUserId() {
        return userId.toHexString();
    }
}
