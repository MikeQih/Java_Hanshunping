package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.EmployeeDAO;
import com.hspedu.mhl.domain.Employee;

/**
 * 该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {
    //定义一个Employee 属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //根据empId和pwd返回一个对象
    //如查询不到，返回null
    public Employee getEmployeeByIdAndPwd(String empId,String pwd){
        Employee employee = employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)",Employee.class,empId,pwd);
        return employee;
    }
}
