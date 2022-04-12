package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonTest {

    //Java对象转为json（字符串）
    @Test
    public void test1() throws Exception {
        //创建person对象
        Person p=new Person();
        p.setAge(23);p.setName("张三");p.setGender("Male");

        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        //3.调用方法转换java对象为json
        /**
         * Mapper转换相关方法
         *  writeValue方法
         *      writeValue(参数1，obj)方法有若干重载形式
         *          参数1：可以为File, 将obj对象转换为json字符串，并保存到指定的文件中。
         *                 Write,    将obj对象转换为json字符串，并将json字符串填充到字符输出流中。
         *                OutputStream 将obj对象转换为json字符串，并将json数据填充到字节输出流中。
         *  writeValueAsString(obj): 将对象转化为json字符串
         */
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }
    @Test
    public void test2() throws Exception {
        //创建person对象
        Person p1=new Person();
        p1.setAge(23);p1.setName("张三");p1.setGender("Male");

        Person p2=new Person();
        p2.setAge(24);p2.setName("李四");p2.setGender("Male");

        Person p3=new Person();
        p3.setAge(23);p3.setName("李思");p3.setGender("Female");

        //创建list集合
        List<Person> a=new ArrayList<>();
        a.add(p1);a.add(p2);a.add(p3);
        //创建jackson核心对象
        ObjectMapper ob=new ObjectMapper();
        //调用方法进行转换
        String s = ob.writeValueAsString(a);
        System.out.println(s);
    }
    @Test
    public void test3() throws Exception {
        //创建person对象
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","Female");

        //创建jackson核心对象
        ObjectMapper ob=new ObjectMapper();
        //调用方法进行转换
        String s = ob.writeValueAsString(map);
        System.out.println(s);
    }
    @Test
    public void test4() throws Exception {
        //初始化Json字符串
        String json="{\"gender\":\"Female\",\"name\":\"张三\",\"age\":23}";
        //创建objceMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //Json转化为person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
