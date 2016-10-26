/**
 * Created by gaohailong on 2016/9/27.
 */
/*window.onload = function () {
    alert("ddd");
    $("#p_default").css("display", "block");
}*/
//获取文章的操作
function allTitle() {
    hideDiv();
    hidePChart();
    getTitleNet();
    $("#d_title").css("display", "block");
}

//修改或添加文章后选择发送到后台的方式
function selectOpForUpdateAndAdd() {
    var name = $("#b_t_sub").attr("value");
    if (name == 0) {
        addTitleAft();
    } else if (name == 1) {
        // 修改文章的后期操作
        updateTitleById();
    }
}

//添加文章前期的操作
function addTitlePre() {
    hideDiv();
    hidePChart();
    getCategory();
    hideAddTitleContent();
    $("#b_t_sub").attr("value", "0");
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

//修改文章
function updateTitleById() {
    var id = $("#b_update").val();
    var head = $("#inputEmail3").val();
    var content = getContentByUeditor();
    var titleCate = $("#s_category :selected").text();
    var titleDisplay = $("#d_YN :selected").text();
    var sendParams = {
        "id": id,
        "head": head,
        "content": content,
        "titleCate": titleCate,
        "titleDisplay": titleDisplay,
    };
    $.ajax({
        type: "POST",
        url: "/title/updateById",
        data: sendParams,
        dataType: "JSON",
        success: function (data) {
            alert(data);
        },
        error: function (jqXHR) {
            alert("发生错误!" + jqXHR);
        }
    });
}

//获取所有分类操作
function allCategory() {
    hideDiv();
    hidePChart();
    getCategoryForCate();
    $("#d_category").css("display", "block");
}

//添加分类操作
function addCategory() {
    hideDiv();
    hidePChart();
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
    // $("#p_default").css("display", "none");
}

//隐藏个人管理图表
function hidePChart() {
    $("#p_default").css("display", "none");
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
function updateTitleByIdOfSelect(id) {
    var sendParams = {'id': id};
    //查询文章显示在界面上
    $.ajax({
        type: "GET",
        url: "/title/selectById",
        data: sendParams,
        dataType: "JSON",
        success: function (data) {
            // alert(data.articlename + "--" + data.articlecontent + "--" + data.category + "--" + data.isshow + "--");
            changeUIForTitle(data.id, data.articlename, data.articlecontent, data.category, data.isshow);
        },
        error: function (jsXHR) {
            alert("发生错误" + jsXHR);
        }
    });
}

//修改改变UI
function changeUIForTitle(id, head, content, cate, display) {
    hideDiv();
    hidePChart();
    $("#b_update").val(id);
    $("#b_t_sub").attr("value", "1");
    $("#inputEmail3").val(head);
    getCategory();
    $("#s_category option").each(function () {
        if ($(this).text() == cate) {
            $(this).attr("selected", "selected");
        }
    });
    $("#d_YN option").each(function () {
        if ($(this).text() == display) {
            $(this).attr("selected", "selected");
        }
    });
    addContentForEditorDoUpdate(content);
    // $("#s_category option[value=cate]").attr("selected","true");
    // alert("head" + head + "content" + content + "cate" + cate + "display" + display);
    // $("#i_title").remove();
    // $("#u_title").css("display", "block");
    // getCategoryForUpdate();
    // $("#u_head").val(head);
    //TODO 考虑设置多页结合(操作添加文章页面)
    // $("#u_container").html(content);
    // $("#u_category option[text=cate]").attr("selected", true);
    // $("#u_YN option[text=display]").attr("selected", true);
}

//为编辑器添加文本
function addContentForEditorDoUpdate(content) {
    editor.ready(function () {
        //这里写要编辑的文本
        editor.setContent(content);
    });
    $("#i_title").css("display", "block");
}

//隐藏文章内容
function hideAddTitleContent() {
    $("#inputEmail3").val("");
    addContentForEditorDoAdd();
}
//添加内容给editor
function addContentForEditorDoAdd() {
    editor.ready(function () {
        //这里写要编辑的文本
        editor.setContent("");
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

