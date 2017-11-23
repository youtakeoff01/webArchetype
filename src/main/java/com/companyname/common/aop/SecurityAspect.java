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
		// ���е��ϻ�ȡĿ�귽��
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		// ��Ŀ�귽�������˰�ȫ�Լ�飬��ֱ�ӵ���Ŀ�귽��
		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return pjp.proceed();
		}
		// �� request header �л�ȡ��ǰ token
		String token = request.getHeader(tokenName);
		// ��� token ��Ч��
		if (!tokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}
		// ����Ŀ�귽��
		return pjp.proceed();
	}
}