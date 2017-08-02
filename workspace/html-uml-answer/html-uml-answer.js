function getStudentAnswer() {
    let studentScore = {};
    studentScore.studentInfo = getStudentInfo();

    studentScore.blankQuizAnswer = getBlankQuizAnswer();

    studentScore.singleChoiceAnswer = getSingleChoiceAnswer();

    studentScore.multipleChoiceAnswer = getMultipleChoiceAnswer();

    studentScore.judgeAnswer = getJudgeAnswer();

    studentScore.shortAnswer = getShortAnswer();

    return studentScore;

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

        secondSinglechoce: $("input[name='b']:checked").val()
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


