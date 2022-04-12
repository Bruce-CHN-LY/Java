package Project;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkUser")
public class checkUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        Map<String,Object> map=new HashMap<>();
        //2.调用service层判断用户名是否存在
        if("tom".equals(username))
        {
            //存在
            map.put("userExsit",true);
            map.put("msg","此用户名以存在，请更换后重试");
        }
        else
        {
            //不存在
            map.put("userExist",false);
            map.put("msg","此用户可以被使用");
        }
        //将map集合转换为json
        ObjectMapper ob=new ObjectMapper();
        ob.writeValue(resp.getWriter(),map); //将数据转化，并且发送给客户端
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
