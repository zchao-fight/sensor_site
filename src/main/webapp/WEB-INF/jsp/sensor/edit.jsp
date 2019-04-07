<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="${ctx}/js/jquery.1.12.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/sensor.js"></script>
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <style type="text/css">
        .col-sm-3 {
            width: 15%;
            float: left;
            text-align: right;
        }

        .col-sm-9 {
            width: 85%;
            float: left;
            text-align: left;
        }

        label[class^="btn btn-default"] {
            margin-top: -4px;
        }
    </style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form id="form" name="form" class="form-horizontal">
    <section class="panel panel-default">
        <div class="panel panel-body">
            <div class="form-group" style="display: none">
                <div class="col-sm-3">
                    <label class="control-label">id</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control" value="${sensor.id}"
                           name="id">
                </div>
            </div>

            <div class="form-group" style="display: none">
                <div class="col-sm-3">
                    <label class="control-label">originSensorNumber</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control" value="${sensor.sensorNumber}"
                           name="originSensorNumber">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">名称</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control" value="${sensor.name}"
                           placeholder="请输入名称" name="name" id="name">
                </div>
            </div>
            <div class="form-group" style="display: none;">
                <div class="col-sm-3">
                    <label class="control-label">类型</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${sensor.type}" name="type" id="type">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">编码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc" style="color: red;"
                           placeholder="请输入编码" value="${sensor.sensorNumber}" name="sensorNumber" id="sensorNumber">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">序列号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入序列号" value="${sensor.serialNumber}" name="serialNumber" id="serialNumber">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">安装位置</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc" value="${sensor.location}"
                           placeholder="请输入安装位置" name="location" id="location">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">状态</label>
                <div class="col-sm-9">
                    <div class="btn-group m-r">
                        <select class="form-control" name="status">
                            <option value="0"  <c:if test="${sensor.status == 0}"> selected </c:if>>坏</option>
                            <option value="1" <c:if test="${sensor.status == 1}"> selected </c:if>>好</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">负责人</label>
                </div>
                <div class="col-sm-9">
                    <div class="btn-group m-r">
                        <select class="form-control" name="isUpload">
                            <option value="1" <c:if test="${sensor.isUpload == 1}"> selected </c:if>>是</option>
                            <option value="0" <c:if test="${sensor.isUpload == 0}"> selected </c:if>>否</option>
                        </select>
                    </div>
                </div>
            </div>

        </div>
        <footer class="panel-footer text-right bg-light lter">
            <button type="button" class="btn btn-success btn-s-xs" onclick="editSensor()">提交</button>
        </footer>
    </section>
</form>
<script type="text/javascript">

    function editSensor() {
        sensor.ajax('${ctx}/sensor/editSensor.action', 'post', $("#form").serializeJson(), function (data) {
            setTimeout(function () {
                window.parent.location.reload();
            }, 2000);
            sensor.succMsg("更新成功");
        });
    }


</script>

</body>
</html>