package com.cn.smart.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ChuangLan
 */
@Data
public class MixDTO  implements Serializable {

    private String name;

    private Integer age;

    private String remark;

    private Double price;
}
