<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>HOMEPAGE</title>
    <script src="js/jquery-1.8.3.js"/>
    <script>
        $(document).ready(function () {
            $("#testJson").click(function () {
                //通过ajax请求springmvc
                $.post(
                    "handler/testJson",//服务器地址
                    //{"name":"zs","age":23}
                    function (result) {//服务端处理完毕后的回调函数 List<Student> students，
                        // 加上@ResponseBody后， students实质是一个json数组的格式
                        for (var i = 0; i < result.length; i++) {
                            alert(result[i].id + "-" + result[i].name + "-" + result[i].age);
                        }
                    }
                );
            });
        });
    </script>

</head>
<body>
<h2>SpringMVC project</h2>
<hr/>

<input type="button" value="testJson" id="testJson">
<br/>

<a href="Controller/welcome">welcome..</a>
<br/>
<br/>
<br/>
<form action="Controller/welcome001/1234" method="post">
    <input type="submit" value="增"/>
</form>
<form action="Controller/welcome001/1234" method="post">
    <input type="hidden" value="DELETE" name="_method"/>
    <input type="submit" value="删"/>
</form>
<form action="Controller/welcome001/1234" method="post">
    <input type="hidden" value="PUT" name="_method"/>
    <input type="submit" value="改"/>
</form>
<form action="Controller/welcome001/1234" method="get">
    <input type="submit" value="查"/>
</form>
<form action="Controller/testParam" method="get">
    name:<input type="text" name="uname"><br/>
    age:<input type="text" name="uage">
    <input type="submit" value="换个方式查询">
</form>

<a href="Controller/testRequestHeader">请求头信息....</a>
<br/>
<a href="Controller/testCookieValue">JESESSIONID....</a>
<br/>

<form action="Controller/testObjectProperties" method="post">
    id:<input type="text" name="id"><br/>
    name:<input type="text" name="name"><br/>
    age:<input type="text" name="age"><br/>
    homeAdd:<input type="text" name="address.homeAddress"><br/>
    schoolAdd:<input type="text" name="address.schoolAddress">
    <input type="submit" value="提交">
</form>

<br/>
<a href="Controller/testModelAndView">modelAndView.....</a>

<br/>
<a href="Controller/testI18n">testI18n</a>
<br/>

<br/>
<a href="Controller/project">index.jsp------>home.jsp</a>
<br/>
<br/>

<%--要么input中的name和控制器里面的参数一样;要么就要在控制器方法参数中添加@RequestParam()--%>
<form action="Controller/testConverter" method="post">
    学生信息:<input name="studentInfo" type="text"/><!-- 2-zs-23  -->
    <input type="submit" value="提交转换">
</form>
<br/>
<br/>

<form action="Controller/testDateTimeFormat" method="post">
    IdNumber:<input name="id" type="text" value="31"/><br/>
    UserName:<input name="name" type="text"/><br/>
    Birthday:<input name="birthday" type="text"/><br/>
    <input type="submit" value="提交修改">
</form>
<br/>
<br/>
<br/>
<br/>

<form action="Controller/testUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br/>
    Description:<input name="desc" type="text"/><br/>

    <input type="submit" value="提交修改">
</form>

</body>
</html>
