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
                    <label class="control-label">用户名</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           placeholder="请输入用户名" name="username" id="username">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">真实姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           placeholder="请输入姓名" name="name" id="name">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc" style="color: red;"
                           value="111111" name="password" id="password" >
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">单位</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="orgName" id="orgName" >
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">部门</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="depName" id="depName" >
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">卡号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           name="echoWorkId" id="echoWorkId" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <select name="role" class="form-control">
                        <option value="0" >普通用户</option>
                        <option value="1">管理员</option>
                    </select>

                </div>
            </div>
        </div>
        <footer class="panel-footer text-right bg-light lter">
            <button type="button" class="btn btn-success btn-s-xs" onclick="addUser()">提交</button>
        </footer>
    </section>
</form>
<script type="text/javascript">

    function addUser() {

        sensor.post("${ctx}/user/addUser.action",$("#form").serialize(),function () {
           setTimeout(function () {
               window.parent.location.reload();
           }, 2000);
           sensor.succMsg("添加成功")
        });
    }


</script>

</body>
</html>