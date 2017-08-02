$(document).ready(function () {
    $('.submit').click(function () {
        const studentAnswer = getStudentAnswer();
        sessionStorage.setItem("studentAnswer", JSON.stringify(studentAnswer));
        window.location.replace("html-uml-answer-display.html");
    });
});


function getStudentAnswer() {
    let studentAnswer = {};
    studentAnswer.studentInfo = getStudentInfo();

    studentAnswer.blankQuizAnswer = getBlankQuizAnswer();

    studentAnswer.singleChoiceAnswer = getSingleChoiceAnswer();

    studentAnswer.multipleChoiceAnswer = getMultipleChoiceAnswer();

    studentAnswer.judgeAnswer = getJudgeAnswer();

    studentAnswer.shortAnswer = getShortAnswer();

    return studentAnswer;
}

function getStudentInfo() {
    return {
        schoolId: $(".personal-info1").val(),
        class: $(".personal-info2").val(),
        name: $(".personal-info3").val(),
        personalId:$(".personal-info4").val(),
        email:$(".personal-info5").val()
    }
}

function getBlankQuizAnswer() {
    return {
        blankQuiz1: $(".blankQuiz1").val(),
        blankQuiz2: $(".blankQuiz2").map((index, e) => {
            return e.value;
        }).get()
    }
}

function getSingleChoiceAnswer() {
    return {
        singleChoice1: $("input[name='a']:checked").val(),

        singleChoice2: $("input[name='b']:checked").val()
    };
}

function getMultipleChoiceAnswer() {
    return {
        multipleChoice1: $("input[name='c']:checked").map((index, e) => {
            return e.value;
        }).get(),
        multipleChoice2: $("input[name='d']:checked").map((index, e) => {
            return e.value;
        }).get()
    }
}

function getJudgeAnswer() {
    return {
        judgeAnswer1: $("input[name='e']:checked").val(),

        judgeAnswer2: $("input[name='f']:checked").val()
    };
}

function getShortAnswer() {

    return $(".textArea").text();
}


