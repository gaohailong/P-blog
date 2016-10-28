/**
 * Created by gaohailong on 2016/10/28.
 */
function getTitleNet(id) {
    //将视图清空
    $("#d_body").empty();
    $("#t-page").empty();

    //设置一些默认值
    var pageSize = 10;
    var pageNumber = id;
    if (pageNumber == undefined) {
        pageNumber = 1;
    }

    //ajax操作
    var reqParams = {'page': pageNumber, 'pageNumber': pageSize};
    $.ajax({
        type: "GET",
        data: reqParams,
        url: "/title/findTitle",
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
                //文章数据项的添加((index+1)*pageNo)
                $("#d_body").append(
                    "<tr><td>" + ((pageNo - 1) * pageSize + index + 1) + "</td><td>" + value.articlename + "</td><td>" + value.readnum + "</td><td>" +
                    ormatDate(value.date) + "</td><td>" + value.isshow + "</td><td>"
                    + value.category + "</td><td><a href='#' onclick='javascript:updateTitleByIdOfSelect(" + value.id + ")'><img src='pblog/web/images/update.png' style='width: 20px;height: 20px;'>" +
                    "</a><a href='#' onclick='javascript:deleteTitleById(" + value.id + ")'><img src='pblog/web/images/delete.png' style='width: 20px;height: 20px;margin-left: 5px;'></a></td></tr>"
                );
            });
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}