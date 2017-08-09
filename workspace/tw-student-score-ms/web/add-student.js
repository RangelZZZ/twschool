function addStudent(studentInformation) {

    const studentInfo = {};
    studentInformation.map(stu => {
        let a = stu.name;
        studentInfo[a] = stu.value;
    });

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/students",
        contentType: "application/json",
        data: JSON.stringify(studentInfo),
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
    $("#student-form").validate({
        rules: {
            name: "required",
            klass: "required",
            email: {
                required: true,
                email: true
            },
            personalId: {
                required: true,
                minlength: 18
            },
            mobilePhone: {
                required: true,
                minlength: 11
            },
            nativeplace: "required",
            grender: "required"
        },
        messages: {
            name: "用户名不能为空",
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
            const studentInformation = $("#student-form").serializeArray();
            addStudent(studentInformation);
            form.submit()
        }
    });

});