<%--
  Created by IntelliJ IDEA.
  User: Mattias Chang
  Date: 7/31/2021
  Time: 11:32 PM
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

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/calendar/js/simplecalendar.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jedate/jedate.js"></script>

    <script type="text/javascript">
        let count = ${count};
        let countOver = ${countOver};
        let row = ${row};
        let lastPage = ${lastPage};
        let lastPageOver =${lastPageOver};
        let basePath = ${pageContext.request.contextPath};
    </script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plan.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/createJedate.js"></script>
</head>
<body style="background-color: #f1f1f1">

<div style="border: 1px solid #000; height: 300px; width: 100%; float: left; min-width: 750px;">
    <h4 class="text-center">待核查内容</h4>
    <table class="table table-bordered" style="min-width: 750px;">
        <tr>
            <th>
                <a href="javascript:void(0);" onclick="goPageHC('prev');">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                第<span id="currentPage">1</span>页
                <a href="javascript:void(0);" onclick="goPageHC('next');">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </th>
            <th>申报日期</th>
            <th>核查日期</th>
            <th>申报人</th>
            <th class="text-right">

            </th>
        </tr>
        <tbody id="contentBody">
        <c:choose>
            <c:when test="${not empty top7}">
                <c:forEach items="${top7}" var="item" varStatus="vs">
                    <tr>
                        <td>
                            ${item.planTitle}
                        </td>
                        <td>
                            ${item.planCreatetime}
                        </td>
                        <c:if test="${item.planFlag eq 1}">
                            <td>
                                待核查
                            </td>
                        </c:if>
                        <c:if test="${item.planFlag eq 2}">
                            <td>
                                ${item.planUpdatetime}
                            </td>
                        </c:if>
                        <td>
                            ${item.planCreator}
                        </td>
                        <td class="text-center">
                            <a href="javascript:void(0);" onclick="showHC('${item.planId}')">
                                <span class="glyphicon glyphicon-th"></span>
                            </a>
                            <textarea style="display: none;" rows="" cols="" id="${item.planId}">
                                ${item.planContent}
                            </textarea>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
        </tbody>
    </table>
</div>

<div class="modal fade" data-backdrop="false" id="rwDialog" style="z-index: 0;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span style="font-size: 12px;"><strong>工作计划申报</strong></span>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/updatePlanWork" method="post" id="updatePlanWork">
                    <input type="hidden" name="plan_id" id="plan_id"/>
                    <div class="form-group">
                        <label>计划优先级</label>
                        <div>
                            <a href="javascript:void(0);"><span id="starPriority1" class="glyphicon glyphicon-star"></span></a>
                            <a href="javascript:void(0);"><span id="starPriority2" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starPriority3" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starPriority4" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starPriority5" class="glyphicon glyphicon-star-empty"></span></a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>计划复杂度</label>
                        <div>
                            <a href="javascript:void(0);"><span id="starComplexity1" class="glyphicon glyphicon-star"></span></a>
                            <a href="javascript:void(0);"><span id="starComplexity2" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starComplexity3" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starComplexity4" class="glyphicon glyphicon-star-empty"></span></a>
                            <a href="javascript:void(0);"><span id="starComplexity5" class="glyphicon glyphicon-star-empty"></span></a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <label>预估工期</label>
                            <input type="text" name="plan_start" id="plan_start" style="width: 160px;" readonly="readonly"/>
                            <span>至</span>
                            <input type="text" name="plan_end" id="plan_end" style="width: 160px;" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="plan_title">标题</label>
                        <input type="text" class="form-control" placeholder="最多输入80个字符" id="plan_title" name="plan_title" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label for="plan_content">内容</label>
                        <textarea rows="3" class="form-control" name="plan_content" id="plan_content"></textarea>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" value="2" name="plan_flag" checked="checked"/>
                            同意
                        </label>
                        <label>
                            <input type="radio" value="3" name="plan_flag"/>
                            不同意
                        </label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
                <button class="btn btn-primary" onclick="formSubmit('#updatePlanWork')">确定</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" data-backdrop="false" id="msgDialog" style="z-index: 0;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span style="font-size: 12px;"><strong>详细信息</strong></span>
            </div>
            <div class="modal-body">
                <div id="msgContent">

                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
