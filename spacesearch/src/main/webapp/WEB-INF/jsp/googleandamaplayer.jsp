<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>自定义栅格底图</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="button-group">
    <input type="button" class="button" value="叠加google地图" onclick="addGoogleLayer()"/>
    <input type="button" class="button" value="移除google地图" onclick="googleLayer.setMap()"/>
</div>
<script>
    var map = new AMap.Map('container', {
        resizeEnable: true
    });
    var googleLayer = null;
    // 添加Google图层
    function addGoogleLayer() {
        googleLayer = new AMap.TileLayer({
            // 图块取图地址
            tileUrl: 'http://mt{1,2,3,0}.google.cn/vt/lyrs=m@142&hl=zh-CN&gl=cn&x=[x]&y=[y]&z=[z]&s=Galil',
            zIndex:100
        });
        googleLayer.setMap(map);
    }
</script>
</body>
</html>