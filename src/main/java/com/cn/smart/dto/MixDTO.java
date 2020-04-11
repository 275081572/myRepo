package com.cn.smart.dto;

import com.chuanglan.platform.rocketmqplugin.message.msgformat.BaseMsg;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ChuangLan
 */
@Data
public class MixDTO extends BaseMsg implements Serializable {

    private String name;

    private Integer age;

    private String remark;

    private Double price;
}
