package com.hq.travel.dao;

import com.hq.travel.entity.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hq
 * @since 2019-12-10
 */
@Mapper
@Repository
public interface TestDao extends BaseMapper<Test> {
}
