package com.hq.travel.service;

import com.hq.travel.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hq
 * @since 2019-12-10
 */
public interface TestService extends IService<Test> {

      public List<Test> getTest();
}
