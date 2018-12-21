package org.yuri.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yurifeng
 * @create 2018-12-20 14:36
 * @package_name org.yuri.test.entity
 * @project_name test
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Address address;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
