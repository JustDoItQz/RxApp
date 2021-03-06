<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>叠加云数据图层</title>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css"/>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7"></script>
    <style type="text/css">
        .title{
            font: 13px 'Microsoft Yahei';
            color: #09f
        }
    </style>
</head>
<body style='font-size:12px'>
<div id="mapContainer"></div>
<script type="text/javascript">
    //初始化地图对象，加载地图
    var map = new AMap.Map("mapContainer", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 12 //地图显示的缩放级别
    });
    //叠加云数据图层
    function addCloudLayer() {
        //加载云图层插件
        map.plugin('AMap.CloudDataLayer', function() {
            var layerOptions = {
                query: {keywords: '公园'},
                clickable: true
            };
            var cloudDataLayer = new AMap.CloudDataLayer('532b9b3ee4b08ebff7d535b4', layerOptions); //实例化云图层类
            cloudDataLayer.setMap(map); //叠加云图层到地图

            AMap.event.addListener(cloudDataLayer, 'click', function(result) {
                var clouddata = result.data;
                var photo=[];
                if(clouddata._image[0]){//如果有上传的图片
                    photo=['<img width=240 height=100 src="'+clouddata._image[0]._preurl+'"><br>'];
                }
                var infoWindow = new AMap.InfoWindow({
                    content: "<font class='title'>" + clouddata._name + "</font><hr/>"+photo.join("")+"地址：" + clouddata._address + "<br />" + "创建时间：" + clouddata._createtime + "<br />" + "更新时间：" + clouddata._updatetime,
                    size: new AMap.Size(0, 0),
                    autoMove: true,
                    offset: new AMap.Pixel(0, -25)
                });

                infoWindow.open(map, clouddata._location);
            });
        });
    }
    addCloudLayer();

</script>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>