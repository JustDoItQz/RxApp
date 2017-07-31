<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>点聚合</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7&plugin=AMap.MarkerClusterer"></script>
    <%@include file="head.jsp"%>
    <script type="text/javascript" src="<%=path%>/ui/jquery/jquery.js"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="button-group">
    <input type="button" class="button" value="默认样式" id="add0" onclick = 'addCluster(0)'/>
    <input type="button" class="button" value="自定义图标" id="add1" onclick = 'addCluster(1)'/>
    <input type="button" class="button" value="完全自定义" id="add2" onclick = 'addCluster(2)'/>
</div>
<script src="http://a.amap.com/jsapi_demos/static/china.js"></script>
<script>
    var cluster, markers = [];
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center:[105,34],
        zoom: 4
    });
    for(var i=0;i<points.length;i+=1){
        markers.push(new AMap.Marker({
            position:points[i]['lnglat'],
            content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>',
            offset: new AMap.Pixel(-15,-15)
        }))
    }
    var count  = markers.length;
    var _renderCluserMarker = function (context) {
        var factor = Math.pow(context.count/count,1/18)
        var div = document.createElement('div');
        var Hue = 180 - factor* 180;
        var bgColor = 'hsla('+Hue+',100%,50%,0.7)';
        var fontColor = 'hsla('+Hue+',100%,20%,1)';
        var borderColor = 'hsla('+Hue+',100%,40%,1)';
        var shadowColor = 'hsla('+Hue+',100%,50%,1)';
        div.style.backgroundColor = bgColor
        var size = Math.round(30 + Math.pow(context.count/count,1/5) * 20);
        div.style.width = div.style.height = size+'px';
        div.style.border = 'solid 1px '+ borderColor;
        div.style.borderRadius = size/2 + 'px';
        div.style.boxShadow = '0 0 1px '+ shadowColor;
        div.innerHTML = context.count;
        div.style.lineHeight = size+'px';
        div.style.color = fontColor;
        div.style.fontSize = '14px';
        div.style.textAlign = 'center';
        context.marker.setOffset(new AMap.Pixel(-size/2,-size/2));
        context.marker.setContent(div)
    }
    addCluster(2);

    function addCluster(tag) {
        if (cluster) {
            cluster.setMap(null);
        }
        if (tag == 2) {//完全自定义
            cluster = new AMap.MarkerClusterer(map,markers,{
                gridSize:80,
                renderCluserMarker:_renderCluserMarker
            });
        } else if (tag == 1) {//自定义图标
            var sts = [{
                url: "http://a.amap.com/jsapi_demos/static/images/blue.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/green.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/orange.png",
                size: new AMap.Size(36, 36),
                offset: new AMap.Pixel(-18, -18)
            },{
                url: "http://a.amap.com/jsapi_demos/static/images/red.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            },{
                url: "http://a.amap.com/jsapi_demos/static/images/darkRed.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            }];
            cluster = new AMap.MarkerClusterer(map, markers, {
                styles: sts,
                gridSize:80
            });
        } else {//默认样式
            cluster = new AMap.MarkerClusterer(map, markers,{gridSize:80});
        }
    }
</script>
</body>
</html>