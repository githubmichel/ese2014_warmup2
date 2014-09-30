<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<h1>User Information</h1>
<c:if test="${page_error == null }">
<div>
	User ID:
	<c:out value="${user.id}"/>
</div>
<div>
	First Name:
	<c:out value="${user.firstName}"/>
</div>
<div>
	Last Name:
	<c:out value="${user.lastName}"/>
</div>
<div>
	Email:
	<c:out value="${user.email}"/>
</div>
<div>
	Team:
	<c:out value="${user.team.teamName}"/>
</div>
</c:if>
<c:if test="${page_error != null }">
        <div>
            <h4>Error!</h4>
                ${page_error}
        </div>
</c:if>



<c:import url="template/footer.jsp" />
