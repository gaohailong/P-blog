/**
 * Created by gaohailong on 2016/9/27.
 */

//获取文章的操作
function allTitle() {
    hideDiv();
    getTitleNet();
    $("#d_title").css("display", "block");
}

//添加文章的操作
function addTitle() {
    hideDiv();
    $("#i_title").css("display", "block");
}

//获取所有分类操作
function allCategory() {
    hideDiv();
    $("#d_category").css("display", "block");
}

//添加分类操作
function addCategory() {
    hideDiv();
    $("#i_category").css("display", "block");
}

//隐藏所有div的操作
function hideDiv() {
    $("#d_title").css("display", "none");
    $("#i_title").css("display", "none");
    $("#d_category").css("display", "none");
    $("#i_category").css("display", "none");
}

//获取所有文章的网络操作
function getTitleNet(id) {
    //将视图清空
    $("tbody").empty();
    $("#t-page").empty();

    //设置一些默认值
    var pageSize = 2;
    var pageNumber = id;
    if (pageNumber == undefined) {
        pageNumber = 1;
    }

    //ajax操作
    var reqParams = {'page': pageNumber, 'pageNumber': pageSize};
    $.ajax({
        type: "GET",
        url: "/title/findTitle",
        data: reqParams,
        dataType: "JSON",
        success: function (data) {
            var dataList = data.dataList;
            var pageNo = data.pageNo;
            var pageSize = data.pageSize;
            var total = data.total;
            var pages = data.pages;

            //分页的添加
            for (var i = 0; i < pages; i++) {
                $("#t-page").append(
                    "<li><a href='javascript:void(0)' onclick='getTitleNet(" + (i + 1) + ")'>" + (i + 1) + "</a></li>"
                );
            }

            $(dataList).each(function (index, value) {
                //文章数据项的添加
                $("tbody").append(
                    "<tr><td>" + value.id + "</td><td>" + value.articlename + "</td><td>" + value.readnum + "</td><td>" +
                    getLocalTime(value.date) + "</td><td>" + value.isshow + "</td><td>"
                    + value.category + "</td><td>Otto</td><td><a href='#'><img src='pblog/web/images/update.png' style='width: 20px;height: 20px;'>" +
                    "</a><a href='#'><img src='pblog/web/images/delete.png' style='width: 20px;height: 20px;margin-left: 5px;'></a></td></tr>"
                );
            });
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}

//时间转换工具
function getLocalTime(nS) {
    return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/, ' ');
}
