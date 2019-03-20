package com.transport.controller;

import com.transport.domain.User;
import com.transport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zlb on 2019.03.20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService  userService;

    @RequestMapping("/list")
    public List<User> listSearch(){
        List<User> userList = userService.selectAll();
        for (User user : userList) {
            System.out.println(user.getUsername()+":"+user.getPassword());
        }
        return userList;
    }
}
