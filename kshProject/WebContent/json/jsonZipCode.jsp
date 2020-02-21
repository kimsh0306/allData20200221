<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.google.gson.Gson, java.util.Vector" %>
<%@ page import = "method.zipcode.ZipCodeSearchApp,com.vo.ZipCodeVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//스크립툴릿 안에 자바코드를 쓸 수 있다.
	ZipCodeSearchApp zcApp = new ZipCodeSearchApp();
	Vector<ZipCodeVO> v = zcApp.refreshData(null, "가산동");
	
	Gson g = new Gson();
	String temp = g.toJson(v);
	out.println(temp);
%>
</body>
</html>