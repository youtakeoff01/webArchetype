package com.companyname.common.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.companyname.common.annotation.IgnoreSecurity;
import com.companyname.common.exception.TokenException;
import com.companyname.common.security.TokenManager;
public class SecurityAspect {

	private static final String DEFAULT_TOKEN_NAME = "X-Token";

	private TokenManager tokenManager;
	private String tokenName;

	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

	public void setTokenName(String tokenName) {
		if (StringUtils.isEmpty(tokenName)) {
			tokenName = DEFAULT_TOKEN_NAME;
		}
		this.tokenName = tokenName;
	}

	public Object execute(ProceedingJoinPoint pjp) throws Throwable {
		Object[] obj = pjp.getArgs();
		HttpServletRequest request = (HttpServletRequest) obj[1];
		// 从切点上获取目标方法
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		// 若目标方法忽略了安全性检查，则直接调用目标方法
		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return pjp.proceed();
		}
		// 从 request header 中获取当前 token
		String token = request.getHeader(tokenName);
		// 检查 token 有效性
		if (!tokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}
		// 调用目标方法
		return pjp.proceed();
	}
}