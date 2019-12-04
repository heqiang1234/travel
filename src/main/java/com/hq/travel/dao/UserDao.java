package com.hq.travel.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hq.travel.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
     List<User> getUserList();
}
