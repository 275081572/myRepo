package com.cn.smart.jpa.entity.user;

import com.cn.smart.jpa.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    @Column(columnDefinition = "varchar(50) comment '名字'")
    private String name;

    @Column(columnDefinition = "tinyint comment '账户状态	0：已删除  1：使用中 2:已冻结 采用逻辑删除 '")
    private int status;
}
