import com.scut.mybatis.entity.Department;
import com.scut.mybatis.entity.Employee;
import com.scut.mybatis.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:conf/spring-core.xml"})
public class DepartmentTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testQuery() {
        Department department = departmentService.getDepartmentById(1);
        System.out.println(department);
        for (Employee employee : department.getEmployeeList()) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQuery2() {
        Department department = departmentService.getDepartmentByStep(1);
        System.out.println(department);
        for (Employee employee : department.getEmployeeList()) {
            System.out.println(employee);
        }
    }

    @Test
    public void testAdd() {
        Department department = new Department();
        department.setName("dept1");
        departmentService.addDepartment(department);
        departmentService.addDepartment(department);
    }

    @Test
    public void testDelete() {
        departmentService.deleteDepartment(8);
    }

}
