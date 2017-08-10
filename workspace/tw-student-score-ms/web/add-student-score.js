function addStudent(studentScoreInformation) {

    let score = {};
    studentScoreInformation.forEach(item => score[item.name] = item.value);
    let url = "http://localhost:8080/students/" + score.studentId + "/grades";

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify(score),
        dataType: "json",
        statusCode: {
            201: function () {
                alert("添加成功");
            },
            404: function () {
                alert("此学生不存在，无法添加成绩");
            }
        }
    });
}

$(document).ready(function () {


    const hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    $(".name").val(splitHash(hashes[1]));
    $(".studentId").val(splitHash(hashes[0]));

    $("#student-score-form").validate({
        rules: {
            name: "required",
            mathScore: {
                required: true,
                min: 0,
                max: 100
            },
            chineseScore: {
                required: true,
                min: 0,
                max: 100
            },
            englishScore: {
                required: true,
                min: 0,
                max: 100
            },
            programScore: {
                required: true,
                min: 0,
                max: 100
            },
        },
        messages: {
            username: "用户名不能为空",
            mathScore: {
                required: "成绩不能为空",
                min: "成绩最低为0分",
                max: "成绩最高为100分"
            },
            chineseScore: {
                required: "成绩不能为空",
                min: "成绩最低为0分",
                max: "成绩最高为100分"
            },
            englishScore: {
                required: "成绩不能为空",
                min: "成绩最低为0分",
                max: "成绩最高为100分"
            },
            programScore: {
                required: "成绩不能为空",
                min: "成绩最低为0分",
                max: "成绩最高为100分"
            },
        },

        submitHandler: function (form) {
            event.preventDefault();
            const studentScoreInformation = $("#student-score-form").serializeArray();
            addStudent(studentScoreInformation);
        }
    });

});


function splitHash(hash) {
    return hash.split("=")[1];

}