package com.companyname.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.companyname.common.response.Response;
import com.companyname.entity.User;

@RestController
@RequestMapping(value = "/hueTestController/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class App {
	@RequestMapping(value = "save",method = RequestMethod.POST)
    public String Save(@RequestBody User user,HttpServletResponse response) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        String json = JSONObject.toJSONString(user);
		return json;
    }
	
	@RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)  
    public Response getAdvertiser(@PathVariable("id") String advertiserId) {  
		
		return null;
    }  
}
