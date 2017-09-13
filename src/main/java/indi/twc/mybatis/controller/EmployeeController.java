package indi.twc.mybatis.controller;

import indi.twc.mybatis.entity.Employee;
import indi.twc.mybatis.service.EmployeeService;
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
	private static final String listEmployee = "redirect:/employee/list";

	public EmployeeController() {
		System.out.println("EmployeeController...");
	}

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "/employeeAdd";
	}

	@RequestMapping("/add")
	public String add(Employee employee){
		boolean flag = employeeService.addEmployee(employee);
		if(flag){
			return listEmployee;
		}else{
			return "redirect:/employee/toAdd.jsp";
		}
	}

	@RequestMapping("/list")
	public ModelAndView list(){
		List<Employee> employeeList = employeeService.getAllEmployee();
		ModelAndView modelAndView = new ModelAndView("/listEmployee");
		modelAndView.addObject("employeeList", employeeList);
		System.out.println(employeeList);
		return modelAndView;
	}

	@RequestMapping(value="/delEmp/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id){
		 employeeService.deleteEmployee(id);
		 return listEmployee;
	}

	@RequestMapping(value="/toEdit/{id}", method=RequestMethod.GET)
	public ModelAndView toEdit(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("/employeeEdit");
		Employee employee = employeeService.getEmployeeById(id);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Employee employee){
		System.out.println(employee);
		employeeService.updateEmployee(employee);
		return listEmployee;
	}
}
     