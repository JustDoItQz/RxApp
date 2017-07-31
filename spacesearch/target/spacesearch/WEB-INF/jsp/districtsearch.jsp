<%@page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>全国城市下拉列表</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css?v=1.0"/>
    <%@include file="head.jsp"%>
    <script type="text/javascript" src="<%=path%>/ui/jquery/jquery.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=fb9c869e82d384beeb47c1b970552ae7&plugin=AMap.DistrictSearch"></script>
    <style type="text/css">
        #tip {
            background-color: #fff;
            padding:0 10px;
            border: 1px solid silver;
            box-shadow: 3px 4px 3px 0px silver;
            position: absolute;
            font-size: 12px;
            right: 10px;
            top: 5px;
            border-radius: 3px;
            line-height: 36px;
        }
    </style>
</head>
<body>
<div id="mapContainer"></div>
<div id="tip">
    省：<select id='province' style="width:100px" onchange='search(this)'></select>
    市：<select id='city' style="width:100px" onchange='search(this)'></select>
    区：<select id='district' style="width:100px" onchange='search(this)'></select>
    街道：<select id='street' style="width:100px" onchange= 'setCenter(this)'></select>
</div>
<script type="text/javascript">
    var map, district, polygons = [], citycode;
    var citySelect = document.getElementById('city');
    var districtSelect = document.getElementById('district');
    var areaSelect = document.getElementById('street');

    map = new AMap.Map('mapContainer', {
        resizeEnable: true,
        center: [116.30946, 39.937629],
        zoom: 3
    });
    //行政区划查询
    var opts = {
        subdistrict: 1,   //返回下一级行政区
        level: 'city',
        showbiz:false  //查询行政级别为 市
    };
    district = new AMap.DistrictSearch(opts);//注意：需要使用插件同步下发功能才能这样直接使用
    district.search('中国', function(status, result) {
        if(status=='complete'){
            getData(result.districtList[0]);
        }
    });
    function getData(data) {
        var bounds = data.boundaries;
        if (bounds) {
            for (var i = 0, l = bounds.length; i < l; i++) {
                var polygon = new AMap.Polygon({
                    map: map,
                    strokeWeight: 1,
                    strokeColor: '#CC66CC',
                    fillColor: '#CCF3FF',
                    fillOpacity: 0.5,
                    path: bounds[i]
                });
                polygons.push(polygon);
            }
            map.setFitView();//地图自适应
        }

        var subList = data.districtList;
        var level = data.level;

        //清空下一级别的下拉列表
        if (level === 'province') {
            nextLevel = 'city';
            citySelect.innerHTML = '';
            districtSelect.innerHTML = '';
            areaSelect.innerHTML = '';
        } else if (level === 'city') {
            nextLevel = 'district';
            districtSelect.innerHTML = '';
            areaSelect.innerHTML = '';
        } else if (level === 'district') {
            nextLevel = 'street';
            areaSelect.innerHTML = '';
        }
        if (subList) {
            var contentSub =new Option('--请选择--');
            for (var i = 0, l = subList.length; i < l; i++) {
                var name = subList[i].name;
                var levelSub = subList[i].level;
                var cityCode = subList[i].citycode;
                if(i==0){
                    document.querySelector('#' + levelSub).add(contentSub);
                }
                contentSub=new Option(name);
                contentSub.setAttribute("value", levelSub);
                contentSub.center = subList[i].center;
                contentSub.adcode = subList[i].adcode;
                document.querySelector('#' + levelSub).add(contentSub);
            }
        }

    }
    function search(obj) {
        //清除地图上所有覆盖物
        for (var i = 0, l = polygons.length; i < l; i++) {
            polygons[i].setMap(null);
        }
        var option = obj[obj.options.selectedIndex];
        var keyword = option.text; //关键字
        var adcode = option.adcode;
        district.setLevel(option.value); //行政区级别
        district.setExtensions('all');
        //行政区查询
        //按照adcode进行查询可以保证数据返回的唯一性
        district.search(adcode, function(status, result) {
            if(status === 'complete'){
                getData(result.districtList[0]);
            }
        });
    }
    function setCenter(obj){
        map.setCenter(obj[obj.options.selectedIndex].center)
    }


</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>

</body>
</html>