package org.yuri.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;
import java.util.Date;

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

    @NumberFormat(pattern = "###,#")
    private Integer id;
    private String name;
    private Integer age;
    private Address address;

    @Email
    private String email;

    @Past/*此校验验证输入时间必须是现在时间之前*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")/*该注解是格式化前端输入的数据(前端要按照pattern里面的格式填写)*/
    private Date birthday;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
