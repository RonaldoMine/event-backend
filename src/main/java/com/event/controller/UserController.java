package com.event.controller;

import com.event.model.User;
import com.event.request.UserRequest;
import com.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{enterprise_id}")
    public List<User> all(@PathVariable("enterprise_id") Long enterprise_id) {
        return userService.getUsers(enterprise_id);
    }

    @PostMapping("save/{enterprise_id}")
    public User store(@PathVariable Long enterprise_id, @RequestBody UserRequest userRequest) {
        return userService.store(userRequest, enterprise_id);
    }

    @PutMapping("update/{id}")
    public User update(@RequestBody UserRequest userRequest, @PathVariable Long id) {
        return userService.update(userRequest, id);
    }

    @DeleteMapping("delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
