package com.hq.travel.controller;


import com.hq.travel.entity.User;
import com.hq.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hq
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/travel/user")
public class UserController {

    @Autowired
    @Resource
    private UserService userService;


    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser()
    {
        return userService.getUserByList();
    }
}
