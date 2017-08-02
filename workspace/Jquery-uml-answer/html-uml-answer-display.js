$(document).ready(function () {
    const str = sessionStorage.getItem("studentAnswer");
    const studentAnswer = JSON.parse(str);

    displayStudentInfo(studentAnswer);
});

function displayStudentInfo(studentAnswer) {
    const studentInfo = studentAnswer.studentInfo;

    $(".personal-info1").attr("value", studentInfo.schoolId);
    $(".personal-info2").attr("value", studentInfo.class);
    $(".personal-info3").attr("value", studentInfo.name);
    $(".personal-info4").attr("value", studentInfo.personalId);
    $(".personal-info5").attr("value", studentInfo.email);

    displayBlankQuizAnswer(studentAnswer)
}

function displayBlankQuizAnswer(studentAnswer) {
    const blankQuizAnswer = studentAnswer.blankQuizAnswer;
    $(".blankQuiz1").attr("value", blankQuizAnswer.blankQuiz1);
    $(".blankQuiz2").attr("value", blankQuizAnswer.blankQuiz2[0]);
    $(".blankQuiz3").attr("value", blankQuizAnswer.blankQuiz2[1]);
    $(".blankQuiz4").attr("value", blankQuizAnswer.blankQuiz2[2]);


    displaySingleChoice(studentAnswer);
}

function displaySingleChoice(studentAnswer) {
    const singleChoiceAnswer = studentAnswer.singleChoiceAnswer;
    $(".singleChoice1").text(singleChoiceAnswer.singleChoice1);
    $(".singleChoice2").text(singleChoiceAnswer.singleChoice2);

    displayMultipleChoiceAnswer(studentAnswer);
}

function displayMultipleChoiceAnswer(studentAnswer) {
    const multipleChooiceAnswer = studentAnswer.multipleChoiceAnswer;
    $(".multipleChoice1").text(multipleChooiceAnswer.multipleChoice1.join(","));
    $(".multipleChoice2").text(multipleChooiceAnswer.multipleChoice2.join(","));

    displayJudgeAnswer(studentAnswer);
}

function displayJudgeAnswer(studentAnswer) {
    const judgeAnswer = studentAnswer.judgeAnswer;

    $(".judgeAnswer1").text(judgeAnswer.judgeAnswer1);
    $(".judgeAnswer2").text(judgeAnswer.judgeAnswer2);

    displayShortAnser(studentAnswer);
}


function displayShortAnser(studentAnswer) {
    const shortAnswer = studentAnswer.shortAnswer;
    $(".textArea").val(shortAnswer);
}

