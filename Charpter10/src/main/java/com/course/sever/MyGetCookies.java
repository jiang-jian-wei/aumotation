package com.course.sever;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyGetCookies {

    @RequestMapping(value = "/getMyCookies",method = RequestMethod.GET)
    public String getMyCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("aaa","bbb");
        response.addCookie(cookie);
        return "恭喜获得Cookies信息成功";
    }
}
