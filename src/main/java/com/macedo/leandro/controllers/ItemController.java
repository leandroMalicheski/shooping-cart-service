package com.macedo.leandro.controllers;

import com.macedo.leandro.models.Item;
import com.macedo.leandro.services.ServiceItem;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    ServiceItem serviceItem;
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping()
    public List<Item> getAllItem() {
        logger.info("Getting all items.");
        return serviceItem.findAll();
    }

    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable("id") ObjectId id) {
        logger.info("Returning item id:{}", id);
        return serviceItem.findBy_id(id);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public void modifyItemById(@PathVariable("id") ObjectId id, @Valid @RequestBody Item item) {
        logger.info("Updating item id:{}", id);
        item.set_id(id);
        serviceItem.updateItem(item);
    }

    @PostMapping()
    public Item createItem(@Valid @RequestBody Item item) {
        logger.info("Adding item id:{}", item.get_id());
        serviceItem.saveItem(item);
        return item;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable ObjectId id) {
        logger.info("Removing item id:{}", id);
        serviceItem.deleteItem(id);
    }

}
