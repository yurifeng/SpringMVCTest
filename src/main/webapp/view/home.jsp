<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>SpringMVC Framework</title>
</head>
<body>

<fmt:message key="resource.welcome"></fmt:message>
<br/>
<p>org.springframework.web.servlet.DispatcherServlet</p>
<p>org.springframework.web.servlet.view.InternalResourceViewResolver</p>
<p>org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping</p>
<p>ControllerClassNameHandlerMapping</p>
<p>SimpleUrlHandlerMapping</p>
<hr/>
<%--el表达式处理--%>
${requestScope.student.id}---->${requestScope.student.name}
</body>
</html>
