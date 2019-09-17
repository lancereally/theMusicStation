package org.lanqiao.controller;

import org.lanqiao.entity.Users;
import org.lanqiao.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    // Lzc : search users
    @RequestMapping("search/selectUsersByInput")
    public List<Users> selectUsersByInput(String input){
        return usersService.selectUsersByInput(input);
    }
}
