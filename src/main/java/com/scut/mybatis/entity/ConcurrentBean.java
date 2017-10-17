package com.scut.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcurrentBean {

    private Integer id;

    private String name;

    private int amount;

    private int version;
}
