<%--
  Created by IntelliJ IDEA.
  User: zhangqiao
  Date: 2018/6/5
  Time: 13:13
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
    <title>add walk-in</title>
</head>
<body>
<div>
    <div style="text-align: center;margin-top: 10px;">
        用餐人数：<input placeholder="请输入用餐人数" name="eatPeople" id="eatPeople"/>
    </div>
    <div style="text-align: center;margin-top: 10px;">
        用户姓名：<input placeholder="请输入用户姓名" name="eatName" id="eatName"/>
    </div>
    <div style="text-align: center;margin-top: 10px;">
        <button class="btn btn-primary" onclick="add_walk_in()">请系统分配餐桌</button>
    </div>

</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/admin/table_list.js"></script>
<script type="text/javascript">
    function add_walk_in() {
        var count = $("#eatPeople").val();
        var name = $("#eatName").val();
//        var value = document.getElementById("inputId").value;
        var reg=/^[1-9]\d*$|^0$/;   // 注意：故意限制了 0321 这种格式，如不需要，直接reg=/^\d+$/;

        if(count == ""){
            layer.msg("请输入用餐人数", {icon: 5, time: 1000});
        }else if(name == ""){
            layer.msg("请输入顾客姓名", {icon: 5, time: 1000});
        }else if(!reg.test(count)==true) {
            layer.msg("用餐人数输入不正确，请重新输入！", {icon: 5, time: 1000});
        }else {
            $.ajax({
                url:"add_Reservation.json",
                data : {
                    token:0,
                    tablewareNumber:count,
                    mealTime:"2018",
                    flag:1
                },
                type : 'post',
                success : function(data) {
                    if (data.code == 0) {
                        layer.msg("桌号为"+data.tableid,{icon: 6, time: 1000});
                    } else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                },
                error : function(msg) {
                    layer.msg('操作失败!', {icon: 5, time: 1000});

                }
            });
        }

    }
</script>
</body>
</html>