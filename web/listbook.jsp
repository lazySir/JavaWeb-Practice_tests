<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	
<title>Insert title here</title>
<script type="text/javascript">
	function addBook(){
		window.location.href="${pageContext.request.contextPath}/addbook.jsp"
	}

</script>
</head>
<body>
<div class = "container">
	<div class = "row"  style="margin-top:40px">
		<div class = "col-md-5 offset-md-3">
			<form  class="form-inline"  action="ListBookByName" method="post">
			 <div class="form-group ">
                <label for="name">书名&nbsp;&nbsp;&nbsp;</label>
                <input type="text" class="form-control" id="name" name="name" value="${name}">
              &nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">查询</button>
			 </div>
		   </form>
       </div>
       <button type="submit" class="btn btn-primary"  onclick="addBook()">增加</button>
	</div>


<div class = "row" style="margin-top:20px">
		<div class = "col-md-8 offset-md-2">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">书号</th>
			      <th scope="col">书名</th>
			      <th scope="col">价格</th>
			      <th scope="col">库存</th>
			      <th scope="col">类型</th>
			      <th scope="col">操作</th>
			    </tr>
			  </thead>
			  <tbody>
			      <!-- 此处补充代码，显示所有图书信息 -->
				  <c:forEach items="${books}" var="book">
					  <tr>
						  <td>${book.id}</td>
						  <td>${book.name}</td>
						  <td>${book.price}</td>
						  <td>${book.num}</td>
						  <td>${book.type}</td>
						  <td><a href="DeleteBookServlet?id=${book.id}" onclick="confirm('确认删除？')">删除</a></td>
						  <td><a href="FindBookById?id=${book.id}">修改</a></td>
					  </tr>
				  </c:forEach>
		      </tbody>
			</table>
		</div>
	</div>
</div>	

</body>
</html>