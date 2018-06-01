<%--
  Created by IntelliJ IDEA.
  User: zhangqiao
  Date: 2018/5/29
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="/favicon.ico">
    <LINK rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <script type="text/javascript" src="lib/PIE_IE678.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.7/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="lib/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>餐厅预订管理系统</title>
</head>
<body>
<!--头部-->
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">餐厅预订管理系统</a><span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onclick="add_channel('添加频道','add_channel.html')"><i class="Hui-iconfont">&#xe616;</i> 频道</a></li>
                            <li><a href="javascript:;" onclick="add_news('添加新闻','add_news.html')"><i class="Hui-iconfont">&#xe613;</i> 新闻</a></li>
                            <li><a href="javascript:;" onclick="product_add('增加广告','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 广告</a></li>
                            <li><a href="javascript:;" onclick="add_admin('添加管理员','add_admin.html','','510')"><i class="Hui-iconfont">&#xe62c;</i> 管理员</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>超级管理员</li>
                    <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${adminName}<i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="#">个人信息</a></li>
                            <li><a href="#">切换账户</a></li>
                            <li><a href="login_out.html">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">3</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header><!--侧边栏导航-->
<aside class="Hui-aside">
    <input runat="server" id="divScrollValue" type="hidden" value=""/>
    <div class="menu_dropdown bk_2">
        <!--系统用户管理-->
        <dl id="menu-article">
            <dt><i class="Hui-iconfont">&#xe62c;</i>&nbsp;&nbsp;员工管理<i class="Hui-iconfont menu_dropdown-arrow">
                &#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="staff_list.html" data-title="员工列表" href="javascript:void(0)">员工列表</a></li>
                </ul>
            </dd>
        </dl>
        <!--APP用户管理-->
        <dl>
            <dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;&nbsp;顾客管理<i class="Hui-iconfont menu_dropdown-arrow">
                &#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="customer_list.html" data-title="顾客列表" href="javascript:void(0)">顾客列表</a></li>
                </ul>
            </dd>
        </dl>
        <%--预订管理--%>
        <dl>
            <dt><i class="Hui-iconfont">&#xe616;;</i>&nbsp;&nbsp;预订管理<i class="Hui-iconfont menu_dropdown-arrow">
                &#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="reservation_list.html" data-title="预订信息列表" href="javascript:void(0)">预订信息列表</a></li>
                </ul>
            </dd>
        </dl>
        <%--餐桌管理--%>
        <dl>
            <dt><i class="Hui-iconfont">&#xe61d</i>&nbsp;&nbsp;餐桌管理<i class="Hui-iconfont menu_dropdown-arrow">
                &#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="table_list.html" data-title="餐桌列表" href="javascript:void(0)">餐桌列表</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>

<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<!--右边展示区域-->
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">
            &#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
        </div>
    </div>
</section>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
    /*频道添加*/
    function add_channel(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-增加*/
    function add_admin(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*新闻添加*/
    function add_news(title,url,w,h){
        layer_show(title,url,w,h);
    }

</script>
</body>
</html>