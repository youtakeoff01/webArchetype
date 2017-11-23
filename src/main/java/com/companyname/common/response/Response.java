package com.companyname.common.response;

import java.io.Serializable;

import com.companyname.common.util.json.JsonUtils;

/**
 * Rest api 统一响应类
 * @author Administrator
 *
 */
public class Response implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8507037213150654617L;
	private static final String OK = "ok";  
    private static final String ERROR = "error";
    
    private Meta meta;  
    private Object data;
    
    public Response success() {  
        this.meta = new Meta(true, OK);  
        return this;  
    }  
  
    public Response success(Object data) {  
        this.meta = new Meta(true, OK);  
        this.data = data;  
        return this;  
    }  
  
    public Response failure() {  
        this.meta = new Meta(false, ERROR);  
        return this;  
    }  
  
    public Response failure(String message) {  
        this.meta = new Meta(false, message);  
        return this;  
    }
    
    public Meta getMeta() {  
        return meta;  
    }  
  
    public Object getData() {  
        return data;  
    }  
  
    public class Meta {  
  
        private boolean boo;  
        private String message;  
  
        public Meta(boolean boo) {  
            this.boo = boo;  
        }  
  
        public Meta(boolean boo, String message) {  
            this.boo = boo;  
            this.message = message;  
        }  
  
        public boolean isSuccess() {  
            return boo;  
        }  
  
        public String getMessage() {  
            return message;  
        }  
    }
    
    @Override
    public String toString() {
    	return JsonUtils.toJson(this);
    }
}
