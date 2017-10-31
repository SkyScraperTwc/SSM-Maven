package com.scut.mybatis.service;

import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.mapper.impl.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional(rollbackFor = Exception.class)
@Service
public class EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;

	public boolean addEmployee(Employee employee) throws Exception {
		boolean result = employeeMapper.insert(employee);
		throw new Exception("addEmployee error!!!");
//		int a = 1/0;//RuntimeException,Spring默认回滚异常
//		return result;
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
