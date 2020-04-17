<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//화면이 없어도 단위테스트가 가능해야 한다.
//디자이너가 내 페이지를 아직 못 만들었어도 나는 코딩할 수 있어야 한다.
//개발할 때 중요하기 때문에 클래스 쪼개기를 했었다.

	//아이디를 비교해서 이미지 이름정보를 비교한다.
	String img = request.getParameter("id");
	//out.print("img:"+img);//picture2.jpg
	String imgs[] = {"picture1.jpg","picture2.jpg","picture3.jpg","picture4.jpg"};
	
	String cimg = null;
	for(int i=0;i<imgs.length;i++){
		//equals를 알아야 한다.
		if(img.equals(imgs[i])){
			cimg = imgs[i];
		}
	}
%>
<img src="./<% out.print(cimg); %>" width='400px' height='270px'>