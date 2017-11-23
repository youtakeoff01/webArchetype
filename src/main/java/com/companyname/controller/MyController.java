package com.companyname.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
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
    public Response Save(@RequestBody @Valid User user,HttpServletResponse response) throws Exception{ // user:��ͼ�㴫�����Ʋ�ı�����model�����Ʋ㷵�ظ���ͼ��Ķ���
        Response result = new Response();
         if("yixing".equals(user.getName()) && "123456".equals(user.getPwd())) {
        	 user.setCreatTime(new Date());
        	 result.success(user);
         }else {
        	 result.failure("�û������������");
         }
         System.out.println(result.toString());
		return result;
    }
	

}
