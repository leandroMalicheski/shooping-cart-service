package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private ObjectId _id;
    private String name;
    private String email;

    public User(ObjectId _id, String name, String email){
        this._id = _id;
        this.name = name;
        this.email = email;
    }

    public String get_id() {
        return _id.toHexString();
    }
}
