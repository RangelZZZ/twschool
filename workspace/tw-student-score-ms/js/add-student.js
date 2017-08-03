$(document).ready(function () {
        $("#student-form").submit(function (event) {
        event.preventDefault();
        const studentInformation = $("#student-form").serializeArray();
        console.log(studentInformation);
    });

        
});