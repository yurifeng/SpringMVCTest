package org.yuri.test.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yuri.test.entity.Student;

import javax.validation.Valid;
import java.io.*;
import java.util.Map;

/**
 * @author yurifeng
 * @create 2018-12-20 10:12
 * @package_name org.yuri.test.controller
 * @project_name test
 */
@Controller
@RequestMapping("Controller")
//@SessionAttributes(value = "student,address")/*该注解就是将value值填充到session中(按照名称加入)**/
//@SessionAttributes(types = {Student.class, Address.class})/*将types中的类型加入到session中(按照类型加入)**/
public class HomeController {

    @RequestMapping("welcome")
    public String welcome() {
        return "home";
    }


    @RequestMapping(value = "welcome001/{id}", method = RequestMethod.POST)
    public String zeng(@PathVariable("id") Integer id) {
        System.out.println("增:----->" + id);
        return "home";
    }

    @RequestMapping(value = "welcome001/{id}", method = RequestMethod.DELETE)
    public String shan(@PathVariable("id") Integer id) {
        System.out.println("删:----->" + id);
        return "home";
    }

    @RequestMapping(value = "welcome001/{id}", method = RequestMethod.PUT)
    public String gai(@PathVariable("id") Integer id) {
        System.out.println("改:----->" + id);
        return "home";
    }

    @RequestMapping(value = "welcome001/{id}", method = RequestMethod.GET /*method = RequestMethod.POST只接受POST请求**/)
    public String cha(@PathVariable("id") Integer id) {
        System.out.println("查:----->" + id);
        return "home";
    }

    @RequestMapping(value = "testParam")
    public String testParam(@RequestParam(value = "uname") String name, @RequestParam(value = "uage", required =
            false) Integer age) {
        System.out.println("name:--->" + name);
        System.out.println("age:--->" + age);
        return "home";
    }

    /**
     * 使用@RequsetHeader获取请求头信息
     *
     * @param environment
     * @return
     */
    @RequestMapping(value = "testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "User-Agent") String environment) {
        System.out.println("用户环境:------>" + environment);
        return "home";
    }

    /**
     * 使用@CookieValue获取JSESSIONID值
     *
     * @param jsessionId
     * @return
     */
    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jsessionId) {
        System.out.println("JESESSIONID:--->" + jsessionId);
        return "home";
    }

    /**
     * SpringMVC可以直接处理实体类的属性值
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "testObjectProperties")
    public String testObjectProperties(Student student) {
        System.out.println(student.getId() + ","
                + student.getName() + ","
                + student.getAddress().getHomeAddress() + ","
                + student.getAddress().getSchoolAddress());
        return "home";
    }

    /**
     * 使用ModelAndView
     *
     * @return
     */
    @RequestMapping(value = "testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView("home");
        Student stu = new Student(1, "vanOwen");
        modelAndView.addObject("student", stu);//相当于request.setAttribute("student",stu)
        return modelAndView;
    }

    /**
     * 国际化操作
     *
     * @return
     */
    @RequestMapping(value = "testI18n")
    public String testI18n() {
        return "redirect:/view/home.jsp";//forward和redirect需要手动写上[相对路径]
    }


    /**
     * 前端输入和springmvc的类型转换
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "testConverter")
    public String testConverter(@RequestParam("studentInfo") Student student) {
        System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());
        return "home";
    }

    /**
     * 日期类型转换
     *
     * @param student
     * @param bindingResult
     * @param map           map集合的范围存在于request中
     * @return
     */
    @RequestMapping(value = "testDateTimeFormat")
    public String testDateTimeFormat(@Valid Student student, BindingResult bindingResult, Map<String, Object> map) {
        /*BindingResult校验必须在出错的类型参数后面*/
        /*如果要将控制台的错误消息 传到jsp中显示，则可以将 错误消息对象放入request域中，然后 在jsp中 从request中获取。*/
        System.out.println(student.getId() + "---->"
                + student.getName() + "---->"
                + student.getBirthday());
        if (bindingResult.getErrorCount() > 0) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getDefaultMessage());
                map.put("errors", bindingResult.getFieldErrors());
            }
        }
        return "home";
    }


    /**
     * 文件上传处理方法
     *
     * @return
     */
    @RequestMapping(value = "testUpload")
    public String testUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("信息:----->" + desc);
        InputStream inputStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        OutputStream outputStream = new FileOutputStream("E:\\" + filename);
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
        System.out.println("upload done.....");
        return "home";
    }
}