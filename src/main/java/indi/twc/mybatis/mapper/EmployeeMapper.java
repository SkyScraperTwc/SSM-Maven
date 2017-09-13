package indi.twc.mybatis.mapper;

import indi.twc.mybatis.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

@Repository
public interface EmployeeMapper {

    Employee getEmployeeByResultMap(Integer id);

    @MapKey("id")
    Map<Integer, Object> getEmployeeMapByLastName(String last_name);

    List<Employee> getEmployeeList();

    Employee getEmployeeById(Integer id);

    Employee getEmployeeByMap(Map<String, Object> map);

    Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName") String last_name);

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);
}
