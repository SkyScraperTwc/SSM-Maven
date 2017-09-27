package com.scut.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Integer id;

    private String deptName;

    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employeeListSize=" + employeeList.size() +
                '}';
    }
}
