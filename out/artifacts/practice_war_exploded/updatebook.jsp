<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">
	
		function setBookType(t) {
			//补充js代码，完成select下拉框内容的显示
			
			
			
			
	
		};
</script>
</head>
<body onload="setBookType('${book.type}')">
<div class ="container">
	<div class ="row"  style="margin-top:40px">
		<div class = "col-md-8 offset-md-2">
		<form  action="UpdateBook" method="post">
            <div class="form-group">
                <label for="id">图书id</label>
                <input type="text" class="form-control" id="id" name="id" value="${book.id}">
            </div>
          <div class="form-group">
           <label for="name">图书名称</label>
           <input type="text" class="form-control" id="name" name="name" value="${book.name}">
          </div>
           <div class="form-group">
           <label for="price">图书价格</label>
           <input type="text" class="form-control" id="price" name="price" value="${book.price}" >
          </div>
           <div class="form-group">
           <label for="num">图书库存</label>
           <input type="text" class="form-control" id="num" name="num" placeholder="必须输入大于0的整数" value="${book.num}" >
          </div>
          <div class="form-group">
          <label for="type">图书类型</label>
          <select class="form-control" id="type" name="type"  >
              <option>请选择图书类型</option>
              <option value="小说 ">小说</option>
              <option value="计算机">计算机</option>
		      <option value="生活">生活</option>
		      <option value="社科">社科</option>
		      <option value="励志">励志</option>
		  </select>
 		 </div>
 		 <div  class="form-group">
 		 	 <button type="submit" class="btn btn-primary" >修改</button>
			 <button type="reset" class="btn btn-primary">重置</button>
 		 </div>
		</form>
		</div>
	
	</div>
</div>
</body>
</html>