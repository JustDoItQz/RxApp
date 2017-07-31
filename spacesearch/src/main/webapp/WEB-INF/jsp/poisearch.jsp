<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>输入提示后查询</title>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css"/>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <%@include file="head.jsp"%>
    <script type="text/javascript" src="<%=path%>/ui/jquery/jquery.js"></script>
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

    </style>
</head>
<body>
<div id="mapContainer"></div>
<div id="tip">
    <p>
        请输入查询城市:<input id="city" type="text"  class="input-large controller-text" placeholder="请输入查询城市"/>
        输入关键字查询：<input type="text" id="keyword" name="keyword" class="input-large controller-text" placeholder="请输入关键字：(选定后搜索)" onfocus='this.value=""'/>
    </p>
</div>
<script type="text/javascript">
    var windowsArr = [];
    var marker = [];
    var city = $("#city").val() ;
    var map = new AMap.Map("mapContainer", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13,//地图显示的缩放级别
        keyboardEnable: false
    });
    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
        var autoOptions = {
            city: city, //城市，默认全国
            input: "keyword"//使用联想输入的input的id
        };
        autocomplete= new AMap.Autocomplete(autoOptions);
        var placeSearch = new AMap.PlaceSearch({
            city:city,
            map:map
        })
        AMap.event.addListener(autocomplete, "select", function(e){
            //TODO 针对选中的poi实现自己的功能
            placeSearch.search(e.poi.name)
        });
    });
</script>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>