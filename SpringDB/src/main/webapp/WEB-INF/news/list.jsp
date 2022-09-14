<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List newsList = (List)request.getAttribute("newsList");
	out.print(newsList.size());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.page-style{
	font-size:20px;
	font-weight:bold;
	color:red;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th width="5%">No</th>
			<th width="75%">제목</th>
			<th width="5%">작성자</th>
			<th width="10%">작성일</th>
			<th width="5%">조회수</th>
		</tr>
		<tr>
			<td><%//= %></td>
			<td><a href="/board/content?notice_id=<%//=board.getNotice_id()%>"><%//=board.getTitle() %></a></td>
			<td><%//=board.getWriter() %></td>
			<td><%//=board.getRegdate() %></td>
			<td><%//=board.getHit() %></td>
		</tr>

		<tr>
			<td colspan="5" style="text-align:center">

			</td>
		</tr>
		<tr>
			<td colspan="5"><button onClick="location.href='/board/regist.jsp';">글작성</button></td>
		</tr>
	</table>

</body>
</html>