'use strict';

module.exports = function countSameElements(collection) {
    let middleConnection = [];

    for (let i = 0; i < collection.length; i++) {
        if (collection[i].length > 1) {
            const count = collection[i].replace(/[^0-9]/ig, "");
            const element = collection[i].split('')[0];
            collection.splice(i, 1, element);
            middleConnection = generateNewCollection(element, count, middleConnection);
        }
    }

    return generateResultCollection(collection, middleConnection);

};

function generateNewCollection(element, count, middleConnection) {
    for (let i = 0; i < count - 1; i++) {
        middleConnection.push(element);
    }

    return middleConnection;
}

function generateResultCollection(collection, middleConnection) {
    const resultArray = [];
    const resultCollection = collection.concat(middleConnection);

    for (let i = 0; i < resultCollection.length; i++) {
        if (isNotExist(resultCollection[i], resultArray)) {
            const summary = calculateCount(resultCollection[i], resultCollection);
            resultArray.push({name: resultCollection[i], summary: summary});
        }
    }

    return resultArray;
}

function isNotExist(element, resultArray) {

    for (let i = 0; i < resultArray.length; i++) {
        if (element === resultArray[i].name) {
            return false;
        }
    }

    return true;
}

function calculateCount(element, resultCollection) {
    let count = 0;

    for (let i = 0; i < resultCollection.length; i++) {
        if (element === resultCollection[i]) {
            count++;
        }
    }

    return count;
}