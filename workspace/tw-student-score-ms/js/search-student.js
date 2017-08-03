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
        console.log(newStudentList);
        $("#myTemplate").tmpl(newStudentList).appendTo("#rows")
    });
});



