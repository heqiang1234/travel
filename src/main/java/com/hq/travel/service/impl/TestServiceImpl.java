package com.hq.travel.service.impl;

import com.hq.travel.entity.Test;
import com.hq.travel.mapper.TestMapper;
import com.hq.travel.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public List<Test> getTest() {
        return null;
    }
}
