package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Cart {

    @Id
    private ObjectId _id;
    private ObjectId userId;

    public Cart(ObjectId userId){
        this.userId = userId;
    }

    public Cart(ObjectId userId, ObjectId _id){
        this._id = _id;
        this.userId = userId;
    }

    public String get_id() {
        return _id.toHexString();
    }
    public String getUserId() {
        return userId.toHexString();
    }
}
