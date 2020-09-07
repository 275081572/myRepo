package com.cn.smart.mapper.product;

import com.cn.smart.dto.product.ReqPhoneQueryDto;
import com.cn.smart.model.product.Phone;

import java.util.List;

public interface PhoneDao {
    int deleteByPrimaryKey(String id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);

    List<Phone> query(ReqPhoneQueryDto phoneQueryDto);
}