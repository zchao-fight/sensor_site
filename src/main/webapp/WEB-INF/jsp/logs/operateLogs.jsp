<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ccf" uri="http://ccf.cn/common" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
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
            margin-left:10px;
            margin-bottom:15px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">

                </div>

                <div class="panel-body">
                    <form class="form-inline" action="${ctx}/operateLogs/list.action" method="get">
                        <div class="form-group">
                            <label for="username">账号&nbsp;</label>
                            <input type="text" class="form-control" id="username" value="${username }" name="username" style="width: 150px;">
                        </div>
                        <button type="submit" class="btn btn-primary">查 询</button>
                    </form>
                </div>

                <table class="table table-bordered table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>账号</th>
                        <th>模块</th>
                        <th>方法</th>
                        <th>响应时间</th>
                        <th>ip地址</th>
                        <th>执行时间</th>
                        <th>执行描述</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.rows}" var="log">
                        <tr>
                            <td>${log.username}</td>
                            <td>${log.module}</td>
                            <td>${log.methods}</td>
                            <td>${log.actionTime}</td>
                            <td>${log.userIP}</td>
                            <td>${log.operTime}</td>
                            <td>${log.description}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <div class="pull-right">
                    <ccf:pagination url="${ctx}/operateLogs/list.action" />
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var setting = {
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: -1
            }
        },
        view: {
            showLine: false
        }
    };
    var zNodes = [
        {id: 1, pId: 0, name: "交通保障设施", open: true},
        {id: 11, pId: 1, name: "执勤道路", click: 'checkRoad(11)'},
        {id: 12, pId: 1, name: "桥梁", click: 'checkRoad(12)'},
        {id: 13, pId: 1, name: "执勤码头", click: 'checkRoad(13)'},
        {id: 14, pId: 1, name: "直升机停机坪", click: 'checkRoad(14)'},
        {id: 2, pId: 0, name: "拦阻报警设施", open: true},
        {id: 21, pId: 2, name: "铁丝网", click: 'checkRoad(1)'},
        {id: 22, pId: 2, name: "铁栅栏", click: 'checkRoad(1)'},
        {id: 23, pId: 2, name: "隔离带", click: 'checkRoad(1)'},
        {id: 24, pId: 2, name: "拦阻桩", click: 'checkRoad(1)'},
        {id: 25, pId: 2, name: "拒马", click: 'checkRoad(1)'},
        {id: 26, pId: 2, name: "报警线路", click: 'checkRoad(1)'},
        {id: 3, pId: 0, name: "指挥监控设施", open: true, click: false},
        {id: 31, pId: 3, name: "监控中心", click: 'checkRoad(1)'},
        {id: 32, pId: 3, name: "监控站", click: 'checkRoad(1)'},
        {id: 33, pId: 3, name: "视频前端", click: 'checkRoad(1)'},
        {id: 34, pId: 3, name: "显控终端", click: 'checkRoad(1)'},
        {id: 35, pId: 3, name: "传输线路", click: 'checkRoad(1)'},
        {id: 36, pId: 3, name: "报警装置", click: 'checkRoad(1)'},
        {id: 37, pId: 3, name: "供电系统", click: 'checkRoad(1)'},
        {id: 38, pId: 3, name: "无人值守电子哨兵", click: 'checkRoad(1)'},
        {id: 39, pId: 3, name: "军警民联防平台", click: 'checkRoad(1)'},
        {id: 4, pId: 0, name: "辅助配套设施", open: true, click: false},
        {id: 41, pId: 4, name: "执勤房", click: 'checkRoad(1)'},
        {id: 42, pId: 4, name: "瞭望塔", click: 'checkRoad(1)'},
        {id: 43, pId: 4, name: "标志牌", click: 'checkRoad(1)'},
        {id: 44, pId: 4, name: "灯塔", click: 'checkRoad(1)'},
        {id: 45, pId: 4, name: "灯浮", click: 'checkRoad(1)'},
        {id: 46, pId: 4, name: "浮标", click: 'checkRoad(1)'}
    ];


    $(document).ready(function () {
        $.fn.zTree.init($("#ztree"), setting, zNodes);
    });

    function checkRoad(type) {
        location.href = "${ctx}/overall/list.action?type=" + type;

    }

</script>
<script>
    function permit() {
        //加载层
        var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '修改密码',
            area: ['550px', '660px'],
            skin: 'layui-layer-rim', //加上边框
            content: [rootPath + '/overall/permit.shtml', 'no']
        });
        //关闭加载效果
        layer.close(index);
    }
</script>

</body>
</html>