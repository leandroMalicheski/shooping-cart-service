package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    private ObjectId _id;
    private String name;
    private float value;

    public Item(ObjectId _id, String name, float value){
        this._id = _id;
        this.name = name;
        this.value = value;
    }

    public String get_id() {
        return _id.toHexString();
    }
}
