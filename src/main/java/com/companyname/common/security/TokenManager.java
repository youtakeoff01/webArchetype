package com.companyname.common.security;

public interface TokenManager {
	String createToken(String username);  
	  
    boolean checkToken(String token);  

}
