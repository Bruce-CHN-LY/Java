package jedis.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用druid连接池
 */
public class JDBCUtils {

    /**
     * 静态代码块，用来加载配置文件并初始化连接池
     */
    static {

        try {
            //1.加载配置文件
            Properties pro=new Properties();
            //使用classLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static DataSource ds;
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource()
    {
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection()throws SQLException
    {
        return ds.getConnection();
    }
}
