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
        id: $(".personal-info1").val(),
        class: $(".personal-info2").val(),
        name: $(".personal-info3").val()
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
        firstSingleChoice: $("input[name='a']:checked").val(),

        secondSingleChoice: $("input[name='b']:checked").val()
    };
}

function getMultipleChoiceAnswer() {
    return {
        multipleChoiceAnswer1: $("input[name='c']:checked").map((index, e) => {
            return e.value;
        }).get(),
        multipleChoiceAnswer2: $("input[name='d']:checked").map((index, e) => {
            return e.value;
        }).get()
    }
}

function getJudgeAnswer() {
    return {
        firstJudgeAnswer: $("input[name='e']:checked").val(),

        secondJudgeAnswer: $("input[name='f']:checked").val()
    };
}

function getShortAnswer() {

    return $(".textArea").text();
}


