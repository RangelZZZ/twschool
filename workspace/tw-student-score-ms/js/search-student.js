$(document).ready(function () {
    const studentList = JSON.parse(localStorage.getItem("studentList")) || [];
    let newStudentList = [];

    studentList.forEach(student => {
        let stu = {};
        student.map(s => {
            let a = s.name;
            let b = s.value;
            stu[a] = b;
        });
        newStudentList.push(stu);
        $("#myTemplate").tmpl(newStudentList).appendTo("#rows")
    });


    $(".click").click(function () {
        let userInput = $(".search-input").val();
        let selectedStudent = newStudentList.find(student => student.username === userInput);
        
        if (selectedStudent) {
            displaySelectStudent(selectedStudent);
        } else {
            selectedStudent = newStudentList.find(student => parseInt(student.studentId) == userInput);
            if (selectedStudent) {
                displaySelectStudent(selectedStudent)
            }
        }
    });
});

function displaySelectStudent(student) {
    $("#myTemplate").tmpl(student).appendTo("#rows");
}






