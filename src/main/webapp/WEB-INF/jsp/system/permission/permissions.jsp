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
</head>
<style type="text/css">

    #mytable {
        width: 660px;
        padding: 0;
        margin: 0;
    }

    caption {
        padding: 0 0 5px 0;
        width: 660px;
        font: italic 13px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        text-align: right;
    }

    th {
        font: bold 13px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        color: #4f6b72;
        border-right: 1px solid #C1DAD7;
        border-bottom: 1px solid #C1DAD7;
        border-top: 1px solid #C1DAD7;
        letter-spacing: 2px;
        text-transform: uppercase;
        text-align: left;
        padding: 6px 6px 6px 12px;
    }

    th.nobg {
        border-top: 0;
        border-left: 0;
        border-right: 1px solid #C1DAD7;
    }

    #mytable td {
        border-right: 1px solid #C1DAD7;
        border-bottom: 1px solid #C1DAD7;
        font-size: 11px;
        padding: 6px 6px 6px 12px;
        color: #4f6b72;
    }

    td.alt {
        color: #797268;
    }

    th.spec {
        border-left: 1px solid #C1DAD7;
        border-top: 0;
        font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
    }

    th.specalt {
        border-left: 1px solid #C1DAD7;
        border-top: 1px solid #C1DAD7;
        font: bold 13px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        color: #797268;
    }

    /*---------for IE 5.x bug*/
    html > body td {
        font-size: 13px;
    }
</style>
<script type="text/javascript">
    function smenu(obj, id) {
        $("input[_key='menu_1_" + id + "']").each(function () {
            $(this).prop("checked", obj.checked);
        });
        $("input[_key='menu_1_1_" + id + "']").each(function () {
            $(this).prop("checked", obj.checked);
        });
    }

    function menu_1(obj, id, pid) {
        $("input[_key_2='menu_1_1_" + id + "']").each(function () {
            $(this).prop("checked", obj.checked);
        });
        if (obj.checked == true) {
            $("input[_key='menu_" + pid + "']").each(function () {
                $(this).prop("checked", obj.checked);
            });
        }
    }

    function menu_1_1(obj, id, pid) {
        if (obj.checked == true) {
            $("input[_key_1='menu_1_1_" + id + "']").each(function () {
                $(this).prop("checked", obj.checked);
            });
            $("input[_key='menu_" + pid + "']").each(function () {
                $(this).prop("checked", obj.checked);
            });
        }
    }

    function closeWin() {
        layer.confirm('是否关闭窗口？', {icon: 3, offset: '100px'}, function (index) {
            //假设这是iframe页
            var layerIndex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(layerIndex); //再执行关闭
        });
    }

    function sub() {
        $.ajax({
            type: "post",
            data: $("#form").serialize(),
            url : "${ctx}/permission/assignPermissions.action",
            dataType : "json",
            success : function (data) {
                if (data === "success") {
                    layer.confirm('分配成功！是否关闭窗口？', {icon: 3, offset: '-100px'}, function () {
                        var layerIndex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(layerIndex); //再执行关闭
                        return false;
                    });
                } else {
                    layer.alert(data, {icon: 2, offset: '-100px'});
                }
            }
        });

    }
</script>
<body>
<form method="post" id="form" name="form">
    <input id='roleId' name="roleId" type="hidden" value="${roleId}">
    <table id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
        <tr>
            <th scope="row" abbr="L2 Cache" class="specalt">一级菜单</th>
            <th scope="row" abbr="L2 Cache" class="specalt"><span>二级菜单</span><span
                    style="float: right;margin-right: 150px;">按扭</span></th>
        </tr>
        <c:forEach items="${permissions}" var="k">
            <tr>
                <th scope="row" abbr="L2 Cache" class="specalt">
                    <input type="checkbox" name="resId" id="menu" _key="menu_${k.id}" onclick="smenu(this,'${k.id}')"
                           value="${k.id}">
                        ${k.resName}
                </th>
                <th scope="row" abbr="L2 Cache" class="specalt">
                    <table id="mytable" cellspacing="0"
                           summary="The technical specifications of the Apple PowerMac G5 series"
                           style="width: 100%;height: 100%;">
                        <c:forEach items="${k.children}" var="kc">
                            <tr>
                                <th scope="row" abbr="L2 Cache" class="specalt">
                                    <input type="checkbox" name="resId" id="menu" _key="menu_1_${k.id}"
                                           _key_1="menu_1_1_${kc.id}" onclick="menu_1(this,'${kc.id}','${k.id}')"
                                           value="${kc.id}">
                                        ${kc.resName}
                                </th>
                                <th>
                                    <c:if test="${not empty kc.children}">
                                        <table id="mytable" cellspacing="0"
                                               summary="The technical specifications of the Apple PowerMac G5 series"
                                               style="width: 100%;height: 100%;">
                                            <c:forEach items="${kc.children}" var="kcc">
                                                <tr>
                                                    <th scope="row" abbr="L2 Cache" class="specalt">
                                                        <input type="checkbox" name="resId" id="menu"
                                                               _key="menu_1_1_${k.id}" _key_2="menu_1_1_${kc.id}"
                                                               onclick="menu_1_1(this,'${kc.id}','${k.id}')"
                                                               value="${kcc.id}">
                                                            ${kcc.resName}
                                                    </th>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </c:if>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>
                </th>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="doc-buttons" style="text-align: center;">
        <a href="#" class="btn btn-s-md btn-success btn-rounded" onclick="sub()">保存</a>
        <a href="#" class="btn btn-info btn-rounded" onclick="closeWin();">关闭</a>
    </div>
    <br>
</form>
<script type="text/javascript">
  $.ajax({
        type: "POST",
        data: {
            "roleId": "${roleId}"
        },
        url: '${ctx}/permission/findRes.action',
        dataType: 'json',
        success: function (json) {
            for (index in json) {
                $("input[name='resId']:checkbox[value='" + json[index].id + "']").prop(
                    'checked', 'true');
            }
        }
    });
</script>
</body>
</html>