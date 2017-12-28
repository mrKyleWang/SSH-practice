<%--
  User: Kyle.Wang
  Date: 2017/12/27 0027 10:35
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>CustomerList</title>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        var pageSize = 10;
        var currentPage = 1;
        $(function () {
            $("#addButton").click(function () {
                location.href = "${pageContext.request.contextPath}/addCustomer.jsp";
            });
        });

        function delCustomer(id, name) {
            if (confirm("确定删除客户:" + name + "?")) {
                location.href = "${pageContext.request.contextPath}/customer/delCustomer?id=" + id;
            }
        };
        function delOrder(orderNum) {
            if (confirm("确定删除订单:" + orderNum + "?")) {
                alert(orderNum);
                <%--location.href = "${pageContext.request.contextPath}/order/delOrder?id=" + id;--%>
            }
        };

        function showOrders(id) {
            currentPage = 1;
            findOrders(id);
        };

        function findOrders(id) {
            $.getJSON("${pageContext.request.contextPath}/order/findOrderByCustomer", {
                "customerId": id,
                "currentPage": currentPage,
                "pageSize": pageSize
            }, function (data) {
                var jsonData = eval(data);
                var list = jsonData.list;
                var orderContent = "";
                for (var i = 0; i < list.length; i++) {
                    orderContent += "<tr><td>" + list[i].orderNum + "</td><td>" + list[i].receiverInfo + "</td><td>" + list[i].price + "</td><td>" + list[i].customer.cusName + "</td><td><a href=\"javascript:void(0)\" onclick=\"delOrder("+list[i].orderNum+")\">删除订单</a></td></tr>";

                }
                $("#orderBody").html(orderContent);

                var totalPage = parseInt(jsonData.totalPage);
                $("#pagination").html("<li id=\"previous\"><a href=\"#\" aria-label=\"Previous\"><spanaria-hidden=\"true\">&laquo;</span></a></li><li id=\"next\"><a href=\"#\" aria-label=\"Next\"><spanaria-hidden=\"true\">&raquo;</span></a></li>");
                for (var i = 0; i < totalPage; i++) {
                    var li = $("<li><a id=\"" + (i + 1) + "\" class=\"select\" href=\"javascript:void(0)\">" + (i + 1) + "</a></li>");
                    $("#next").before(li);
                }

                $(".active").attr("class", "");
                $("#" + currentPage + "").parent().attr("class", "active");

                $(".select").each(function () {
                    $(this).click(function () {
                        currentPage = parseInt($(this).attr("id"));
                        findOrders(id)
                    });
                });

                $("#previous").unbind();
                $("#next").unbind();

                if (currentPage == 1) {
                    $("#previous").attr("class", "disabled");
                } else {
                    $("#previous").attr("class", "");
                    $("#previous").bind("click", function () {
                        currentPage = currentPage - 1;
                        findOrders(id)
                    });
                }
                ;
                if (currentPage == totalPage) {
                    $("#next").attr("class", "disabled");
                } else {
                    $("#next").attr("class", "");
                    $("#next").bind("click", function () {
                        currentPage = currentPage + 1;
                        findOrders(id)
                    });
                }
            });
        }
    </script>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div class="panel panel-primary">
        <div class="panel-heading" style="font-size: 18px;font-weight: bold;text-align: center">客户列表
            <button type="button" id="addButton" class="btn btn-default" style="float: right">新增客户</button>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>序号</th>
                <th>客户名称</th>
                <th>联系电话</th>
                <th>图片</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="customerList" var="customer" status="status">
                <tr>
                    <td><s:property value="#status.index+1"/></td>
                    <td><s:property value="#customer.cusName"/></td>
                    <td><s:property value="#customer.cusPhone"/></td>
                    <td><img src="<s:property value="#customer.cusImgSrc"/>" class="img-rounded" style="height: 50px"/>
                    </td>
                    <td>
                        <input class="btn btn-default" type="button" value="删除客户"
                               onclick="delCustomer(<s:property value="#customer.id"/>,<s:property
                                       value="#customer.cusName"/>)"/>
                        <input type="button" class="btn btn-default" data-toggle="modal"
                               data-target="#myModal" value="订单详情"
                               onclick="showOrders(<s:property value="#customer.id"/>)"/>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">订单详情</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>收货地址</th>
                            <th>订单价格</th>
                            <th>客户名称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="orderBody">

                        </tbody>
                    </table>
                    <div class="center-block" style="width:200px">
                        <nav aria-label="Page navigation">
                            <ul id="pagination" class="pagination">
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
