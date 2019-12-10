package com.hq.travel.service.impl;

import com.hq.travel.entity.User;
import com.hq.travel.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public List<User> getUser() {
        List<User> list=new ArrayList<>();
        User u=new User();
      //  u.setUser_name("何强");
       // u.setUser_password("123456");
        list.add(u);
        return list;
    }
}
