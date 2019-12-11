package com.hq.travel.service.impl;

import com.hq.travel.dao.TestDao;
import com.hq.travel.entity.Test;
import com.hq.travel.mapper.TestMapper;
import com.hq.travel.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2019-12-10
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements TestService {

    @Autowired
    @Resource
    private TestDao testDao;

    @Override
    public List<Test> getTest() {
        return testDao.selectList(null);
    }
}
