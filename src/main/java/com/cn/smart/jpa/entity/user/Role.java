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

    @Column(columnDefinition = "varchar(50) comment '授权信息'")
    private String authority;
}
