<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	html,body {
	text-align: center;
	}
	table,td {
	border: 1px solid black;
	border-collapse:collapse;
	}
	#table_top {
	background-color: pink;
	}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	MemberDAO mdao = MemberDAO.getInstance();
	ArrayList<MemDTO> mdto = mdao.getAll();
	int size = mdto.size();
	/* id, passwd, name, birth, phone, cdate, udate */
/* 	for(int i =0; i<mdto.size(); i++) {
		out.println(mdto.get(i).getId() +" | "+ mdto.get(i).getPasswd() +" | "+  mdto.get(i).getName()
				+" | "+ mdto.get(i).getBirth()+" | "+ mdto.get(i).getPhone() +" | "+ mdto.get(i).getCdate()
				+" | "+ mdto.get(i).getUdate());
	} */
%>
	<table >
		<tr id = "table_top">
			<td></td>
			<td>ID</td>
			<td>PASSWD</td>
			<td>NAME</td>
			<td>BIRTH</td>
			<td>PHONE</td>
			<td>CDATE</td>
			<td>UDATE</td>
		</tr>
		<%
		for(int i =0; i<size; i++) {
		%>
		<tr>
			<td><%=i+1 %></td>
			<td>
				<%=mdto.get(i).getId() %>
			</td>
			<td>
				<%=mdto.get(i).getPasswd() %>
			</td>
			<td>
				<%=mdto.get(i).getName() %>
			</td>
			<td>
				<%=mdto.get(i).getBirth() %>
			</td>
			<td>
				<%=mdto.get(i).getPhone() %>
			</td>
			<td>
				<%=mdto.get(i).getCdate() %>
			</td>
			<td>
				<%=mdto.get(i).getUdate() %>
			</td>
		</tr>
			<%
		}
			%>
	</table>
	<br>
</body>
</html>