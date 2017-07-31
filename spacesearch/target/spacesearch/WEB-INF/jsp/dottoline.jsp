<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>点到线的距离</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="button-group">
    <input id="calc" type="button" class="button" value="计算点到线距离"/>
</div>
<script type="text/javascript">
    //初始化地图对象，加载地图
    var map = new AMap.Map("container", {
        resizeEnable: true,
        zoom: 13
    });
    new AMap.Marker({
        map: map,
        position: [116.368904, 39.923423]
    });
    var path = [
        [116.368904, 39.913423],
        [116.382122, 39.901176],
        [116.387271, 39.912501],
        [116.398258, 39.904600]
    ]
    var polyline = new AMap.Polyline({
        map: map,
        path: path
    });
    map.setFitView();
    var lnglat = new AMap.LngLat(116.368904, 39.923423);
    AMap.event.addDomListener(document.getElementById('calc'), 'click', function() {
        alert('点到线的距离为：' + lnglat.distance(path) + '米');
    });
</script>
</body>
</html>