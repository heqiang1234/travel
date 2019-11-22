package com.hq.travel.service.serviceImpl;

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
        u.setUserName("何强");
        u.setUserPassword("123456");
        list.add(u);
        return list;
    }
}
