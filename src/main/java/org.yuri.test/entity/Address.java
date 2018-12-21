package org.yuri.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yurifeng
 * @create 2018-12-20 14:39
 * @package_name org.yuri.test.entity
 * @project_name test
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String homeAddress;
    private String schoolAddress;
}
