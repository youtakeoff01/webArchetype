/*package com.companyname.common.util.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

*//**
 * ��Jackson�����л���Ϊ���ж���
 * ���磬
 * �ų�ֵΪ�����ԡ�
 * �������������
 * ���շ�תΪ�»��ߡ�
 * �������ڸ�ʽ����
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
        // �ų�ֵΪ������  
        setSerializationInclusion(JsonInclude.Include.NON_NULL);  
        // �����������  
        configure(SerializationFeature.INDENT_OUTPUT, true);  
        // ���շ�תΪ�»���  
        if (camelCaseToLowerCaseWithUnderscores) {  
            setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);  
        }  
        // �������ڸ�ʽ��  
        if (StringUtils.isNotEmpty(dateFormatPattern)) {  
            DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);  
            setDateFormat(dateFormat);  
        }  
    } 

}
*/