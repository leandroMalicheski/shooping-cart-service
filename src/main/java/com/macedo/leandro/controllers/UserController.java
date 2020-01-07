package com.macedo.leandro.controllers;

import com.macedo.leandro.models.User;
import com.macedo.leandro.services.ServiceUser;
import com.macedo.leandro.vo.UserVO;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    ServiceUser serviceUser;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping()
    public List<User> getAllUser() {
        logger.info("Returning all users");
        return serviceUser.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") ObjectId id) {
        logger.info("Returning user id:{}", id);
        return serviceUser.findBy_id(id);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
        logger.info("Updating user id:{}", id);
        user.set_id(id);
        serviceUser.updateUser(user);
    }

    @PostMapping()
    public UserVO createUser(@Valid @RequestBody User user) {
        logger.info("Adding item id:{}", user.get_id());
        return serviceUser.saveUser(user);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        logger.info("Removing user id:{}", id);
        serviceUser.deleteUser(id);
    }

}
