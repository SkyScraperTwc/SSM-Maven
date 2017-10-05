package com.scut.mybatis.service;

import com.scut.mybatis.mapper.impl.DepartmentMapper;
import com.scut.mybatis.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	public boolean addDepartment(Department department) {
		return departmentMapper.insert(department);
	} 

	public boolean deleteDepartment(Integer id) {
		return  departmentMapper.delete(id);
	}

	public Department getDepartmentById(Integer id) {
		return departmentMapper.getById(id);
	} 

	public boolean updateDepartment(Department department) {
		return departmentMapper.update(department);
	}

	public Department getDepartmentByStep(Integer id){
		return departmentMapper.getByStep(id);
	}
}
