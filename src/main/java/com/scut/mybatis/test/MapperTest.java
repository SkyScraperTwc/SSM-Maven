package com.scut.mybatis.test;

import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:conf/spring-core.xml"})
public class MapperTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test() {
        Employee employee = employeeService.getEmployeeById(5);
        System.out.println(employee);
    }

    @Test
    public void test2() {
        Employee employee = employeeService.getEmployeeByIdAndLastName(5,"qwe1");
        System.out.println(employee);
    }
    @Test
    public void test3() {
        Employee employee = employeeService.getEmployeeByResultMap(5);
        System.out.println(employee);
    }

    @Test
    public void testAdd() {
        Employee employee = new Employee();
        employee.setEmail("email1");
        employee.setName("twc");
        employee.setGender("male");
        employeeService.addEmployee(employee);
    }
}
