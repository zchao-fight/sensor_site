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
                           value="${userInfo.id}" name="id">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">用户名</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                          value="${userInfo.username}" name="username" id="username" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">真实姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control checkacc"
                           value="${userInfo.name}" name="name" id="name">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">单位</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${userInfo.orgName}"  name="orgName" id="orgName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">部门</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${userInfo.depName}" name="depName" id="depName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">卡号</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" class="form-control"
                           value="${userInfo.echoWorkId}" name="echoWorkId" id="echoWorkId">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label">角色</label>
                </div>
                <div class="col-sm-9">
                  <select name="role" class="form-control">
                      <option value="0" <c:if test="${userInfo.role == 0}">  selected </c:if>>普通用户</option>
                      <option value="1" <c:if test="${userInfo.role == 1}">  selected </c:if>>管理员</option>
                  </select>
                </div>
            </div>
            <footer class="panel-footer text-right bg-light lter">
                <button type="submit" class="btn btn-success btn-s-xs" onclick="editUser()">提交</button>
            </footer>
        </div>
    </section>
</form>

<script>
    function editUser() {

        $.ajax({
            type: "post",
            url: "${ctx}/user/editUser.action",
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