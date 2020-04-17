<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
주석 다는 방법 주의***

application/json => mime type

***mime type
mime type에 따라서 html로 판독이 되거나 워드프로세서로 인지하거나 엑셀 파일로 인지한다.
mime type에는 두 가지가 있다. 
	- main type
		text,image,video,,,
		
	- sub type
		json,css,js,png,jpeg,,,,
		
--%>


<%-- 리스트의 맵의 형태로 가기 위해 임포트 --%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>

<%--
	//이름: mem_name
	//주소: mem_addr
	//전화번호: mem_tel
--%>

<%
	List<Map<String, Object>> mList = new ArrayList<Map<String,Object>>();	
	Map<String, Object> rMap =  new HashMap<String, Object>();
	
	rMap.put("mem_name", "김유신");
	rMap.put("mem_addr", "서울시 강남구");
	rMap.put("mem_tel", "02-111-1111");
	mList.add(rMap);
	
	rMap =  new HashMap<String, Object>();
	rMap.put("mem_name", "강감찬");
	rMap.put("mem_addr", "서울시 관악구");
	rMap.put("mem_tel", "02-222-2222");
	mList.add(rMap);
	
	rMap =  new HashMap<String, Object>();
	rMap.put("mem_name", "김소월");
	rMap.put("mem_addr", "서울시 구로구");
	rMap.put("mem_tel", "02-333-3333");
	mList.add(rMap);
	
	Gson g = new Gson();
	String result = g.toJson(mList);
	out.print(result);

%>