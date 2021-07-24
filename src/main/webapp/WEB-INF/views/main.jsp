<%--
  Created by IntelliJ IDEA.
  User: Mattias Chang
  Date: 7/24/2021
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>明日科技</title>

    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/layout.css" type="text/css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt LE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>

<div style="height: 100px; background-color: #4d5e70; width: 100%; line-height: 165px;">
    <p style="font-size: 30px; color: #fff; padding-left: 60px;">Office automation for MR Co. Ltd.</p>
</div>
<div class="container-fluid">
    <div id="warp">
        <div class="leftMeun" id="leftMenu">
            <div id="personInfo">
                <p id="username">${loginEntity.wxname}</p>
                <p>${loginEntity.email}</p>
                <p><a href="${pageContext.request.contextPath}/login/logout">退出登录</a></p>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        let bodyHeight = window.screen.height - 180;
        let bodyWidth = window.screen.width - 220;
        const iframeHtml = "<iframe id='content' name='content' width='" + bodyWidth + "' height='" + bodyHeight
            + "' style='border: 0;' src='${pageContext.request.contextPath}/mainContent'></iframe>";
        $('#rightContent').html(iframeHtml);
    });
</script>

</body>
</html>
