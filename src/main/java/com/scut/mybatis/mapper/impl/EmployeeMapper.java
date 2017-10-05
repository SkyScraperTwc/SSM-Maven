package com.scut.mybatis.mapper.impl;

import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper extends IBaseMapper<Employee> {

    Employee getByResultMap(Integer id);

    List<Employee> getEmployeeList();

    Employee getByAssociation(Integer id);

    Employee getByIdAndName(@Param("id") Integer id, @Param("name") String name);

    List<Employee> getEmployeeListByDeptId(Integer id);
}
