<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>安全传感器</title>

    <link href="${ctx}/resources/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${ctx}/resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="${ctx}/resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${ctx}/resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="${ctx}/resources/css/admin.css" rel="stylesheet"/>
    <style>
        /** skins **/
        #zheng-upms-server .content_tab {
            background: #29A176;
        }

        #zheng-upms-server .s-profile > a {
            background: url(${ctx}/resources/images/zheng-upms.png) left top no-repeat;
        }

        #zheng-cms-admin .content_tab {
            background: #455EC5;
        }

        #zheng-cms-admin .s-profile > a {
            background: url(${ctx}/resources/images/zheng-cms.png) left top no-repeat;
        }

        #zheng-pay-admin .content_tab {
            background: #F06292;
        }

        #zheng-pay-admin .s-profile > a {
            background: url(${ctx}/resources/images/zheng-pay.png) left top no-repeat;
        }

        #zheng-ucenter-home .content_tab {
            background: #6539B4;
        }

        #zheng-ucenter-home .s-profile > a {
            background: url(${ctx}/resources/images/zheng-ucenter.png) left top no-repeat;
        }

        #zheng-oss-web .content_tab {
            background: #0B8DE5;
        }

        #zheng-oss-web .s-profile > a {
            background: url(${ctx}/resources/images/zheng-oss.png) left top no-repeat;
        }

    </style>
</head>
<body>
<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img src="${ctx}/resources/images/avatar.jpg"/>
                </div>
                <div class="sp-info">
                    ${sessionScope.userInfo.name}，您好！
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">
              <%--  <li>
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-account"></i> 个人资料</a>
                </li>
                <li>
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                </li>--%>
                <li>
                    <a class="waves-effect" href="javascript:modifyPassword()"><i class="zmdi zmdi-settings"></i> 修改密码</a>
                </li>
                <li>
                    <a class="waves-effect" href="${ctx}/user/logout.action;"><i class="zmdi zmdi-run"></i> 退出登录</a>
                </li>
            </ul>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu">
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i>首页</a>
            </li>
            <li class="sub-menu system_menus system_1 0">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 传感器列表</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('激光', '${ctx}/sensor/index.action?type=laser');">激光</a>
                    </li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('粉尘', '${ctx}/sensor/index.action?type=dust');">粉尘</a>
                    </li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('温度', '${ctx}/sensor/index.action?type=temperature');">温度</a>
                    </li>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('湿度', '${ctx}/sensor/index.action?type=humidity');">湿度</a></li>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('可燃气体', '${ctx}/sensor/index.action?type=gas');">可燃气体</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('接地电阻', '${ctx}/sensor/index.action?type=resistance');">接地电阻</a>
                    </li>
                </ul>
            </li>
            <c:if test="${sessionScope.userInfo.role == 1}">
            <%--<li class="sub-menu system_menus system_1 3">--%>
                <%--<a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts"></i> 日志管理</a>--%>
                <%--<ul>--%>
                    <%--<li><a class="waves-effect" href="javascript:Tab.addTab('登录日志', '${ctx}/loginLogs/list.action');">登录日志</a>--%>
                    <%--</li>--%>
                    <%--<li><a class="waves-effect" href="javascript:Tab.addTab('操作日志', '${ctx}/operateLogs/list.action');">操作日志</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <li class="sub-menu system_menus system_1 6">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-lock-outline"></i> 系统管理</a>
                <ul>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('用户管理', '${ctx}/user/list.action');">用户管理</a></li>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('厂房管理', '${ctx}/workshop/list.action');">厂房管理</a></li>
                    <%--<li><a class="waves-effect" href="javascript:Tab.addTab('权限管理', '${ctx}/permission/list.action');">权限管理</a></li>--%>
                </ul>
            </li>
            </c:if>
        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">
        <div class="content_tab">
            <div class="tab_left">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
            </div>
            <div class="tab_right">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
            </div>
            <ul id="tabs" class="tabs">
                <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                    <a class="waves-effect waves-light">首页</a>
                </li>
            </ul>
        </div>
        <div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <p><h4>安全传感器管理系统</h4></p>
                <p><b>联系人</b>：陈楠，张超。</p>
                <p><b>手机号</b>：13693638357， 13810331605。</p>
                <p><b>公司</b>：北京航天长峰科技工业集团有限公司。</p>
                <p><h4>关于作者</h4></p>
                <p><b>姓　　名</b>：张超</p>
                <p><b>电子邮箱</b>：915749631@qq.com</p>
            </div>
        </div>
    </section>
</section>

<script>
    function modifyPassword() {
        //iframe层-禁滚动条
        layer.open({
            type: 2,
            title: '修改密码',
            area: ['500px', '280px'],
            skin: 'layui-layer-rim', //加上边框
            content: '${ctx}/user/modifyPasswordUI.action'
        });
    }
</script>

<script src="${ctx}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${ctx}/resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${ctx}/resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${ctx}/resources/plugins/BootstrapMenu.min.js"></script>
<script src="${ctx}/resources/plugins/device.min.js"></script>
<script src="${ctx}/resources/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${ctx}/resources/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${ctx}/resources/plugins/jquery.cookie.js"></script>
<script src="${ctx}/resources/js/admin.js"></script>
<script src="${ctx}/js/layer/layer.js"></script>
</body>
</html>