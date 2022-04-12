package jedis.dao.impl;

import jedis.dao.ProvinceDao;
import jedis.domain.Province;
import jedis.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    //1.声明一个成员变量jdbcTemplement
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        //1.定义SQL
        String sql="Select * from province";
        //2.执行sql
        List<Province> query = template.query(sql,new BeanPropertyRowMapper<>(Province.class));
        return query;
    }
}
