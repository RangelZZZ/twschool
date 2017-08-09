$(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/reports?studentIds=1,2,3",
        contentType: "application/json",
        dataTye: "json",
        statusCode: {
            200: function (data) {
                displaySelectScoreStudent(data);
            }
        }
    });
});

function displaySelectScoreStudent(studentScoreList) {
    $("#myTemplate").tmpl(studentScoreList.reportItems).appendTo("#rows");
    const allScoreArray = [{totalScore: studentScoreList.totalScore, medianScore: studentScoreList.medianScore}];
    $("#totalScoreTemplete").tmpl(allScoreArray).appendTo("#rows");
}
