<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome ${param.name}
	<%
		/*
		String name=request.getParameter("name");
		out.println("Welcome " + name);
		*/
	%>
	<br>
	<a href="DisplayEmpDetails">Show all employee details</a>
	<br>
	<c:if test="${not empty requestScope.err}">
		<c:out value="${requestScope.err}"></c:out>
	</c:if>
	<br>
	<a href="Login.jsp"><button type="button">Logout</button></a>
	<!-- 
	<div id="map" style="width:100%;height:400px;"></div>
	<script>
	function myMap() {
  	var mapCanvas = document.getElementById("map");
  	var mapOptions = {
    center: new google.maps.LatLng(51.5, -0.2), zoom: 10
  	};
 	 var map = new google.maps.Map(mapCanvas, mapOptions);
	}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script> -->
	
</body>
</html>
