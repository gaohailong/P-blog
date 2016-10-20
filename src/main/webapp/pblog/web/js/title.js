/**
 * Created by gaohailong on 2016/9/27.
 */

//获取文章的操作
function allTitle() {
    hideDiv();
    getTitleNet();
    $("#d_title").css("display", "block");
}

//添加文章前期的操作
function addTitlePre() {
    hideDiv();
    getCategory();
    $("#i_title").css("display", "block");
}

//添加文章后期的操作
function addTitleAft() {
    var titleName = $("#inputEmail3").val();
    var titleContent = getContentByUeditor();
    var titleCate = $("#s_category :selected").text();
    var titleDisplay = $("#d_YN :selected").text();
    var sendParams = {
        'titleName': titleName,
        'titleContent': titleContent,
        'titleCate': titleCate,
        'titleDisplay': titleDisplay
    };
    $.ajax({
        type: "POST",
        data: sendParams,
        url: "/title/addTitle",
        dataType: "JSON",
        success: function (data) {
            alert(data);
        },
        error: function (jqXHR) {
            alert("发生错误啦" + jqXHR.status);
        }
    });
}

//删除文章
function deleteTitleById(id) {
    if (confirm("确定要删除吗？")) {
        var id = id;
        var sendParams = {
            'id': id
        };
        $.ajax({
            type: "GET",
            data: sendParams,
            url: "/title/deleteTitle",
            dataType: "JSON",
            success: function (data) {
                alert(data);
            },
            error: function (jqXHR) {
                alert("发生错误啦" + jqXHR.status);
            }
        });
    }
}

//获取所有分类操作
function allCategory() {
    hideDiv();
    getCategoryForCate();
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
    $("#u_title").css("display", "none");
    $("#u_c_category").css("display", "none");
}

//获取所有文章的网络操作
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
                    + value.category + "</td><td><a href='#' onclick='javascript:updateTitleById(" + value.id + ")'><img src='pblog/web/images/update.png' style='width: 20px;height: 20px;'>" +
                    "</a><a href='#' onclick='javascript:deleteTitleById(" + value.id + ")'><img src='pblog/web/images/delete.png' style='width: 20px;height: 20px;margin-left: 5px;'></a></td></tr>"
                );
            });
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}

//获取所有分类
function getCategory() {
    $("#s_category").empty();
    $.ajax({
        type: "GET",
        url: "/category/findAllCategory",
        dataType: "JSON",
        success: function (data) {
            $(data).each(function (index, value) {
                $("#s_category").append(
                    "<option id='" + value.id + "'>" + value.category + "</option>"
                );
            });
        },
        error: function (jqXHR) {
            alert("发生错误" + jqXHR.status);
        }
    });
}

//修改文章的查询文章
//TODO
function updateTitleById(id) {
    var sendParams = {'id': id};
    //查询文章显示在界面上
    $.ajax({
        type: "GET",
        url: "/title/selectById",
        data: sendParams,
        dataType: "JSON",
        success: function (data) {
            alert(data.articlename + "--" + data.articlecontent + "--" + data.category + "--" + data.isshow + "--");
            changeUI(data.articlename, data.articlecontent, data.category, data.isshow);
        },
        error: function (jsXHR) {
            alert("发生错误" + jsXHR);
        }
    });
}

//修改改变UI
function changeUI(head, content, cate, display) {
    hideDiv();
    // $("#i_title").remove();
    $("#u_title").css("display", "block");
    // getCategoryForUpdate();
    // $("#u_head").val(head);
    //TODO 考虑设置多页结合(操作添加文章页面)
    // $("#u_container").html(content);
    // $("#u_category option[text=cate]").attr("selected", true);
    // $("#u_YN option[text=display]").attr("selected", true);
}

function getCategoryForUpdate() {
    $("#u_category").empty();
    $.ajax({
        type: "GET",
        url: "/category/findAllCategory",
        dataType: "JSON",
        success: function (data) {
            $(data).each(function (index, value) {
                $("#u_category").append(
                    "<option id='" + value.id + "'>" + value.category + "</option>"
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

function ormatDate(dateNum) {
    var date = new Date(dateNum);
    return date.getFullYear() + "-" + fixZero(date.getMonth() + 1, 2) + "-" + fixZero(date.getDate(), 2) + " " + fixZero(date.getHours(), 2) + ":" + fixZero(date.getMinutes(), 2) + ":" + fixZero(date.getSeconds(), 2);
    function fixZero(num, length) {
        var str = "" + num;
        var len = str.length;
        var s = "";
        for (var i = length; i-- > len;) {
            s += "0";
        }
        return s + str;
    }
}

