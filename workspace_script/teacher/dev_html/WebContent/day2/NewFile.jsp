<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.Map"%>
<%@ page import= "com.google.gson.Gson"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	
	<% 
	json.ui.JsonDeptList jdl=new json.ui.JsonDeptList();
	java.util.Lsit<Map<String,Object>> deptList= jdl.getDeptList();
	Gson g= 
	%>