$(function () {

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

    $(".submit-button").click(function () {
        const updateGrade = $("#update-model").serializeArray();
        let score = {};
        updateGrade.forEach(item => score[item.name] = item.value);

        let url = "http://localhost:8080/students/" + score.studentId + "/grades";
        alert(url);
        $.ajax({
            type: "PUT",
            url: url,
            data: JSON.stringify(score),
            contentType: "application/json",
            dataTye: "json",
            statusCode: {
                204: function () {
                    alert("修改成功")
                }
            }
        });


    })

});


function displaySelectScoreStudent(studentScoreList) {
    $("#myTemplate").tmpl(studentScoreList.reportItems).appendTo("#rows");
    const allScoreArray = [{totalScore: studentScoreList.totalScore, medianScore: studentScoreList.medianScore}];
    $("#totalScoreTemplete").tmpl(allScoreArray).appendTo("#rows");
}

