package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

/**
 * Jedis的测试类
 */
public class JedisTest01 {

    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379);
        //2.操作
        jed.set("username","lisi");
        //3.关闭连接
        jed.close();
    }

    @Test
    public void test2(){ //String
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379); //空参数，默认值"localhost",6379;
        //2.操作
        jed.set("username","lisi");
        //获取
        System.out.println(jed.get("username"));
        //可以使用setex()方法存储可以指定过期时间的key value
        jed.setex("activeCode",20,"hehe");//将activeCode键值对写入redis，20秒后过期。
        //3.关闭连接
        jed.close();
    }

    @Test
    public void test3(){ //hash
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379); //空参数，默认值"localhost",6379;
       //2. 存储hash
        jed.hset("User","name","lisi");
        jed.hset("User","age","23");
        jed.hset("User","gender","Male");
        System.out.println(
                        jed.hget("User","name")+":"+
                        jed.hget("User","age")+":"+
                        jed.hget("User","gender"));
        Map<String, String> user = jed.hgetAll("User");
        Set<String> keyset = user.keySet();
        for(String key:keyset)
        {
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
        //3.关闭连接
        jed.close();
    }
    @Test
    public void test4(){ //linkedlist
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379); //空参数，默认值"localhost",6379;
        System.out.println(jed.lrange("user",0,-1));
        String user = jed.rpop("user");
        System.out.println(user);
        //3.关闭连接
        jed.close();
    }

    @Test
    public void test5(){ //集合型Set不允许有重复元素
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379); //空参数，默认值"localhost",6379;
        jed.sadd("skey","123","123");
        Set<String> skey = jed.smembers("skey");
        System.out.println(skey);
        //3.关闭连接
        jed.close();
    }
    @Test
    public void test6(){ //不允许重复元素，且元素有顺序
        //1.获取连接
        Jedis jed = new Jedis("127.0.0.1", 6379); //空参数，默认值"localhost",6379;
        jed.zadd("zkey",100,"234");
        jed.zadd("zkey",100,"234");
        jed.zadd("zkey",100,"345");
        jed.zadd("zkey",100,"456");
        Set<String> zkey = jed.zrange("zkey", 0, -1);
        System.out.println(zkey);
        //3.关闭连接
        jed.close();
    }
    @Test
    public void test7(){ //jedis的连接池
        //0.创建一个配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
      //1.创建连接池对象可无参，也可传入配置文件
        JedisPool jedisPool=new JedisPool(config,"localhost",6379);
        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.set("zhilong","bruce");
        System.out.println(jedis.get("zhilong"));
        //4.归还连接对象到连接池
        jedis.close();
    }
    @Test
    public void test8(){ //工具类测试
       //通过连接池工具类来获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //使用
        jedis.set("Hello","lizhilong");
        System.out.println(jedis.get("Hello"));
        //关闭
        jedis.close();
    }

}
