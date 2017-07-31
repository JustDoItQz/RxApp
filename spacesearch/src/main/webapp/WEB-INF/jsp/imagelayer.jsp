<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>图片图层</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<script>
    var imageLayer = new AMap.ImageLayer({
        url: 'http://amappc.cn-hangzhou.oss-pub.aliyun-inc.com/lbs/static/img/dongwuyuan.jpg',
        bounds: new AMap.Bounds(
            [116.327911, 39.939229],
            [116.342659, 39.946275]
        ),
        zooms: [15, 18]
    });
    var map = new AMap.Map('container', {
        resizeEnable: true,
        center: [116.33719, 39.942384],
        zoom: 15,
        layers: [
            new AMap.TileLayer(),
            imageLayer
        ]
    });
</script>
</body>
</html>