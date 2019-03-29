/**
 * @author charles
 * @function 移动到本级区域
 */
function moveToCenter() {
    var view = map.getView();
    // 设置地图中心为芒市的坐标，即可让地图移动到芒市
    view.setCenter([98.5847, 24.4365]);
    view.setZoom(14);
    map.render();
}