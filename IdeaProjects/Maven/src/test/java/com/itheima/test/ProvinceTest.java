package com.itheima.test;

import com.itheima.dao.ProvinceDao;
import com.itheima.daoImpl.ProvinceDaoImpl;
import com.itheima.domain.Province;
import org.junit.Test;

import java.util.List;

public class ProvinceTest {
    @Test
    public void findAll() throws Exception {
        ProvinceDao provinceDao=new ProvinceDaoImpl();
        List<Province> all = provinceDao.findAll();
        for(Province province:all)
        {
            System.out.println(province.toString());
        }
    }
}
