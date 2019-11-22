package com.hq.travel.controller;

import com.hq.travel.entity.User;
import com.hq.travel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    @Resource
    private LoginService loginService;

     @RequestMapping(value = "/test")
     @ResponseBody
      public User getUser()
      {
          List<User> list =loginService.getUser();
          System.out.println(list.get(0).toString());
          return list.get(0);
      }
}
