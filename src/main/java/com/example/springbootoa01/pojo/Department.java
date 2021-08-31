package com.example.springbootoa01.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//部门表
@NoArgsConstructor   //无参
@AllArgsConstructor  //有参
@Data
public class Department {

    private Integer id;
    private String departmentName;
}




