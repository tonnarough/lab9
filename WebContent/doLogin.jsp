<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="ad" uri="http://bsu.rfe.java.teacher.tag/ad"%>

<fmt:requestEncoding value="UTF-8" />
<ad:login login="${param.login}" password="${param.password}" />
<c:choose>
	<c:when test="${sessionScope.errorMessage==null}">
		<c:redirect url="/cabinet.jsp" />
	</c:when>
	<c:otherwise>
		<c:redirect url="/" />
	</c:otherwise>
</c:choose>