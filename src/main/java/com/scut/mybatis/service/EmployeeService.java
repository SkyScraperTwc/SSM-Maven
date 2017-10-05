package com.scut.mybatis.service;

import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.mapper.impl.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;

	public boolean addEmployee(Employee employee) {
		return employeeMapper.insert(employee);
	} 
  
	public List<Employee> getAllEmployee() {
		return employeeMapper.getEmployeeList();
	}
 
	public boolean deleteEmployee(Integer id) {
		return  employeeMapper.delete(id);
	}

	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getById(id);
	}

	public Employee getEmployeeByIdAssociation(Integer id) {
		return employeeMapper.getByAssociation(id);
	}

	public Employee getEmployeeAndDepartByStep(Integer id) {
		return employeeMapper.getByStep(id);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeMapper.update(employee);
	}

	public Employee getEmployeeByIdAndName(Integer id, String name){
		return employeeMapper.getByIdAndName(id,name);
	}

	public Employee getEmployeeByResultMap(Integer id){
		return employeeMapper.getByResultMap(id);
	}
}
