<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="../head.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path%>lib/html5.js"></script>
<script type="text/javascript" src="<%=path%>lib/respond.min.js"></script>
<![endif]-->
<link href="<%=path%>static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>static/h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<title>后台登录</title>
<%--<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">--%>
</head>
<body onkeydown="onloginkey()">
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
	<div id="loginform" class="loginBox">
		<form class="form form-horizontal" action="<%=pagepath%>index.do" method="post">
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
				<div class="formControls col-xs-8">
					<input id="username" name="username" type="text" placeholder="账户" class="input-text size-L" maxlength="30">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
				<div class="formControls col-xs-8">
					<input id="password" name="password" type="password" placeholder="密码" class="input-text size-L" maxlength="20">
				</div>
			</div>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
					<img src="<%=page%>images/VerifyCode.aspx.png">
					<a id="kanbuq" href="javascript:;">看不清，换一张</a>
				</div>
			</div>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<label for="online">
						<input type="checkbox" name="online" id="online" value="">
						使我保持登录状态</label>
				</div>
			</div>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" onclick="login()">
					<input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
				</div>
			</div>
		</form>
	</div>
</div>
<div class="footer">Copyright 你的公司名称 by H-ui.admin.page.v3.0</div>

<script type="text/javascript" src="<%=path%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>static/h-ui/js/H-ui.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();

function login() {
	var userName = $("#username").val() ;
	var password=$("#password").val() ;
	var loginType = $('input:radio[name="loginType"]:checked').val() ;
	if(isEmptyValue(userName)){
	    $("#msg").html("登录名不能为空！").show() ;
	    setTimeout(disMsg(),3000) ;
	    return false ;
	}

	if(isEmptyValue(password)){
        $("#msg").html("登录密码不能为空！！").show() ;
        setTimeout(disMsg(),3000) ;
        return false ;
	}
	$.ajax({
		type:"POST",
		url:"<%=path%>/page/login",
		data:"username="+userName+"&password="+password+"&loginType="+loginType,
		dataType:"JSON",
		async:false,
		success:function(result) {
		    if(result.success==true){
		        if(loginType==1){
		            window.location.href="<%=page%>/page/main" ;
				}else if(loginType==2){
                    window.location.href="<%=page%>/page/adminlist" ;
				}
			}else{
                $("#msg").html("用户名或密码有误！").show() ;
                setTimeout(disMsg(),3000) ;
                return false ;
			}
        }
	})

	function isEmptyValue(str) {
		if (str==""||str=="undefined"||str==null||str=="undefined"||typeof str=="undefined"){
		    return true ;
		}else {
		    return false ;
		}
    }
    function onloginkey() {
		if(window.event.keyCode==13){
		    login() ;
		}
    }
    function disMsg() {
		$("#msg").hide() ;
    }
}

</script>
</body>
</html>