$(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/reports",
        contentType: "application/json",
        dataTye: "json",
        statusCode: {
            200: function (data) {
                displaySelectScoreStudent(data);
            }
        }
    });

    $(".click").click(function () {
        let studentIds = $(".search-input").val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/reports?studentIds=" + studentIds,
            contentType: "application/json",
            dataTye: "json",
            statusCode: {
                200: function (data) {
                    displaySelectScoreStudent(data);
                }
            }
        });
    });
    
    $(".link").click(function () {
        console.log("into link");
        let username = $(".name1").val();
        console.log(username);
        $(".username").attr("text", username);
    })
    
    
});


function displaySelectScoreStudent(studentScoreList) {
    $("#myTemplate").tmpl(studentScoreList.reportItems).appendTo("#rows");
    const allScoreArray = [{totalScore: studentScoreList.totalScore, medianScore: studentScoreList.medianScore}];
    $("#totalScoreTemplete").tmpl(allScoreArray).appendTo("#rows");
}


function OpenWindow(htmUrl)
{
    const url=htmUrl;
    const winName="newWin";
    const awidth=screen.availWidth/6*2;       //窗口宽度,需要设置
    const aheight=screen.availHeight/5*2;         //窗口高度,需要设置
    const atop=(screen.availHeight - aheight)/2;  //窗口顶部位置,一般不需要改
    const aleft=(screen.availWidth - awidth)/2;   //窗口放中央,一般不需要改
    const param0="scrollbars=0,status=0,menubar=0,resizable=no,location=0"; //新窗口的参数
    const params="top=" + atop + ",left=" + aleft + ",width=" + awidth + ",height=" + aheight + "," + param0 ;
    win=window.open(url,winName,params); //打开新窗口
    win.focus(); //新窗口获得焦点
}
