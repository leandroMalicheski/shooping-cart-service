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
    private ObjectId id;
    private String name;
    private float value;
    private int qty;

    public Item(ObjectId id, String name, float value){
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id.toHexString();
    }
}
