package com.scut.mybatis.service;

import com.scut.mybatis.mapper.DepartmentMapper;
import com.scut.mybatis.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	public boolean addDepartment(Department department) {
		return departmentMapper.addDepartment(department);
	} 

	public List<Department> getDepartmentList() {
		return departmentMapper.getDepartmentList();
	}
 
	public boolean deleteDepartment(Integer id) {
		return  departmentMapper.deleteDepartment(id);
	}

	public Department getDepartmentById(Integer id) {
		return departmentMapper.getDepartmentById(id);
	} 

	public boolean updateDepartment(Department department) {
		return departmentMapper.updateDepartment(department);
	}

	public Department getDepartmentByIdPlus(Integer id){
		return departmentMapper.getDepartmentByIdPlus(id);
	}

	public Department getDepartmentByStep(Integer id){
		return departmentMapper.getDepartmentByStep(id);
	}
}
