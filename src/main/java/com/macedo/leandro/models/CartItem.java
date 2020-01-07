package com.macedo.leandro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class CartItem {

    @Id
    private ObjectId _id;
    private ObjectId cartId;
    private ObjectId itemId;
    private int quantity;

    public CartItem(ObjectId _id, ObjectId cartId, ObjectId itemId, int quantity){
        this._id = _id;
        this.cartId = cartId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

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
