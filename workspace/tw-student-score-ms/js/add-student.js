let studentList = [];
localStorage.setItem("studentList", JSON.stringify(studentList));

function addStudent(studentInformation) {
    const studentList = JSON.parse(localStorage.getItem("studentList"));
    studentList.push(studentInformation);
    localStorage.setItem("studentList", JSON.stringify(studentList));
}

$(document).ready(function () {
    $("#student-form").validate({
        rules: {
            username: "required",
            klass: "required",
            email: {
                required: true,
                email: true
            },
            personalId: {
                required: true,
                minlength: 1
            },
            mobilePhone: {
                required: true,
                minlength: 1
            },
            nativeplace: "required",
            grender: "required"
        },
        messages: {
            username: "用户名不能为空",
            klass: "班级不能为空",
            email: {
                required: "邮箱不能为空",
                email: "邮箱格式不正确",
            },
            personalId: {
                required: "身份证不能为空",
                minlength: "请输入正确的身份证号"
            },
            mobilePhone: {
                required: "电话号码不能为空",
                minlength: "请输入正确的电话号码"
            },
            nativeplace: "籍贯不能为空",
            grender: "性别不能为空"
        },

        submitHandler: function (form) {
            event.preventDefault();
            const studentInformation = $("#student-form").serializeArray();
            addStudent(studentInformation);
        }
    });


});