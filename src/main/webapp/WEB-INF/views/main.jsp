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
            <div style="height: 1px; background-color: #fff;"></div>
            <ul class="nav nav-pills nav-stacked">
                <li role="role1">
                    <a href="${pageContext.request.contextPath}/mainContent" target="content">首页</a>
                </li>
                <li role="role1">
                    <a role="button" data-toggle="collapse" href="#collapse_rcrw" aria-expanded="false"
                       aria-controls="collapse_rcrw">任务核查</a>
                </li>
                <li>
                    <div class="collapse" id="collapse_rcrw">
                        <ul style="font-size: 12px; padding-left: 15px;" class="nav nav-pills nav-stacked bg-info">
                            <li>
                                <a href="${pageContext.request.contextPath}/planGoToday">今日任务核查</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li role="role2">
                    <a role="button" data-toggle="collapse" href="#collapse_sqsp" aria-expanded="false"
                       aria-controls="collapse_sqsp">申请审批</a>
                </li>
                <li>
                    <div class="collapse" id="collapse_sqsp">
                        <ul style="font-size: 12px; padding-left: 15px;" class="nav nav-pills nav-stacked bg-info">
                            <li>
                                <a href="javascript:alert('待完善');">病/事假申请</a>
                            </li>
                            <li>
                                <a href="javascript:alert('待完善');">外出申请</a>
                            </li>
                            <li>
                                <a href="javascript:alert('待完善');">采购申请</a>
                            </li>
                            <li>
                                <a href="javascript:alert('待完善');">加班申请</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li role="role1">
                    <a role="button" data-toggle="collapse" href="#collapse_zh"
                       aria-expanded="false" aria-controls="collapse_zh">
                        综合
                    </a>
                </li>
                <li>
                    <div class="collapse" id="collapse_zh">
                        <ul style="font-size: 12px; padding-left: 15px;" class="nav nav-pills nav-stacked bg-info">
                            <li><a href="${pageContext.request.contextPath}/goCkin" target="content">考勤记录</a></li>

                            <li><a href="javascript:alert('待完善')">公司通讯录</a></li>

                            <li><a href="javascript:alert('待完善')">公司计划</a></li>

                            <li><a href="javascript:alert('待完善')">公司近况概要</a></li>
                        </ul>
                    </div>
                </li>
                <li role="role1">
                    <a href="${pageContext.request.contextPath}/login/logout">退出登录</a>
                </li>
            </ul>
            <div style="height: 1px; background-color: #fff;"></div>
        </div>
        <div class="rightContent">
            <!-- INSERT CONTENT HERE -->
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
