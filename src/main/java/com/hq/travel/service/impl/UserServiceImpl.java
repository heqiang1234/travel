package com.hq.travel.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hq.exception.GlobalException;
import com.hq.result.CodeMsg;
import com.hq.travel.dao.UserDao;
import com.hq.travel.entity.User;
import com.hq.travel.service.UserService;
import com.hq.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 用户业务逻辑实现类
 * MyBatis Plus 版本
 */
@Service
public class UserServiceImpl implements UserService {


    public static final String COOKIE_NAME_TOKEN = "token";

    /**
     * token过期时间，2天
     */
    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;


    @Autowired
    @Resource
    private UserDao userDao;

    @Autowired
    @Resource
    private RedisUtil redisUtil;


    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.updateById(user);
    }

    @Override
    public void deleteById(Long userId) {
        userDao.deleteById(userId);
    }

    @Override
    public Page<User> findAll(Page<User> page) {
        return page.setRecords(userDao.findAll(page));
    }

    @Override
    public User findById(Long userId) {
        return userDao.selectById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public String login(HttpServletResponse response, String username, String password) {

        //判断用户名是否存在
        User user = findByUsername(username);
        if (user == null) {
            throw new GlobalException(CodeMsg.USERNAME_NOT_EXIST);
        }

        //验证密码，这里为了例子简单，密码没有加密
        String dbPass = user.getUserPassword();
        if (!password.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        //生成cookie
        String token = UUID.randomUUID().toString().replace("-", "");
        addCookie(response, token, user);
        return token;
    }

    @Override
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = JSON.parseObject(redisUtil.get(COOKIE_NAME_TOKEN + "::" + token), User.class);
        //重置有效期
        if (user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        if (response != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    @Override
    public User getByToken(String token) {
        return getByToken(null, token);
    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return getLoginUser(request, null);
    }

    @Override
    public User getLoginUser(HttpServletRequest request, HttpServletResponse response) {
        String paramToken = request.getParameter(UserServiceImpl.COOKIE_NAME_TOKEN);
        String cookieToken = getCookieValue(request, UserServiceImpl.COOKIE_NAME_TOKEN);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            // return null;
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        if (response == null) {
            return getByToken(token);
        }
        return getByToken(response, token);
    }

    private String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            // return null;
            throw new GlobalException(CodeMsg.TOKEN_INVALID);
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        //将token存入到redis
        redisUtil.set(COOKIE_NAME_TOKEN + "::" + token, JSON.toJSONString(user), TOKEN_EXPIRE);
        //将token写入cookie
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


}
