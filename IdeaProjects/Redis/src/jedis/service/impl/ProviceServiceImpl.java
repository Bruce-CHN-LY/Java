package jedis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jedis.dao.ProvinceDao;
import jedis.dao.impl.ProvinceDaoImpl;
import jedis.domain.Province;
import jedis.service.ProvinceService;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ProviceServiceImpl implements ProvinceService {
    //声明DAO
    private ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        /**
         * 使用redis缓存
         *
         */
        //1.从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        //2.查询
        String province_json = jedis.get("province");
        //3.判断Provice_json是否为null
        if(province_json==null||province_json.length()==0){
            //redis缓存中没有数据，需要查询数据库
            System.out.println("redis中没数据，查询数据库....");
            List<Province> ps = dao.findAll();
            //将List序列化为json并且存入jedis
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json存入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }
        else {
            System.out.println("redis中包含有数据，查询redis缓存....");
        }
        return province_json;
    }
}
