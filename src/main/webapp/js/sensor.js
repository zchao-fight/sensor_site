var sensor = {};

sensor.get = function (url, callback, errorCallback) {
    var loading = sensor.loading();
    try {
        $.ajax({
            url: url,
            type: "get",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            success: function (data) {
                layer.close(loading);
                if (data.code === 1) {
                    callback(data);
                } else {
                    layer.msg(data.msg, {time: 3500, icon: 5, shade: [0.2, '#000'], shadeClose: true});
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.close(loading);
                try {
                    console.log("提示", textStatus + errorThrown);
                    if (errorCallback) {
                        errorCallback();
                    }
                } catch (e) {
                    console.log(e);
                }
            }
        });
    } catch (e) {
        layer.close(loading);
    }
};


sensor.post = function (url, params, callback, errorCallback) {
    var loading = sensor.loading();
    try {
        $.ajax({
            url: url,
            type: "post",
            data: params,
            dataType: 'json',
            contentType: "application/x-www-form-urlencoded",
            success: function (data) {
                layer.close(loading);
                if (data.code === 1) {
                    callback(data);
                } else {
                    layer.msg(data.msg, {time: 3500, icon: 5, shade: [0.2, '#000'], shadeClose: true});
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.close(loading);
                try {
                    console.log("提示", textStatus + errorThrown);
                    if (errorCallback) {
                        errorCallback();
                    }
                } catch (e) {
                    console.log(e);
                }
            }
        });
    } catch (e) {
        layer.close(loading);
    }
};

sensor.ajax = function (url, type, params, callback, errorCallback) {
    var loading = sensor.loading();

    try {
        $.ajax({
            type: type,
            data: params ? JSON.stringify(params) : params,
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            url: url,
            success: function (data) {
                layer.close(loading);
                if (data.code === 1) {
                    callback(data);
                } else {
                    // 弹出框必须加parent
                   layer.msg(data.msg, {time: 3500, icon: 5, shade: [0.2, '#000'], shadeClose: true});
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.close(loading);
                try {
                    console.log("提示", textStatus + errorThrown);
                    if (errorCallback) {
                        errorCallback();
                    }
                } catch (e) {
                    console.log(e);
                }
            }
        });
    } catch (e) {
        layer.close(loading);
    }
};

sensor.loading = function () {
    return layer.load(1, {
        shade: [0.2,'#000'] //0.1透明度的白色背景
    });
};

sensor.succMsg = function(msg){
    layer.msg(msg, {time: 2300, icon:6, shade: [0.2, '#000'],shadeClose :true});
};

sensor.errorMsg = function(msg){
    layer.msg(msg, {time: 3000, icon:5, shade: [0.2, '#000'],shadeClose :true});
};