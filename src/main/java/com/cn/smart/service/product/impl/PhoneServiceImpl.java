package com.cn.smart.service.product.impl;

import com.cn.smart.common.PageBean;
import com.cn.smart.dto.product.ReqPhoneQueryDto;
import com.cn.smart.mapper.product.PhoneDao;
import com.cn.smart.model.product.Phone;
import com.cn.smart.service.product.IPhoneService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DELL
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PhoneServiceImpl implements IPhoneService {

    @Resource
    private PhoneDao phoneDao;

    @Override
    public PageBean query(ReqPhoneQueryDto phoneQueryDto) {
        //分页
        Page<Object> page = PageHelper.startPage(phoneQueryDto.getPageNum(), phoneQueryDto.getPageSize(), true);
        List<Phone> list = phoneDao.query(phoneQueryDto);
        PageBean pageBean = new PageBean();
        pageBean.setData(list);
        pageBean.setTotalNum(page.getTotal());
        pageBean.setTatolPage(page.getPages());
        return pageBean;
    }

    @Override
    public Phone findById(String id) {
        return phoneDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(Phone phone) {
        phoneDao.updateByPrimaryKeySelective(phone);
    }

}
