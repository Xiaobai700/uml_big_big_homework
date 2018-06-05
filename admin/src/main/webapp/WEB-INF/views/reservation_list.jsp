<%--
  Created by IntelliJ IDEA.
  User: zhangqiao
  Date: 2018/5/31
  Time: 18:08
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
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>预约列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 预约管理 <span class="c-gray en">&gt;</span> 预约列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div style="width: 100%">
    <div style="width: 220px;background-color: #5a98de;float: left">
    <span class="select-box">
      <select class="select" id="reservationStatus" size="1" name="demo1">
        <option value="-2" selected>选择状态</option>
        <option value="-1">取消</option>
        <option value="0">客人还未到</option>
        <option value="1">客人到达</option>
        <option value="2">调换餐桌</option>
        <option value="3">用餐结束</option>
      </select>
    </span>
    </div>
    <div style="width: 220px;background-color: #5a98de;float: left">
    <span class="select-box">
      <select class="select" id="flag" size="1" name="demo1">
        <option value="-1" selected>选择类型</option>
        <option value="0">提前预约</option>
        <option value="1">直接进店</option>
      </select>
    </span>
    </div>
</div>
<div class="page-c。ontainer">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l"> <a href="javascript:;" onclick="add_walk_in('添加walk-in','add_walkIn.html','400','300')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加walk-in</a></span>
        <table class="table table-border table-bordered table-bg">
            <thead>
            <tr>
                <th scope="col" colspan="9">预约列表</th>
            </tr>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="100">顾客姓名</th>
                <th width="150">用餐时间</th>
                <th width="100">用餐人数</th>
                <th width="100">当前状态</th>
                <th width="100">备注</th>
                <th width="100">类型</th>
                <th width="100">餐桌号</th>
                <th width="100">创建时间</th>
                <th width="100">最新更新时间</th>
                <th width="100">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/admin/reservation_list.js"></script>
<script type="text/javascript">
    function add_walk_in(title,url,w,h) {
        layer_show(title,url,w,h);
    }
</script>
</body>
</html>
