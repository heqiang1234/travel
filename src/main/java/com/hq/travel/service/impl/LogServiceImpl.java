package com.hq.travel.service.impl;

import com.hq.travel.dao.LogDao;
import com.hq.travel.entity.Log;
import com.hq.travel.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 言曌
 * @date 2019-08-19 21:51
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    @Resource
    private LogDao logDao;

    @Override
    public Integer insert(Log log) {
        return logDao.insert(log);
    }
}
