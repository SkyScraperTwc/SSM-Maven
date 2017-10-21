
import com.scut.mybatis.entity.Department;
import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:conf/spring-core.xml"})
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testQuery() {
        Employee employee = employeeService.getEmployeeById(3);
        System.out.println(employee);
    }

    @Test
    public void testQuery2() {
        Employee employee = employeeService.getEmployeeByIdAssociation(3);
        System.out.println(employee);
    }

    @Test
    public void testQuery3() {
        Employee employee = employeeService.getEmployeeAndDepartByStep(3);
        System.out.println(employee);
    }

    @Test
    public void testQuery4() {
        Employee employee = employeeService.getEmployeeByIdAndName(1,"twc");
        System.out.println(employee);
    }
    @Test
    public void testQuery5() {
        Employee employee = employeeService.getEmployeeByResultMap(5);
        System.out.println(employee);
    }

    @Test
    public void testAdd() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("email1");
        employee.setName("twc");
        employee.setGender("male");

        Department department = new Department();
        department.setId(4);

        employee.setDepartment(department);
        employeeService.addEmployee(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmail("email1");
        employee.setName("twc32");
        employee.setGender("femail");

        Department department = new Department();
        department.setId(6);

        employee.setDepartment(department);
        employeeService.updateEmployee(employee);
    }

    @Test
    public void testDelete() {
        employeeService.deleteEmployee(2);
    }
}
