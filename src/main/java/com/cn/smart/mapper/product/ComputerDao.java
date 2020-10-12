package com.cn.smart.mapper.product;

import com.cn.smart.model.product.Computer;

public interface ComputerDao {
    int insert(Computer record);

    int insertSelective(Computer record);
}