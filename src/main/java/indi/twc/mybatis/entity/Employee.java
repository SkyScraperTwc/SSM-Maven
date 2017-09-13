package indi.twc.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
        private Integer id;

        private String last_name;

        private String email;

        private String gender;
}