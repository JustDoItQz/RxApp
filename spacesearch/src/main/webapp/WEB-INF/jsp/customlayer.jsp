<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>自定义图层</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<script type="text/javascript">
    var map, provinces, redPoint, bluePoint, canvas, colorFlag = 0,	started;
    create(); //自定义图层
    function create() {
        map = new AMap.Map('container', {
            center: [116.306206, 39.975468],
            zoom:3
        });
        map.plugin(['AMap.CustomLayer', 'AMap.DistrictSearch'], function() {
            var search = new AMap.DistrictSearch();
            search.search('中国', function(status, data) {
                if (status === 'complete') {
                    provinces = data['districtList'][0]['districtList']
                    for (var i = 0; i < provinces.length; i += 1) {
                        provinces[i].radious = Math.max(2, Math.floor(Math.random() * 10));
                    }
                    redPoint = buildPoint('red');
                    bluePoint = buildPoint('blue');
                    canvas = document.createElement('canvas');
                    canvas.width = map.getSize().width;
                    canvas.height = map.getSize().height;
                    var cus = new AMap.CustomLayer(canvas, {
                        zooms: [3, 8],
                        zIndex: 12
                    });
                    cus.render = onRender;
                    cus.setMap(map);
                }
            });
        });
    }
    function buildPoint(color) {
        var c = document.createElement("canvas");
        c.width = c.height = 40;
        var ctx = c.getContext("2d");
        var grd = ctx.createRadialGradient(20, 20, 0, 20, 20, 20);
        grd.addColorStop(0, color);
        grd.addColorStop(1, "white");
        ctx.fillStyle = grd;
        ctx.beginPath();
        ctx.arc(20, 20, 20, 0, 2 * Math.PI);
        ctx.fill();
        return c;
    }
    function onRender() {
        for (var i = 0; i < provinces.length; i += 1) {
            provinces[i].containerPos = map.lngLatToContainer(provinces[i].center);
        }
        draw();
        if(!started){
            autoSize();
            started = true;
        }
    }
    function autoSize () {
        draw();
        setTimeout(autoSize, 250);
    }
    function draw() {
        var point = colorFlag ? bluePoint : redPoint;
        var context = canvas.getContext('2d');
        context.clearRect(0, 0, canvas.width, canvas.height)
        for (var i = 0; i < provinces.length; i += 1) {
            var province = provinces[i];
            var radious = province.radious;
            context.drawImage(point,
                province.containerPos.x - radious,
                province.containerPos.y - radious,
                radious * 2,
                radious * 2
            );
            province.radious = (radious + 1) % 10;
        }
        colorFlag = (colorFlag + 1) % 2;
    }
</script>
</body>
</html>