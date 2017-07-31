<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>实时路况图层</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="button-group">
    <input type="button" class="button" id="control" value="显示/隐藏实时路况"/>
</div>
<script>
    var map = new AMap.Map('container', {
        resizeEnable: true,
        center: [116.397428, 39.90923],
        zoom: 13
    });
    //实时路况图层
    var trafficLayer = new AMap.TileLayer.Traffic({
        zIndex: 10
    });
    trafficLayer.setMap(map);

    var isVisible = true;
    AMap.event.addDomListener(document.getElementById('control'), 'click', function() {
        if (isVisible) {
            trafficLayer.hide();
            isVisible = false;
        } else {
            trafficLayer.show();
            isVisible = true;
        }
    }, false);
</script>
</body>
</html>