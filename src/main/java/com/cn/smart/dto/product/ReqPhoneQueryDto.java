package com.cn.smart.dto.product;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL
 */
@Data
public class ReqPhoneQueryDto implements Serializable {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 是否有货
     */
    private Boolean empty;

    private Date startTime;

    private Date endTime;

    private Integer pageSize;

    private Integer pageNum;
}
