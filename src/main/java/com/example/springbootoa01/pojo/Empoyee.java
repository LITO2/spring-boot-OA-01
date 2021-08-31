package com.example.springbootoa01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@NoArgsConstructor   //无参
@Data
public class Empoyee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0: 女 1: 男
    private Department department;
    private Date birth;

    public Empoyee(Integer id,String lastName,String email,Integer gender,Department department){
        this.id=id;
        this.lastName=lastName;
        this.email=email;
        this.gender=gender;
        this.department=department;
        this.birth=new Date(); //使用默认创建日期
    }

}



