var position;
var map;

$(function () {
  buildMap()
});

function buildMap() {
  map = new AMap.Map('container', {
    zoom: 13,//级别
    center: [1, 1],//中心点坐标
    viewMode: '3D'//使用3D视图
  });

  //定位
  map.plugin('AMap.Geolocation', function () {
    geolocation = new AMap.Geolocation({
      enableHighAccuracy: true,//是否使用高精度定位，默认:true
      timeout: 10000,          //超过10秒后停止定位，默认：无穷大
      maximumAge: 0,           //定位结果缓存0毫秒，默认：0
      convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
      showButton: true,        //显示定位按钮，默认：true
      buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
      buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
      showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
      showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
      panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
      zoomToAccuracy: true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
    });
    map.addControl(geolocation);
    geolocation.getCurrentPosition();
    AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
    AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
  });

  function onComplete(GeolocationResult) {
    console.log(GeolocationResult);
    addMarker();//添加地图显示标记
  }
}

//添加点标记物
function addMarker() {
  map.clearMap();  // 清除地图覆盖物
  var center = map.getCenter();
  var markers = [{
    icon: 'https://webapi.amap.com/theme/v1.3/markers/n/mark_r1.png',
    position: [center.lng, center.lat]
  }, {
    icon: 'https://webapi.amap.com/theme/v1.3/markers/n/mark_r2.png',
    position: [116.368904, 39.913423]
  }, {
    icon: 'https://webapi.amap.com/theme/v1.3/markers/n/mark_r3.png',
    position: [116.305467, 39.807761]
  }];
  // 添加一些分布不均的点到地图上,地图上添加三个点标记，作为参照
  markers.forEach(function (marker) {
    new AMap.Marker({
      map: map,
      icon: marker.icon,
      position: [marker.position[0], marker.position[1]],
      offset: new AMap.Pixel(-12, -36)
    });
  });
  var centerText = '当前中心点坐标：' + center.getLng() + ',' + center.getLat();
  console.log(centerText)
}