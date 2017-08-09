function addStudent(studentInformation) {
    const student = {};
     studentInformation.forEach(item => student[item.name] = item.value);
}

$(document).ready(function () {
    $("#student-score-form").validate({
        rules: {
            username: "required",
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