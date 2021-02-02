package com.course.sever;

import com.course.bean.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyPostCookies {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(name="username",required = true) String username,
                        @RequestParam(name = "password",required = true) String password){
        if (username.equals("zhangSan")&&password.equals("123456")){
            Cookie cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功！";
        }
        return "账号或密码错误，登录失败";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public String getUserList (HttpServletRequest request,
                             @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie cookie:cookies){
            if (u.getUsername().equals("zhangSan")
                    && u.getPassword().equals("123456")
                    && u.getSex().equals("man")
                    && cookie.getName().equals("login")
                    && cookie.getValue().equals("true")){

                user = new User();
                user.setUsername("LiSi");
                user.setPassword("123456");
                user.setAge("18");
                user.setSex("男");
                user.setName("李四");
                return user.toString();
            }
        }

        return "登录失败";
    }
}
