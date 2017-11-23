/*package com.companyname.common.util.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

*//**
 * 对Jackson的序列化行为进行定制
 * 比如，
 * 排除值为空属性、
 * 进行缩进输出、
 * 将驼峰转为下划线、
 * 进行日期格式化等
 * @author Administrator
 *
 *//*
public class CustomObjectMapper extends ObjectMapper{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 2439319518315013961L;
	private boolean camelCaseToLowerCaseWithUnderscores = false;  
    private String dateFormatPattern;  
  
    public void setCamelCaseToLowerCaseWithUnderscores(boolean camelCaseToLowerCaseWithUnderscores) {  
        this.camelCaseToLowerCaseWithUnderscores = camelCaseToLowerCaseWithUnderscores;  
    }  
  
    public void setDateFormatPattern(String dateFormatPattern) {  
        this.dateFormatPattern = dateFormatPattern;  
    }  
  
    public void init() {  
        // 排除值为空属性  
        setSerializationInclusion(JsonInclude.Include.NON_NULL);  
        // 进行缩进输出  
        configure(SerializationFeature.INDENT_OUTPUT, true);  
        // 将驼峰转为下划线  
        if (camelCaseToLowerCaseWithUnderscores) {  
            setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);  
        }  
        // 进行日期格式化  
        if (StringUtils.isNotEmpty(dateFormatPattern)) {  
            DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);  
            setDateFormat(dateFormat);  
        }  
    } 

}
*/