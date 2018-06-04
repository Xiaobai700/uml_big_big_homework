<%--
  Created by IntelliJ IDEA.
  User: zhangqiao
  Date: 2018/5/28
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <script type="text/javascript" src="lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
    <link href="lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>后台登录 -好食物餐厅预订系统V1.0</title>
    <style type="text/css">
        body{font-size:14px}

        .header,.footer{ position:absolute; left:0; right:0; width:100%;
            height:80px; z-index:99}
        .header{
            color: white;
            text-align: center;

        }

        .loginWraper{ position:absolute;width:100%; left:0; top:0; bottom:0; right:0; z-index:1; background: url(img/3.jpg) no-repeat center}
        .loginBox{ position:absolute; width:617px; height:330px; background:url(img/login_bg.png) no-repeat; left:50%; top:50%; margin-left:-309px; margin-top:-184px; padding-top:38px}
        @media (max-width:617px) {
            .loginbox{ width:100%; position:static; margin-top:0; margin-left:0;}
        }
        .loginBox .row{margin-top:20px;}
        .loginBox .row .form-label .Hui-iconfont{ font-size:24px}
        .loginBox .input-text{ width:360px}
        @media (max-width:617px) {
            .loginBox .input-text{ width:80%}
        }
        .yzm a{  font-size:12px}

        .hd_msg a{ color:#fff}
        .hd_msg a:hover{ color:#fff; text-decoration:underline}

        .footer{ height:46px; line-height:46px; bottom:2px; text-align:center; color:#fff; font-size:12px; }

        #ie6-warning a {text-decoration:none}
    </style>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header" style="background-color: #94A5E0;">
    <h2>餐厅预订系统  V1.0</h2>
</div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text" placeholder="账户" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>

            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input name="loginbtn" type="button" id="loginbtn"class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer" style="background-color: #94A5E0;">Copyright 南京邮电大学</div>
<script type="text/javascript" src="lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript">
    $("#loginbtn").click(function(){
        var account = $('#username').val();
        var password = $('#password').val();
        $.ajax({
            type: "Post",
            url: "loginCheck.json",
            data: {
                account:account,
                password:password
            },
            dataType: "json",
            success: function(data){
                if(data.code==0){
                    layer.msg('登录成功,系统进入中!',{icon:1,time:1000},function(){
                        window.location.href="index.html";
                    });
                }else{
                    layer.msg('登录失败！!', {icon:1,time:1000});
                }
            },
            error: function(e) {
                layer.msg('登录失败!',{icon:1,time:1000});
            }
        });
    });
</script>
</body>
</html>