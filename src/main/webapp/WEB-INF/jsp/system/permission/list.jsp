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
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/jquery.dataTables.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.1.12.4.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/jquery.ztree.all.min.js"></script>
    <script src="${ctx}/js/layer/layer.js"></script>
    <script src="${ctx}/js/jquery.dataTables.min.js"></script>
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
                             权限管理
                         </span>
                        <div class="btn-group pull-right" style="margin-top: -5px;">
                            <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-sign-in"></i> 导入
                            </button>
                            <button type="button" data-toggle="modal" data-target="#zqdlModal" class="btn btn-primary btn-sm"><i class="fa fa-sign-out"></i> 导出</button>
                            <%--模态框--%>
                            <div class="modal fade" id="zqdlModal" tabindex="-1" role="dialog" aria-label="zqdlLabel" aria-hidden="true">
                                <div class="modal-dialog" style="z-index:9999;">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="zqdlLabel">导出字段</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table>
                                                <tr>
                                                    <td><label><input type="checkbox" name="exportColumn" value="xmmc" checked disabled/>项目名称</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="xmlb"/>项目类别</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="xmzl"/>项目子类</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="xmbh"/>项目编号</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="bjfx"/>边界方向</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="sslx"/>设施类型</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="jsqy"/>建设区域</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="jsdd"/>建设地点</label></td>
                                                </tr>
                                                <tr>
                                                    <td><label><input type="checkbox" name="exportColumn" value="jwd"/>经纬度&#12288;</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="dxlb"/>地形类别</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="jsxz"/>建设性质</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="sydw"/>使用单位</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="sbdw"/>申报单位</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="zytz"/>中央投资</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="dftz"/>地方投资</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="remark"/>备注&#12288;&#12288;</label></td>
                                                </tr>
                                                <tr>
                                                    <td><label><input type="checkbox" name="exportColumn" value="tznd"/>投资年度</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="jsgm"/>建设规模</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="dllb"/>道路类别</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="dllx"/>道路类型</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="dldj"/>道路等级</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="ljlx"/>路基类型</label></td>
                                                    <td><label><input type="checkbox" name="exportColumn" value="lmlx"/>路面类型</label></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="button" class="btn btn-primary">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary btn-sm" onclick="addRole()"><i class="fa fa-plus"></i> 添加</button>
                        </div>
                    </div>
                    <table class="table table-bordered table-striped table-hover" id="sysRole">
                        <thead>
                        <tr>
                            <th>角色名</th>
                            <th>roleKey</th>
                            <th>状态</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sysRoles}" var="sysRole">
                            <tr>
                                <td>${sysRole.name}</td>
                                <td>${sysRole.rolekey}</td>
                                <td>${sysRole.isenable}</td>
                                <td>${sysRole.description}</td>
                                <td>
                                    <button class="btn btn-primary btn-xs" onclick="alert('修改成功')">编辑</button>
                                    <button class="btn btn-danger btn-xs" onclick="deleteRole(${sysRole.id})">删除</button>
                                    <button class="btn btn-info btn-xs" onclick="assign(${sysRole.id})">分配权限</button>
                                </td>
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
        $('#sysRole').DataTable();
    });


</script>

<script>

    function deleteRole(id) {

        //询问框

        layer.confirm('您确定要删除吗？', {
            btn: ['我确定','再想想'] //按钮
        }, function(){
            $.ajax({
                type : "post",
                url : "${ctx}/permission/deleteRole.action",
                dataType : "json",
                data : {
                    id : id
                },
                statusCode : {
                    200 : function () {
                        alert("删除成功");
                    },
                    409 : function () {
                        alert("有用户正在使用该角色");
                    },
                    500 : function () {
                        alert("删除失败");
                    }
                }
            });
            window.location.href = window.location.href;
        }, function(){
           /* layer.msg('也可以这样', {
                time: 20000, //20s后自动关闭
                btn: ['明白了', '知道了']
            });*/
        });


    }

    function assign(roleId) {
        //加载层
        var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '分配权限',
            area: ['700px', '460px'],
            skin: 'layui-layer-rim', //加上边框
            content: '${ctx}/permission/assignPermissionPage.action?id='+roleId
        });
        //关闭加载效果
        layer.close(index);
    }

    function addRole() {
        //加载层
        var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '添加角色',
            area: ['450px', '380px'],
            skin: 'layui-layer-rim', //加上边框
            content: '${ctx}/permission/addRolePage.action',
            end : function () {
                location.reload();
            }
        });
        //关闭加载效果
        layer.close(index);
    }
</script>

</body>
</html>