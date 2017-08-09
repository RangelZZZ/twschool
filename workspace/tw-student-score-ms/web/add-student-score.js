function addStudent(studentInformation) {
    const student = {};
    studentInformation.forEach(item => student[item.name] = item.value);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/students",
        contentType: "application/json",
        data: JSON.stringify(student),
        dataType: "json",
        statusCode: {
            201: function () {
                alert("添加成功");
            },
            409: function () {
                alert("该学生已添加");
            }
        }
    });
}

$(document).ready(function () {
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
            const studentInformation = $("#student-score-form").serializeArray();
            addStudent(studentInformation);
        }
    });

});