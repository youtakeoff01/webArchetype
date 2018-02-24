package com.companyname.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.common.response.Response;
import com.companyname.entity.User;

@RestController
@RequestMapping(value = "/myController/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {
	@RequestMapping(value = "login",method = RequestMethod.POST)
    public Response Save(@RequestBody @Valid User user,HttpServletRequest request,HttpServletResponse response) throws Exception{ // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
		HttpSession session = request.getSession(true);
		Response result = new Response();
         if("yixing".equals(user.getName()) && "123456".equals(user.getPwd())) {
        	 user.setCreatTime(new Date());
        	 result.success(user);
        	 session.setAttribute("user", user);
         }else {
        	 result.failure("用户名或密码错误！");
         }
         System.out.println(result.toString());
		return result;
    }

}
