package indi.twc.mybatis.service;

import indi.twc.mybatis.entity.Employee;
import indi.twc.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeService() {
		System.out.println("EmployeeService...");
	}
	
	public boolean addEmployee(Employee employee) {
		return  employeeMapper.addEmployee(employee);
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

	public boolean updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}
	
}
