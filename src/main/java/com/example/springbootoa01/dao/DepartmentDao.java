package com.example.springbootoa01.dao;

import com.example.springbootoa01.pojo.Department;
import com.example.springbootoa01.pojo.Empoyee;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import org.springframework.stereotype.Repository;

//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库中数据
    private static Map<Integer,Department> Departments = null;
    static{
        Departments = new HashMap<Integer,Department>(); //创建一个部门表

        Departments.put(101,new Department( 101, "信息科技部"));
        Departments.put(102,new Department( 102, "个金部"));
        Departments.put(103,new Department( 103, "网金部"));
        Departments.put(104,new Department( 104, "渠道部"));
        Departments.put(105,new Department( 105, "信用卡部"));

    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return Departments.values();
    }

    //通过id得到部门
    public Department getDepartmentsbyId(Integer id){
        return Departments.get(id);
    }
}
