package com.course.sever;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetCookies {

    @RequestMapping(value = "/getMyCookies",method = RequestMethod.GET)
    public String getMyCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜获得Cookies信息成功";
    }

    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        if (Objects.isNull(cookies)){
            return "没有携带cookies，访问失败";
        }

        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "这是一个必须携带cookies才能访问的get请求";
            }
        }
        return "没有携带cookies，访问失败";
    }

    @RequestMapping(value = "/get/param",method = RequestMethod.GET)
    public Map<String,Integer> getParam(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String,Integer> map = new HashMap<>();
        map.put("鞋子",400);
        map.put("干脆面",1);
        map.put("衬衫",300);
        return map;
    }

    @RequestMapping(value = "/get/param2/{start}/{end}")
    public Map<String,Integer> getParam2(@PathVariable Integer start,
                                         @PathVariable Integer end){
        Map<String,Integer> map = new HashMap<>();
        map.put("鞋子",400);
        map.put("干脆面",1);
        map.put("衬衫",300);
        return map;
    }
}
