package com.scut.mybatis.dao;

import com.scut.mybatis.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Repository
public interface EmployeeMapper {

    Employee getEmployeeByResultMap(Integer id);

    List<Employee> getEmployeeList();

    Employee getEmployeeById(Integer id);

//    Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee getEmployeeByIdAndLastName(Integer id, String lastName);

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);
}
