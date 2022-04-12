package jedis.dao;

import jedis.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findAll();
}
