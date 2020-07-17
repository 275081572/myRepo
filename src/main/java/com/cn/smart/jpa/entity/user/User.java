package com.cn.smart.jpa.entity.user;

import com.cn.smart.jpa.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Column(columnDefinition = "varchar(50) comment '名字'")
    private String name;

    @Column(columnDefinition = "varchar(11) comment '手机号(账户名)'")
    private String phone;

    @Column(columnDefinition = "varchar(50) comment '邮箱'")
    private String email;

    @Column(columnDefinition = "tinyint comment '账户状态	0：已删除  1：使用中 2:已冻结 采用逻辑删除 '")
    private int status;

    @Column(columnDefinition = "varchar(100) comment '密码'")
    private String password;

    @Column(columnDefinition = "varchar(255) comment '备注'")
    private String remark;

}
