<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>根据起始点和结束点规划路线</title>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css"/>
    <%@include file="head.jsp"%>
    <script type="text/javascript" src="<%=path%>/ui/jquery/jquery.js"></script>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>

    <style type="text/css">
        body {
            font-size: 12px;
        }
        #tip {
            background-color: #ddf;
            color: #333;
            border: 1px solid silver;
            box-shadow: 3px 4px 3px 0px silver;
            position: absolute;
            top: 10px;
            right: 10px;
            border-radius: 5px;
            overflow: hidden;
            line-height: 20px;
        }
        #tip input[type="text"] {
            height: 25px;
            border: 0;
            padding-left: 5px;
            width: 280px;
            border-radius: 3px;
            outline: none;
        }
        button#search {
            width: 100px;
            height: 28px;
            margin-left: 20px;
            margin-right: 10px;
        }

    </style>

    <style type="text/css">
        #panel {
            margin-top: 70px;
            position: absolute;
            background-color: white;
            max-height: 80%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 250px;
            border: solid 1px silver;
        }
    </style>
</head>
<body>
<div id="mapContainer"></div>
<div id="panel">
</div>
<div id="tip">
    <p>
        起始点：<input type="text" id="start" name="start" class="input-large controller-text" placeholder="请输入起始点"/>
        结束点：<input type="text" id="end" name="end" class="input-large controller-text" placeholder="请输入结束点"/>
        <button id="search" name="search" value="查询" onclick="click">查询</button>
    </p>
<script type="text/javascript">
    var map = new AMap.Map("mapContainer", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13 //地图显示的缩放级别
    });

    var click = $("#search").click(function () {
        if (map!=null){
            map.clearMap() ;
            $("#panel").empty()
        }
        var start = $("#start").val() ;
        var end = $("#end").val() ;

        if (start==null||start==""){
            alert("起始点不能为空，请重新输入！");
            return ;
        }
        if (end==null||end==""){
            alert("结束点不能为空，请重新数据！") ;
            return ;
        }

        //加载公交换乘插件
        AMap.service(["AMap.Transfer"], function() {
            var transOptions = {
                map: map,
                city: '北京市',
                panel:'panel',
                //cityd:'乌鲁木齐',
                policy: AMap.TransferPolicy.LEAST_TIME //乘车策略
            };
            //构造公交换乘类
            var trans = new AMap.Transfer(transOptions);
            //根据起、终点坐标查询公交换乘路线
            trans.search([{keyword:start},{keyword:end}], function(status, result){

            });
        });
    }) ;
</script>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
</div>
</body>
</html>