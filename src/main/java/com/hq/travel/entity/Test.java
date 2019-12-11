package com.hq.travel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hq
 * @since 2019-12-06
 */
@Data
@TableName("travel_test")
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    private String te;

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Test{" +
            "te=" + te +
        "}";
    }
}
