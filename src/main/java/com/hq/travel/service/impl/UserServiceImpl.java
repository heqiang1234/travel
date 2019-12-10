package com.hq.travel.service.impl;

import com.hq.travel.dao.UserDao;
import com.hq.travel.entity.User;
import com.hq.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hq
 * @since 2019-12-06
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    @Resource
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Override
    public List<User> getUserByList() {
        System.out.println("hello impl");
        return userDao.getUser();
    }
}
