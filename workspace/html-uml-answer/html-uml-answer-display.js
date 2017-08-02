$(document).ready(function () {
    const str = sessionStorage.getItem("studentAnswer");
    const student = JSON.parse(str);
    console.log(JSON.parse(str));
    $("body").text(student.shortAnswer);
});