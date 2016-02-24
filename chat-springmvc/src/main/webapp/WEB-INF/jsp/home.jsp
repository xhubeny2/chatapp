<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<title>Chat window</title>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <h1>Chat window</h1>
    
    <form action="${pageContext.request.contextPath}/chat/create" method="post">  
        Name: <input type="text" name="name"><br>  
        Text: <input type="text" name="message" size="70"><br>  
        <input type="submit" value="Send">  
    </form>  
</jsp:attribute>
</my:pagetemplate>