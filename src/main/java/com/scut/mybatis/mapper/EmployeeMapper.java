package com.scut.mybatis.mapper;

import com.scut.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    Employee getEmployeeByResultMap(Integer id);

    List<Employee> getEmployeeList();

    Employee getEmployeeById(Integer id);

    Employee getEmployeeByIdAssociation(Integer id);

    Employee getEmployeeByIdAndName(@Param("id") Integer id, @Param("name") String name);

    Employee getEmployeeAndDepartByStep(Integer id);

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    List<Employee> getEmployeeListByDeptId(Integer id);
}
