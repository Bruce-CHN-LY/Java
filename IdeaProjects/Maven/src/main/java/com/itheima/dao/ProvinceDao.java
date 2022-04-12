package com.itheima.dao;

import com.itheima.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findAll() throws Exception;
}
