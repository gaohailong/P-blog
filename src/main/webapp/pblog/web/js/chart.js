/**
 * Created by Administrator on 2016/10/25.
 */
function articleGraph() {
    $.ajax({
        type: "GET",
        url: "/admin/selectAllTitleForChart",
        dataType: "JSON",
        success: function (data) {
            setTitleStatistics(data);
        },
        error: function (jqXHR) {
            alert("发生错误！" + jqXHR);
        }
    });
}
//每个月发表的文章总数
function setTitleStatistics(data) {
    var adminTitleCount = new Array();
    var adminTitleDate = new Array();
    for (var i = 0; i < eval(data).length; i++) {
        adminTitleCount[i] = data[i].adminTitleCount;
        adminTitleDate[i] = data[i].adminTitleDate;
    }
    var article_graph = echarts.init(document.getElementById("article_graph"));
    var option = {
        title: {
            text: '文章统计表',
            subtext: '总数/月'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: adminTitleDate
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '成交',
            type: 'line',
            smooth: true,
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0, color: '#c23531' // 0% 处的颜色
                    }, {
                        offset: 1, color: 'blue' // 100% 处的颜色
                    }], false)
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 1, color: '#c23531' // 0% 处的颜色
                    }, {
                        offset: 1, color: 'blue' // 100% 处的颜色
                    }], false)
                }
            },
            data: adminTitleCount
        }]
    };
    article_graph.setOption(option);
}
