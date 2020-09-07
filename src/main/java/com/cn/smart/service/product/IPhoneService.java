package com.cn.smart.service.product;

import com.cn.smart.common.PageBean;
import com.cn.smart.dto.product.ReqPhoneQueryDto;
import com.cn.smart.model.product.Phone;

/**
 * @author DELL
 */
public interface IPhoneService {

    PageBean query(ReqPhoneQueryDto phoneQueryDto);

    Phone findById(String id);

    void update(Phone phone);
}
