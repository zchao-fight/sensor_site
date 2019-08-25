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
            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">名称</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           placeholder="请输入名称" name="name" id="name">
                </div>
            </div>
            <div class="form-group" style="display: none;">
                <div class="col-sm-3">
                    <label class="control-label">名称</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${type}" name="type" id="type">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">编码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc" style="color: red;"
                           placeholder="请输入编码" name="sensorNumber" id="sensorNumber">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">序列号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入序列号" name="serialNumber" id="serialNumber">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">安装位置</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入安装位置" name="location" id="location">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">状态</label>
                <div class="col-sm-9">
                    <div class="btn-group m-r">
                        <select class="form-control" name="status">
                            <option value="1">好</option>
                            <option value="0">坏</option>
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
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                </div>
            </div>

        </div>
        <footer class="panel-footer text-right bg-light lter">
            <button type="button" class="btn btn-success btn-s-xs" onclick="addUser()">提交</button>
        </footer>
    </section>
</form>
<script type="text/javascript">

    window.onbeforeunload = function() {
        return "确认离开当前页面吗？未保存的数据将会丢失";
    };


    function addUser() {
            var formObject = {};
            var formArray =$("#form").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });

        sensor.ajax("${ctx}/sensor/addSensor.action", "post", formObject, function (data) {
            setTimeout(function(){
                window.onbeforeunload = null;
                window.parent.location.reload();
            },2000);
            sensor.succMsg('保存成功!')
        });
    }


</script>

</body>
</html>