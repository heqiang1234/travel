package com.hq.travel.controller;


import com.hq.travel.entity.Test;
import com.hq.travel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hq
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/travel/test")
public class TestController {

    @Autowired
    @Resource
    private TestService testService;

    @RequestMapping("/getTest")
    public List<Test> getTest()
    {
        return testService.list();
    }
}
