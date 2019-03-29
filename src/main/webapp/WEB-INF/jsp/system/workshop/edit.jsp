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

            <div class="form-group" style="display: none;">
                <div class="col-sm-3">
                    <label class="control-label">id</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${workshop.id}" name="id">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">名称</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                          value="${workshop.name}" name="name" id="name" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">编码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           value="${workshop.workshopNumber}" name="workshopNumber" id="workshopNumber">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">位置</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${workshop.location}"  name="location" id="location">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">定员</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${workshop.personnelQuota}" name="personnelQuota" id="personnelQuota">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">ip</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${workshop.ip}" name="ip" id="ip">
                </div>
            </div>

            <footer class="panel-footer text-right bg-light lter">
                <button type="submit" class="btn btn-success btn-s-xs" onclick="editWorkshop()">提交</button>
            </footer>
        </div>
    </section>
</form>

<script>
    function editWorkshop() {

        $.ajax({
            type: "post",
            url: "${ctx}/workshop/editWorkshop.action",
            data: $("#form").serialize(),
            statusCode: {
                200: function () {
                    alert("修改成功");

                },
                500: function () {
                    alert("修改失败");
                }
            }
        });
        var layerIndex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(layerIndex); //再执行关闭
        window.parent.location.href = window.parent.location.href;
    }

</script>

</body>
</html>