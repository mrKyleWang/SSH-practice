<%--
  User: Kyle.Wang
  Date: 2017/12/27 0027 10:35
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>AddCustomer</title>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container " style="margin-top: 20px">
    <div class="panel panel-primary col-md-6 col-md-offset-3" style="padding: 0">
        <div class="panel-heading" style="font-size: 18px;font-weight: bold;text-align: center">新增客户</div>
        <div class="panel-body" style="margin: 10px">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/customer/addCustomer" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">客户姓名</label>
                    <div class="col-sm-10">
                        <input type="text" name="cusName" class="form-control" id="inputName" placeholder="Name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPhone" class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-10">
                        <input type="text" name="cusPhone" class="form-control" id="inputPhone" placeholder="Phone">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFile" class="col-sm-2 control-label">图片上传</label>
                    <input type="file" id="inputFile" name="cusImg">
                </div>
                <button type="submit" class="btn btn-default col-sm-2 col-sm-offset-5">提交</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
