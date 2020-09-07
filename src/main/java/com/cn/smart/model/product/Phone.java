package com.cn.smart.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * phone
 * @author 
 */
@Data
public class Phone implements Serializable {
    private String id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 型号
     */
    private String model;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 是否有货
     */
    private Boolean empty;

    /**
     * 上架日期
     */
    private Date saleDate;

    private static final long serialVersionUID = 1L;
}