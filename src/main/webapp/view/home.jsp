<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
${requestScope.studentInfo[0]}---->${requestScope.studentInfo[1]}---->${requestScope.studentInfo[3]}
<br/>
<br/>
<c:forEach items="${errors}" var="error">
    ${error.getDefaultMessage()}<br/>
</c:forEach>


</body>
</html>
