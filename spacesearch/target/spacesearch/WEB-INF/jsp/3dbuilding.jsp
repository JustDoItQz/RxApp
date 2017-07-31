<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>3D楼块图层</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div id="tip"></div>
<script>
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [121.498586, 31.239637],
        zoom: 17
    });
    if (document.createElement('canvas') && document.createElement('canvas').getContext && document.createElement('canvas').getContext('2d')) {
        // 实例化3D楼块图层
        var buildings = new AMap.Buildings();
        // 在map中添加3D楼块图层
        buildings.setMap(map);
    } else {
        document.getElementById('tip').innerHTML = "对不起，运行该示例需要浏览器支持HTML5！";
    }
</script>
</body>
</html>