<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>两点间距离</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
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
        button#search {
            width: 100px;
            height: 28px;
            margin-left: 20px;
            margin-right: 10px;
        }

    </style>

</head>
<body>
<div id="container" tabindex="0"></div>
<div id="tip">
    <p>
        请输入起始地址:<input id="start" type="text"  class="input-large controller-text" placeholder="请输入起始地址"/>
        请输入结束地址：<input type="text" id="end"  class="input-large controller-text" placeholder="请输入结束地址"/>
        查询：<button id="search" value="查询" onclick="click">查询</button>
        两点间的距离为：<input type="text" id="distance"/>
    </p>


</div>

<script type="text/javascript">

    var startLocation =new Array() ;
    var endLocation = new Array() ;
    var distanceMi = null ;
    var marker = null ;
    var distance = $("#distance").val() ;
    var start = $("#start").val() ;
    var end = $("#end").val() ;

    var geocoder =null ;
    var marker =null ;

    //初始化地图对象，加载地图
    var map = new AMap.Map("container", {
        resizeEnable: true,
        zoom: 13
    });

    AMap.plugin('AMap.Geocoder',function(){
        geocoder = new AMap.Geocoder({
            city: "010"//城市，默认：“全国”
        });
    });


    var click = $("#search").click(function () {
        searchDistance() ;

    }) ;

    function searchDistance() {
         start = $("#start").val() ;
         end = $("#end").val() ;
        searchLocation(start,end) ;
    }

    function searchLocation(start,end) {
        if (map!=null){
            map.clearMap() ;
        }
        if (marker!=null){
            marker.setMap(null) ;
        }

        geocoder.getLocation(start,function(status,result){
            if(status=='complete'&&result.geocodes.length){
                var geo = result.geocodes ;
                var lngX = geo[0].location.getLng() ;
                var latY = geo[0].location.getLat() ;
                var startPosition = [lngX,latY] ;
                startLocation.push(startPosition)
                marker =  new AMap.Marker({
                    map: map,
                    position: [startPosition]
                });

            }else{
                alert("起始地址获取位置失败") ;
                return ;
            }
        }) ;
        geocoder.getLocation(end,function(status,result){
            if(status=='complete'&&result.geocodes.length){

                var geo = result.geocodes ;
                var lngX = geo[0].location.getLng() ;
                var latY = geo[0].location.getLat() ;
                var endPosition = [lngX,latY] ;
                endLocation.push(endPosition)
                marker = new AMap.Marker({
                    map: map,
                    position: [endPosition]
                });
            }else{
                alert("结束地址获取位置失败") ;
                return ;
            }
        }) ;

        map.setFitView();
        var lnglat = new AMap.LngLat(startLocation);
        AMap.event.addDomListener(search, 'click', function() {

            distanceMi = lnglat.distance([endLocation]) ;
            distance.val(distanceMi);
            alert('两点间距离为：' + distance + '米');
        });

    }


</script>
</body>
</html>