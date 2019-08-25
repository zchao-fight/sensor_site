<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/jquery.dataTables.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.1.12.4.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/jquery.ztree.all.min.js"></script>
    <script src="${ctx}/js/layer/layer.js"></script>
    <script src="${ctx}/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/js/sensor.js"></script>
    <!--[if lt IE 9]>
    <script src="${ctx}/js/jquery/ie/html5shiv.js"></script>
    <script src="${ctx}/js/jquery/ie/respond.min.js"></script>
    <![endif]-->
    <style>
        table tr td {
            text-align: center;
            vertical-align: middle;
        }

        table tr th {
            text-align: center;
            vertical-align: middle;
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
                       历史进出记录
                   </span>
                    <div class="btn-group pull-right" style="margin-top: -5px;">
                        <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-sign-in"></i> 导入
                        </button>
                        <button type="button" data-toggle="modal" data-target="#zqdlModal"
                                class="btn btn-primary btn-sm"><i class="fa fa-sign-out"></i> 导出
                        </button>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="refresh()"><i class="fa fa-plus"></i> 刷新
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" id="sysUser">
                    <thead>
                    <tr>
                        <th>厂房编号</th>
                        <th>工作证号</th>
                        <th>人员姓名</th>
                        <th>进入时间</th>
                        <th>离开时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="history">
                        <tr>
                            <td>${history.workshopId}</td>
                            <td>${history.workId}</td>
                            <td>${history.name}</td>
                            <td>${history.entryTime}</td>
                            <td>${history.departureTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>

    //新加的
    $(document).ready(function () {
        $('#sysUser').DataTable(
            {
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                }
            }
        );
    });


    function refresh() {
        window.location.reload();
    }
</script>

</body>
</html>