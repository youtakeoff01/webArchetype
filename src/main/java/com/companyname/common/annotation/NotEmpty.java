package com.companyname.common.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * �Դ��ݹ����Ĳ�����aop������ֵ�ж�
 * 
 * @author youtakeoff
 *
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmpty.NotEmptyValidator.class)
@Documented
public @interface NotEmpty {

	String message() default "not_empty";
	Class<?>[] groups() default {};  
	  
    Class<? extends Payload>[] payload() default {}; 

	class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {  
		  
	    @Override  
	    public void initialize(NotEmpty constraintAnnotation) {  
	    }  
	  
		@SuppressWarnings("rawtypes")
		@Override  
	    public boolean isValid(Object value, ConstraintValidatorContext context) { 
			if(value == null) {
				return false;
			}
	    	if(value instanceof String) {
	    		return StringUtils.isNotEmpty((String)value);
	    	}
	    	if(value instanceof Collection) {
	    		return CollectionUtils.isNotEmpty((Collection)value);
	    	}
	        return true;  
	    }  
	} 
	
}
