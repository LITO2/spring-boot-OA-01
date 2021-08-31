package com.example.springbootoa01.dao;

import com.example.springbootoa01.pojo.Department;
import com.example.springbootoa01.pojo.Empoyee;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
//员工dao
@Repository
public class EmpoyeeDao {
    //模拟数据库中数据
    private static Map<Integer,Empoyee> empoyees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        empoyees = new HashMap<Integer,Empoyee>(); //创建一个员工表

        empoyees.put(1001,new Empoyee( 1001, "张三", "123@qq.com", 1,new Department( 101, "信息科技部")));
        empoyees.put(1002,new Empoyee( 1002, "李四", "123@qq.com", 1,new Department( 102, "个金部")));
        empoyees.put(1003,new Empoyee( 1003, "王五", "123@qq.com", 1,new Department( 103, "网金部")));
        empoyees.put(1004,new Empoyee( 1004, "赵六", "123@qq.com", 1,new Department( 104, "渠道部")));
        empoyees.put(1005,new Empoyee( 1005, "钱七", "123@163.com",1,new Department( 105, "信用卡部")));
    }

    //主键自增
    private static Integer initId =1006;
    //增加一个员工
    //从前端传来的部门id获取全部部门信息set进员工对象
    public void save(Empoyee empoyee){
        if(empoyee.getId()==null){
            empoyee.setId(initId++);
        }
        empoyee.setDepartment(departmentDao.getDepartmentsbyId(empoyee.getDepartment().getId()));
        empoyees.put(empoyee.getId(),empoyee);
    }

    //查询全部员工信息
    public Collection<Empoyee> getAll(){
        return empoyees.values();
    }

    //通过id查询员工信息
    public Empoyee getEmpoyeeById(Integer id){
        return empoyees.get(id);
    }

    //通过id删除员工信息
    public void delete(Integer id){
        empoyees.remove(id);
    }
}
