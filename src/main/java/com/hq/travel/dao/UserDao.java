package com.hq.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hq.travel.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuyanzhao
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 查询所有
     *
     * @param page
     * @return 用户列表
     */
    List<User> findAll(Page page);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}

