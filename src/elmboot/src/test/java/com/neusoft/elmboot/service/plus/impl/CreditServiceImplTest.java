package com.neusoft.elmboot.service.plus.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.elmboot.mapper.plus.CreditMapper;
import com.neusoft.elmboot.po.domain_plus.vo.EfficientCreditVo;
import com.neusoft.elmboot.service.plus.CreditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditServiceImplTest {

    @Autowired
    private CreditMapper creditMapper;

    @Test
    public void listEfficientCreditByIdTest(String userId) {
        userId = "1895";
        Integer page=1;//设置当前页
        Integer pageSize=1;//设置每页的条数
        PageHelper.startPage(page,pageSize);//开启分页查询
        List<EfficientCreditVo> all = creditMapper.listEfficientCreditById(userId);
        //将查询的page对象（page对象继承了ArrayList类）封装到PageInfo下就可以获取分页的各种数据
        PageInfo<EfficientCreditVo> pageInfo = new PageInfo<>(all);
        int pageNum = pageInfo.getPageNum();//获取当前页
        int pages = pageInfo.getPages();//获取总页数
        int pageSize1 = pageInfo.getPageSize();//获取每页大小
        int size = pageInfo.getSize();//获取当前页的记录数
        long total = pageInfo.getTotal();//获取总记录数
        List<EfficientCreditVo> list = pageInfo.getList();//获取当前页的内容
        System.out.println(list.size());
    }
}