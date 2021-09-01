package com.example.springbootoa01.controller;

import com.example.springbootoa01.dao.DepartmentDao;
import com.example.springbootoa01.dao.EmpoyeeDao;
import com.example.springbootoa01.pojo.Department;
import com.example.springbootoa01.pojo.Empoyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Collection;

@Controller
public class EmpoyeeController {

    @Autowired
    EmpoyeeDao empoyeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Empoyee> empoyees = empoyeeDao.getAll();
        model.addAttribute("emps",empoyees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAddpage(Model model){
        //查出部门所有信息
        Collection<Department> department= departmentDao.getDepartments();
        model.addAttribute("department" ,department);
        return "emp/add";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Empoyee empoyees){
        System.out.println("save===="+empoyees);
        empoyeeDao.save(empoyees);
        //添加的操作
        return "redirect:/emps";
    }

    //员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        System.out.println("测试信息--修改的员工id ："+id);
        //根据id查询用户数据
        Empoyee empoyees = empoyeeDao.getEmpoyeeById(id);
        //将员工数据返回到前端
        model.addAttribute("emp",empoyees);
        Collection<Department> department= departmentDao.getDepartments();
        model.addAttribute("department" ,department);
        return "emp/update";
    }

    //处理修改的请求
        @PostMapping("/updateEmp")
        public String updateEmp (Empoyee empoyees) {
            //保存到数据中
            empoyeeDao.save(empoyees);
            //回到员工列表，转发，重定向
            return "redirect:/emps";
        }

    //删除员工
    @RequestMapping("/deleteEmp/{id}")
    public  String deleteEmp(@PathVariable("id")Integer id){
        //删除员工
        empoyeeDao.delete(id);
        //回到员工列表，转发，重定向
        return  "redirect:/emps";
    }


}
