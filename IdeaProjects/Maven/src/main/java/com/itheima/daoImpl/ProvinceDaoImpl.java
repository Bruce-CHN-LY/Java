package com.itheima.daoImpl;

import com.itheima.dao.ProvinceDao;
import com.itheima.domain.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    @Override
    public List<Province> findAll() throws Exception {
        List<Province> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //加载驱动累
        try {
            //获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///Case13","root","yuc46938");
            //获取操作数据库的对象
            ps = conn.prepareStatement("select * from Province");
            //执行查询工作
            rs = ps.executeQuery();
            while (rs.next())
            {
                Province province=new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("Name"));
                list.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return list;
    }
}
