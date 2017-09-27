package com.scut.mybatis.dao;

import com.scut.mybatis.entity.Department;

public interface DepartmentMapper {

    Department getDepartmentById(Integer id);

    Department getDepartmentByIdPlus(Integer id);

    Department getDepartmentByStep(Integer id);

    boolean addDepartment(Department department);

    boolean updateDepartment(Department department);

    boolean deleteDepartment(Integer id);
}
