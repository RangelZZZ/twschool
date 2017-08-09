$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/students",
        contentType: "application/json",
        dataTye: "json",
        statusCode: {
            200: function (data) {
                displaySelectScoreStudent(data);
            }
        }
    });

});


$(".click").click(function () {
    let inputId = $(".search-input").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/students/" + inputId,
        contentType: "application/json",
        dataTye: "json",
        statusCode: {
            200: function (data) {
                displaySelectScoreStudent(data);
            }
        }
    });

});


function displaySelectScoreStudent(student) {
    $("#myTemplate").tmpl(student).appendTo("#rows");
}






