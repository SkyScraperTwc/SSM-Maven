package com.scut.mybatis.service;

import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;

	public boolean addEmployee(Employee employee) {
		return employeeMapper.addEmployee(employee);
	} 
  
	public List<Employee> getAllEmployee() {
		return employeeMapper.getEmployeeList();
	}
 
	public boolean deleteEmployee(Integer id) {
		return  employeeMapper.deleteEmployee(id);
	}

	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}

	public Employee getEmployeeByIdAssociation(Integer id) {
		return employeeMapper.getEmployeeByIdAssociation(id);
	}

	public Employee getEmployeeAndDepartByStep(Integer id) {
		return employeeMapper.getEmployeeAndDepartByStep(id);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}

	public Employee getEmployeeByIdAndName(Integer id, String name){
		return employeeMapper.getEmployeeByIdAndName(id,name);
	}

	public Employee getEmployeeByResultMap(Integer id){
		return employeeMapper.getEmployeeByResultMap(id);
	}
}
