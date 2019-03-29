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
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <style type="text/css">
        .col-sm-3 {
            width: 15%;
            float: left;
        }

        .col-sm-9 {
            width: 85%;
            float: left;
        }
        label[class^="btn btn-default"]{
            margin-top: -4px;
        }
    </style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form id="form" name="form" class="form-horizontal" method="post" >
    <section class="panel panel-default">
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入角色名" name="name" id="name">
                </div>
            </div>
            <div class="line line-dashed line-lg pull-in"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label">roleKey</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入roleKey" name="rolekey" id="roleKey">
                </div>
            </div>
            <div class="line line-dashed line-lg pull-in"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" placeholder="请输入账号描述"
                           name="description" id="description">
                </div>
            </div>
            <div class="line line-dashed line-lg pull-in"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label">角色状态</label>
                <div class="col-sm-9">
                    <div class="btn-group m-r">
                        <select name="isenable" class="form-control">
                            <option value="true">是</option>
                            <option value="false">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="line line-dashed line-lg pull-in"></div>
        </div>
        <footer class="panel-footer text-right bg-light lter">
            <button type="submit" class="btn btn-success btn-s-xs" onclick="addRole()">提交</button>
        </footer>
    </section>
</form>
<script>


    function addRole() {
        $.ajax({
            type : "post",
            dataType : "json",
            url : "${ctx}/permission/addRole.action",
            data : $("#form").serialize(),
            statusCode : {
                201 : function () {
                    alert("新增成功");
                    //假设这是iframe页
                    var layerIndex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(layerIndex); //再执行关闭
                },
                500 : function () {
                    alert("新增失败");
                }
            }
        })
    }


</script>
</body>
</html>