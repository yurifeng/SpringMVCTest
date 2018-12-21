package org.yuri.test.converter;

import org.springframework.core.convert.converter.Converter;
import org.yuri.test.entity.Student;

/**
 * @author yurifeng
 * @create 2018-12-21 14:47
 * @package_name org.yuri.test.converter
 * @project_name test
 */
public class MyConverter implements Converter<String, Student> {

    /**
     * 重写convert方法
     *
     * @param string
     * @return
     */
    @Override
    public Student convert(String string) {
        String[] studentStrArr = string.split(" ");
        Student student = new Student();
        student.setId(Integer.parseInt(studentStrArr[0]));
        student.setName(studentStrArr[1]);
        student.setAge(Integer.parseInt(studentStrArr[2]));
        return student;
    }
}
