package com.macedo.leandro.controllers;

import com.macedo.leandro.models.Cart;
import com.macedo.leandro.services.ServiceCart;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    ServiceCart serviceCart;

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping()
    public List<Cart> getAllItem() {
        logger.info("Getting all carts.");
        return serviceCart.findAll();
    }

    public Cart getCartByUserId(@PathVariable ObjectId id){
        logger.info("Getting cart by user");
        return serviceCart.findByUserId(id);
    }


}
