package com.cn.smart.test;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * 门店报表数据，库存&交易成本Dto
 * 
 * @author yuli
 * @date 2021/03/17
 */
@Data
@ToString(callSuper = true)
public class TrsPriceDto {

    public TrsPriceDto(String refNo, String docType){
        this.refNo = refNo;
        this.docType = docType;
    }

    /**
     * @Fields: serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 交易id
     */
    private Long trsId;

    /**
     * 业务类型，交易类型_type值
     */
    private String docType;

    /**
     * 业务类型名称
     */
    private String docTypeName;

    /**
     * 业务单号
     */
    private String doc;

    /**
     * 关联单号
     */
    private String refNo;

    /**
     * 源仓库ID
     */
    private String sourceWarehouseId;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 源商品ID
     */
    private String sourceSkuId;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 交易数量
     */
    private BigDecimal qty;

    /**
     * 交易单价
     */
    private BigDecimal price;

    /**
     * 期末库存
     */
    private BigDecimal finalQty;

    /**
     * 期末单价
     */
    private BigDecimal finalPrice;

    /**
     * 交易时间
     */
    private Date trsDate;

    /**
     * 期初库存
     */
    private BigDecimal initQty;

    /**
     * 期初单价
     */
    private BigDecimal initPrice;

    /**
     * 期初金额
     */
    private BigDecimal initTotal;

    /**
     * 结余金额
     */
    private BigDecimal remainTotal;

}
