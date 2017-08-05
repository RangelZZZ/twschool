$(function () {
    console.log("——————————————————");
    const studentScoreList = [{
        "name": "guoru", "studentId": 1, "mathScore": 90,
        "chineseScore": 90, "programScore": 90, "totalScore": 360, "averageScore": 90
    }, {
        "name": "fuhong", "studentId": 1, "mathScore": 90,
        "chineseScore": 90, "programScore": 90, "totalScore": 360, "averageScore": 90
    }];

    localStorage.setItem("scoreList", studentScoreList);
});
