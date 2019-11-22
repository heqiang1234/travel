package com.hq.travel.service;

import com.hq.travel.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoginService {

    List<User> getUser();
}
