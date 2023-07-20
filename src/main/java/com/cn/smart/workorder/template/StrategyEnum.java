package com.cn.smart.workorder.template;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

public enum StrategyEnum {

    XSD(0),

    XMD(1),

    GD(2);

    private Integer type;

    StrategyEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
