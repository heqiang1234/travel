package com.hq.travel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hq.travel.dao.UserDao;
import com.hq.travel.entity.User;
import com.hq.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   @Resource
   private UserService userService;
    //http://localhost:8888/getUserList
    @RequestMapping(value ="/getUserList")
    @ResponseBody
    public List<User> getUserList(){
        return userService.getUserByList();
    }

//    //http://localhost:8888/getUserListByName?userName=xiaoli
//    //条件查询
//    @GetMapping("getUserListByName")
//    public List<User> getUserListByName(String userName)
//    {
//        Map map = new HashMap();
//        map.put("user_name", userName);
//        return userDao.selectByMap(map);
//    }
//
//    //http://localhost:8888/saveUser?userName=xiaoli&userPassword=111
//    //保存用户
//    @GetMapping("saveUser")
//    public String saveUser(String userName,String userPassword)
//    {
//        User user = new User(userName,userPassword);
//        Integer index = userDao.insert(user);
//        if(index>0){
//            return "新增用户成功。";
//        }else{
//            return "新增用户失败。";
//        }
//    }
//
//    //http://localhost:8888/updateUser?id=5&userName=xiaoli&userPassword=111
//    //修改用户
//    @GetMapping("updateUser")
//    public String updateUser(Integer id,String userName,String userPassword)
//    {
//        User user = new User(id,userName,userPassword);
//        Integer index = userDao.updateById(user);
//        if(index>0){
//            return "修改用户成功，影响行数"+index+"行。";
//        }else{
//            return "修改用户失败，影响行数"+index+"行。";
//        }
//    }
//
//
//    //http://localhost:8888/getUserById?userId=1
//    //根据Id查询User
//    @GetMapping("getUserById")
//    public User getUserById(Integer userId)
//    {
//        return userDao.selectById(userId);
//    }

}
