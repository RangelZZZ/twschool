$(function () {
    const studentScoreList = {
        studentScoreList: [{
            "username": "guoru", "studentId": 1, "mathScore": 90,
            "chineseScore": 90, "englishScore": 90, "programScore": 90, "totalScore": 360, "averageScore": 90
        }, {
            "username": "fuhong", "studentId": 1, "mathScore": 90,
            "chineseScore": 90, "englishScore": 90, "programScore": 90, "totalScore": 360, "averageScore": 90
        }],
        totalScore: 360,
        medianScore: 90
    };
    localStorage.setItem("scoreList", JSON.stringify(studentScoreList));

    const selectedStudentScoreList = JSON.parse(localStorage.getItem("scoreList"));

    displaySelectScoreStudent(selectedStudentScoreList);
});

function displaySelectScoreStudent(studentScoreList) {
    $("#myTemplate").tmpl(studentScoreList.studentScoreList).appendTo("#rows");
    const allScoreArray = [{totalScore:studentScoreList.totalScore,medianScore:studentScoreList.medianScore}];
    $("#totalScoreTemplete").tmpl(allScoreArray).appendTo("#rows");
}
