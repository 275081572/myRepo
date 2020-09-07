package com.cn.smart.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DELL
 */
@Data
public class PageBean implements Serializable {

    private Object data;

    private Long totalNum;

    private Integer tatolPage;
}
