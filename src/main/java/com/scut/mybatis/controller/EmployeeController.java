package com.scut.mybatis.controller;

import com.scut.mybatis.constant.PageReturnConst;
import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/toAdd")
	public String toAdd(){
		return PageReturnConst.JSP_EMPLOYEE_ADD;
	}

	@RequestMapping("/add")
	public String add(Employee employee){
		employeeService.addEmployee(employee);
		return PageReturnConst.REDIRECT_EMPLOYEE_LIST;
	}

	@RequestMapping("/list")
	public ModelAndView list(){
		List<Employee> employeeList = employeeService.getAllEmployee();
		ModelAndView modelAndView = new ModelAndView(PageReturnConst.JSP_EMPLOYEE_LIST);
		modelAndView.addObject("employeeList", employeeList);
		System.out.println(employeeList);
		return modelAndView;
	}

	@RequestMapping(value="/delEmp/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id){
		 employeeService.deleteEmployee(id);
		 return PageReturnConst.REDIRECT_EMPLOYEE_LIST;
	}

	@RequestMapping(value="/toEdit/{id}", method=RequestMethod.GET)
	public ModelAndView toEdit(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(PageReturnConst.JSP_EMPLOYEE_EDIT);
		Employee employee = employeeService.getEmployeeById(id);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Employee employee){
		employeeService.updateEmployee(employee);
		return PageReturnConst.REDIRECT_EMPLOYEE_LIST;
	}
}
     