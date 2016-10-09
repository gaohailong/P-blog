/**
 * Created by gaohailong on 2016/9/27.
 */

window.onload = function () {
    setIframeHeight(document.getElementById('right_iframe'));
}

/*让iframe窗体高度自适应*/
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.body.scrollHeight;
        }
    }
}

/*点击切换右边*/
//TODO 待加上网络后进行具体操作
function setIframeHtml(iframeHtml) {
    var iframeId = document.getElementById("right_iframe");
    iframeId.src = "/pblog/web/"+iframeHtml + ".jsp";
}
