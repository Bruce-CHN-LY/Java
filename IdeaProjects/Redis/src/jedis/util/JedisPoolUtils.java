package jedis.util;

/*
    提供获取连接的工具类
        加载配置文件，配置连接池的参数
        提供获取连接的方法
 */


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;
    /**
     * 获取连接的方法
     */
    static {
        //加载配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("Jedis.Properties");
        //创建properties对象
        Properties pro = new Properties();
        //关联文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal"))); //设置最大连接数量
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));//设置最大存活数

        //初始化jedisPool
        jedisPool=new JedisPool(config,pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }
    public static Jedis getJedis(){

        return jedisPool.getResource();
    }
    public static void closeJedis()
    {
        jedisPool.close();
    }
}
