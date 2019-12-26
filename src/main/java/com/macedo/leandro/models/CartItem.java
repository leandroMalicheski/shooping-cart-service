package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    private ObjectId _id;
    private ObjectId cartId;
    private ObjectId itemId;
    private int quantity;

    public String get_id() {
        return _id.toHexString();
    }
    public String getCartId() {
        return cartId.toHexString();
    }
    public String getItemId() {
        return itemId.toHexString();
    }
}
