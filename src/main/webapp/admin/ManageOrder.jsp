<%@ page import="bean.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.UserSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    UserSession u = UserSession.getUS(session);
    Collection<User> user = u.getUser();
    String username = u.getUserName();
    if (username.equalsIgnoreCase("") || !user.iterator().next().accept("admin.index"))
        response.sendRedirect("http://localhost:8080/GachMen_Store_war/Home");
%>
<!DOCTYPE html>
<html>

<head>
    <title>Quản lý đơn hàng</title>
    <!-- Bootstrap -->
    <meta charset="utf-8">
    <link href="admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="admin/assets/styles.css" rel="stylesheet" media="screen">
    <link href="admin/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
    <!--[if lte IE 8]>
    <script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="admin/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>

</head>

<body>
<jsp:include page="headerAd.jsp"/>
<div class="container-fluid">
    <div class="row-fluid">
        <jsp:include page="menu.jsp"/>
        <!--/span-->
        <div class="span9" id="content">
            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">Quản lý đơn hàng</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <div class="table-toolbar">
                                <div class="btn-group" style="visibility: hidden">
                                    <a href="#">
                                        <button class="btn btn-success"><i class="icon-plus icon-white"></i></button>
                                    </a>
                                </div>
                                <div class="btn-group pull-right">
                                    <button data-toggle="dropdown" class="btn dropdown-toggle">Công cụ <span
                                            class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">In</a></li>
                                        <li><a id="exportPDF">Lưu file PDF</a></li>
                                        <li><a onclick="exportTableToExcel('example2','orders')">Xuất ra Excel</a></li>
                                    </ul>
                                </div>
                            </div>
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-bordered"
                                   id="example2">
                                <thead>
                                <tr>
                                    <th>Mã đơn hàng</th>
                                    <th>Tên khách hàng</th>
                                    <th>Tổng đơn hàng</th>
                                    <th>Ngày đặt</th>
                                    <th>Trạng thái</th>
                                    <th>Xác minh</th>
                                    <th colspan="3"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--@elvariable id="listO" type="java.util.List"--%>
                                <c:forEach items="${listO}" var="o">
                                    <tr id="${o.orderID}">
                                        <td>${o.orderID}</td>
                                        <td>${o.fullName}</td>
                                        <td><fmt:formatNumber type="currency" currencySymbol="" minFractionDigits="0"
                                                              value="${o.totalPrice}"/> VNĐ
                                        </td>
                                        <td>${o.createDate}</td>
                                        <td id="orderstatus"><c:if test="${o.status ==1}">Đã xử lý</c:if>
                                            <c:if test="${o.status ==0}">Chưa xử lý</c:if></td>
                                        <td style="text-align: center;">
                                            <c:choose>
                                                <c:when test="${not empty requestScope[o.orderID] and requestScope[o.orderID] eq 'true'}">
                                                    <span class="fa fa-check" style="font-size: 40px;color: green"></span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="fa fa-close"  style="font-size: 40px;color: red"></span>

                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td style="text-align: center"  id="rowupdate"><c:if test="${o.status ==1}"></c:if>
                                            <c:if test="${o.status ==0}"><a type="button" class="btn btn-primary"
                                                                            id="linkupdate"
                                                                            href="UpdateOrder?action=update&id=${o.orderID}">
                                                 Xử lý</a></c:if></td>
                                        <td style="text-align: center"><a type="button" class="btn btn-success"
                                               href="ListOrderDetailAd?id=${o.orderID}&fullName=${o.fullName}&address=${o.address}&phone=${o.phone}&createDate=${o.createDate}&total=${o.totalPrice}">
                                             Xem chi tiết</a></td>


                                        <td style="text-align: center"><a type="button" id="btn-delete" href="UpdateOrder?action=delete&id=${o.orderID}" class="btn btn-danger"> Xóa</a></td>

                                    </tr>
                                    <%--                                    href="UpdateOrder?action=delete&id=${o.orderID}"--%>
                                </c:forEach>
                                </tbody>
                            </table>
                          </div>
                    </div>
                </div>
                <!-- /block -->
            </div>
        </div>
    </div>
    <hr>
    <jsp:include page="footerAd.jsp"/>
</div>
<!--/.fluid-container-->

<script src="admin/vendors/jquery-1.9.1.js"></script>
<script src="admin/bootstrap/js/bootstrap.min.js"></script>
<script src="admin/vendors/datatables/js/jquery.dataTables.min.js"></script>


<script src="admin/assets/scripts.js"></script>
<script src="admin/assets/DT_bootstrap.js"></script>


</body>

</html>
