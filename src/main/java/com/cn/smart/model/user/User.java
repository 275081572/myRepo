package com.cn.smart.model.user;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号(账户名)
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 账户状态	0：已删除  1：使用中 2:已冻结 采用逻辑删除 
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}