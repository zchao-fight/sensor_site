<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${ctx}/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.1.12.4.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/jquery.ztree.all.min.js"></script>
    <script src="${ctx}/js/layer/layer.js"></script>
    <!--[if lt IE 9]>
    <script src="${ctx}/js/jquery/ie/html5shiv.js"></script>
    <script src="${ctx}/js/jquery/ie/respond.min.js"></script>
    <![endif]-->
    <style>
        table {
            font-size: 12px !important;
        }

        table tr td {
            text-align: center;
            vertical-align: middle;
        }

        table tr th {
            text-align: center;
            vertical-align: middle;
        }

        input[type=checkbox] {
            margin-left: 10px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <span>
                       传感器列表
                   </span>
                    <c:if test="${sessionScope.userInfo.role == 1}">
                    <div class="btn-group pull-right" style="margin-top: -5px;">
                        <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-sign-in"></i> 导入
                        </button>
                        <button type="button" data-toggle="modal" data-target="#zqdlModal"
                                class="btn btn-primary btn-sm"><i class="fa fa-sign-out"></i> 导出
                        </button>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="addSensor('${type}')"><i class="fa fa-plus"></i> 添加
                        </button>
                    </div>
                    </c:if>
                </div>

                <table class="table table-bordered table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>编号</th>
                        <th>序列号</th>
                        <th>安装位置</th>
                        <th>状态</th>
                        <th>是否上传</th>
                        <c:if test="${sessionScope.userInfo.role == 1}">
                        <th>操作</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sensors}" var="item">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.sensorNumber}</td>
                            <td>${item.serialNumber}</td>
                            <td>${item.location}</td>
                            <td><c:if test="${item.status eq 0}"> 正常</c:if><c:if test="${item.status eq 1}"> 损坏</c:if></td>
                            <td><c:if test="${item.isUpload eq 0}"> 否</c:if><c:if test="${item.isUpload eq 1}"> 是</c:if></td>
                            <c:if test="${sessionScope.userInfo.role == 1}">
                            <td>
                                <button class="btn btn-primary btn-xs" onclick="editSensor('${item.id}')">修改</button>
                                <button class="btn btn-danger btn-xs" onclick="deleteSensor('${item.id}')">删除</button>
                            </td>
                            </c:if>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteSensor(id) {
        $.ajax({
            type : "post",
            url : "${ctx}/sensor/deleteSensor.action",
            dataType : "json",
            data : {
                id : id
            },
            statusCode : {
                200 : function () {
                    layer.msg("删除成功", {icon : 6}, function () {
                        location.reload();
                    })
                },
                500 : function () {
                    layer.msg("删除成功", {icon : 5});
                }
            }
        });
    }

    function editSensor(id) {
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '查看传感器',
            area: ['500px', '520px'],
            skin: 'layui-layer-rim', //加上边框
            content: '${ctx}/sensor/editSensorUI.action?id='+id
        });
    }
    function addSensor(type) {
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '添加传感器',
            area: ['500px', '520px'],
            skin: 'layui-layer-rim', //加上边框
            content: '${ctx}/sensor/addSensorUI.action?type=' + type
        });
    }
</script>

</body>
</html>