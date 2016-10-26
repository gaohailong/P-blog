/**
 * Created by Administrator on 2016/10/25.
 */
//每个月发表的文章总数(网络)
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
            name: '文章数',
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

//文章对应的分类（网络）
function categoryGraph() {
    $.ajax({
        type: "GET",
        url: "/admin/selectTitleCountOfCate",
        dataType: "JSON",
        success: function (data) {
            setCateStatistics(data);
        },
        error: function (jqXHR) {
            alert("发生错误！" + jqXHR);
        }
    });
}

//文章对应的分类
function setCateStatistics(data) {
    var dataNum = new Array();
    var indicator2 = new Array();
    var max = 0;
    //判断最大值
    for (var i = 0; i < eval(data).length; i++) {
        if (data[i].cateTitleCount > 0) {
            max = data[i].cateTitleCount * 3;
        }
    }
    for (var i = 0; i < eval(data).length; i++) {
        dataNum[i] = data[i].cateTitleCount;
        indicator2[i] = new Cate(data[i].cateName, max * 2);
    }
    var dataCate = [
        dataNum
    ];
    var category_graph = echarts.init(document.getElementById("category_graph"));
    var lineStyle = {
        normal: {
            width: 1,
            opacity: 0.5
        }
    };
    var option = {
        backgroundColor: '#161627',
        title: {
            text: '文章类型 - 雷达图',
            left: 'center',
            textStyle: {
                color: '#eee'
            }
        },
        radar: {
            indicator: indicator2,
            shape: 'circle',
            splitNumber: 5,
            name: {
                textStyle: {
                    color: 'rgb(238, 197, 102)'
                }
            },
            splitLine: {
                lineStyle: {
                    color: [
                        'rgba(238, 197, 102, 0.1)', 'rgba(238, 197, 102, 0.2)',
                        'rgba(238, 197, 102, 0.4)', 'rgba(238, 197, 102, 0.6)',
                        'rgba(238, 197, 102, 0.8)', 'rgba(238, 197, 102, 1)'
                    ].reverse()
                }
            },
            splitArea: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(238, 197, 102, 0.5)'
                }
            }
        },
        series: [
            {
                type: 'radar',
                lineStyle: lineStyle,
                data: dataCate,
                symbol: 'none',
                itemStyle: {
                    normal: {
                        color: '#F9713C'
                    }
                },
                areaStyle: {
                    normal: {
                        opacity: 0.1
                    }
                }
            }
        ]
    };
    category_graph.setOption(option);
}

function Cate(name, max) {
    this.name = name;
    this.max = max;
}