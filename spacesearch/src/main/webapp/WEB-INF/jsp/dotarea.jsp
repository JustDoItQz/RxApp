<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>点是否在多边形内</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="button-group">
    <input id="calc" type="button" class="button" value="计算点是否在多边形内"/>
</div>
<script type="text/javascript">
    //初始化地图对象，加载地图
    var map = new AMap.Map("container", {
        resizeEnable: true,
        zoom: 13
    });
    var myMarker = new AMap.Marker({
        map: map,
        position: [116.566298, 40.014179]
    });
    var path = [
        [116.169465,39.932670],
        [116.160260,39.924492],
        [116.186138,39.879817],
        [116.150625,39.710019],
        [116.183198,39.709920],
        [116.226950,39.777616],
        [116.421078,39.810771],
        [116.442621,39.799892],
        [116.463478,39.790066],
        [116.588276,39.809551],
        [116.536091,39.808859],
        [116.573856,39.839643],
        [116.706380,39.916740],
        [116.657285,39.934545],
        [116.600293,39.937770],
        [116.540039,39.937968],
        [116.514805,39.982375],
        [116.499935,40.013710],
        [116.546520,40.030443],
        [116.687668,40.129961],
        [116.539697,40.080659],
        [116.503390,40.058474],
        [116.468800,40.052578]
    ];
    var polygon = new AMap.Polygon({
        map: map,
        path: path
    });
    map.setFitView();
    AMap.event.addDomListener(document.getElementById('calc'), 'click', function() {
        alert('点是否在多边形内：' + polygon.contains(myMarker.getPosition()));
    });
</script>
</body>
</html>