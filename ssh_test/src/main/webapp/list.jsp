<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>列表页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {

            $.post("${pageContext.request.contextPath}/book/findAll",function(data){
                var jsonData = eval(data);
                var content="";
                for(var i=0;i<data.length;i++){
                content += "<tr><td>"+jsonData[i].id+"</td><td>"+jsonData[i].bookname+"</td><td>"+jsonData[i].num+"</td><td>"+jsonData[i].prices+"</td><td>"+jsonData[i].vender+"</td></tr>";
                }
                $("#content").html(content);
            },"json");
        });
    </script>
</head>
<body>
商品列表<br/>


<table border="1px" id="tab">
    <thead>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>数量</th>
        <th>价格</th>
        <th>作者</th>
    </tr>
    </thead>
    <tbody id="content">
    </tbody>

</table>
</body>
</html>