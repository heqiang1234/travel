package com.hq.travel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     用户信息(MyBatisPlus)
 * </pre>
 *
 * @author : saysky
 * @date : 2017/11/14
 */
@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号，自增
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 显示名称
     */
    private String userNickname;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 0 正常
     * 1 禁用
     * 2 已删除
     */
    private Integer userStatus = 0;

    /**
     * 创建时间
     */
    private Date userCreatedTime;
    /**
     * 更新时间
     */
    private Date userUpdatedTime;

}
