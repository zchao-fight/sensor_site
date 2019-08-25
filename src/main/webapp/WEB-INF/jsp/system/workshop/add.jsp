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
            <div class="form-group">
                <label class="col-sm-3 control-label">编码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入编码" name="workshopNumber" id="workshopNumber">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">位置</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="location" id="location">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">定员</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="personnelQuota" id="personnelQuota">
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">ip</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="ip" id="ip">
                </div>
            </div>
        </div>
        <footer class="panel-footer text-right bg-light lter">
            <button type="button" class="btn btn-success btn-s-xs" onclick="addWorkshop()">提交</button>
        </footer>
    </section>
</form>
<script type="text/javascript">

    function addWorkshop() {

        sensor.post("${ctx}/workshop/addWorkshop.action", $("#form").serialize(), function () {
            setTimeout(function () {
                parent.window.location.reload();
            }, 2000);
            sensor.succMsg("添加成功");
        },function () {
            sensor.errorMsg("添加失败")
        });
    }


</script>

</body>
</html>