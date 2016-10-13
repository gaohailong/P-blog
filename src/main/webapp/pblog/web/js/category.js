/**
 * Created by gaohailong on 2016/10/10.
 */
//获取所有分类
function getCategoryForCate(id) {
    $("#c_body").empty();
    $("#c-page").empty();
    //设置一些默认值
    var pageSize = 10;
    var pageNumber = id;
    if (pageNumber == undefined) {
        pageNumber = 1;
    }
    var reqParams = {'page': pageNumber, 'pageNumber': pageSize};
    $.ajax({
        type: "GET",
        data: reqParams,
        url: "/category/findForCategory",
        dataType: "JSON",
        success: function (data) {
            var datalist = data.dataList;
            var pageNo = data.pageNo;
            var pageSize = data.pageSize;
            var total = data.total;
            var pages = data.pages;
            //分页的添加
            for (var i = 0; i < pages; i++) {
                $("#c-page").append(
                    "<li><a href='javascript:void(0)' onclick='getCategoryForCate(" + (i + 1) + ")'>" + (i + 1) + "</a></li>"
                );
            }

            $(datalist).each(function (index, value) {
                $("#c_body").append(
                    "<tr><td>" + ((pageNo - 1) * pageSize + index+1) + "</td>" +
                    "<td>" + value.category + "</td>" +
                    "<td><a href='#' ><img src='pblog/web/images/update.png'style='width: 20px;height: 20px;'></a>" +
                    "<a href='#' onclick='javascript:deleteCateById(" + value.id + ")'><img src='pblog/web/images/delete.png'style='width: 20px;height: 20px;margin-left: 5px;'>" +
                    "</a></td></tr>"
                );
            });
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}

//添加分类
function addCategoryForCate() {
    var headName = $("#c_title").val();
    var sendParams = {'headName': headName};
    $.ajax({
        type: "POST",
        data: sendParams,
        url: "/category/addCategory",
        dataType: "JSON",
        success: function (data) {
            alert(data);
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}

//删除分类
function deleteCateById(id) {
    if(confirm("确定要删除吗？")){
        var id = id;
        var sendParams = {
            'id': id
        };
        $.ajax({
            type: "GET",
            data: sendParams,
            url: "/category/deleteCate",
            dataType: "JSON",
            success: function (data) {
                alert(data);
            },
            error: function (jqXHR) {
                alert("发生错误" + jqXHR.status);
            }
        });
    }
}