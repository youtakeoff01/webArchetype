package com.companyname.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.companyname.common.annotation.NotEmpty;
@Entity
public class User implements Serializable {
    /**
     * @author zjn
     */
    private static final long serialVersionUID = 1L;
    private Integer id; // id
    @NotEmpty
    private String name; // name
    private String pwd; // pwd
    private Integer age; // age
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creatTime; // creatTime

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

}