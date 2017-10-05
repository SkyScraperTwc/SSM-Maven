package com.scut.mybatis.mapper;

import com.scut.mybatis.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    Department getDepartmentById(Integer id);

    Department getDepartmentByIdPlus(Integer id);

    Department getDepartmentByStep(Integer id);

    List<Department> getDepartmentList();

    boolean addDepartment(Department department);

    boolean updateDepartment(Department department);

    boolean deleteDepartment(Integer id);
}
