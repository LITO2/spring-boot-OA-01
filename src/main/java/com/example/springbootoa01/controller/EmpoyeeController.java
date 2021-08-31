package com.example.springbootoa01.controller;

import com.example.springbootoa01.dao.EmpoyeeDao;
import com.example.springbootoa01.pojo.Empoyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpoyeeController {

    @Autowired
    EmpoyeeDao empoyeeDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Empoyee> empoyees = empoyeeDao.getAll();
        model.addAttribute("emps",empoyees);
        return "emp/list";
    }
}
