'use strict';

module.exports = function countSameElements(collection, objectB) {
    const resultArray = [];

    for (let i = 0; i < collection.length; i++) {
        if (isNotExist(collection[i], resultArray)) {
            const result = calculateCount(collection[i], collection);
            resultArray.push({key: result.key, count: result.count});
        }
    }

    return printResult(resultArray, objectB)
};

function isNotExist(element, resultArray) {
    for (let i = 0; i < resultArray.length; i++) {
        if (resultArray[i].key === element) {
            return false;
        }
    }

    return true;
}

function calculateCount(element, collection) {
    let count = 0;
    let key;

    for (let i = 0; i < collection.length; i++) {
        if (collection[i] === element && element.length === 1) {
            count++;
            key = element;
        }
        if (element.length > 1) {
            count = parseInt(element.split("-")[1]);
            key = element.split("-")[0];
        }
    }

    return {key: key, count: count};
}

function printResult(resultArray, object) {
    for (let i = 0; i < resultArray.length; i++) {
        if (isExists(resultArray[i].key, object.value)) {
            resultArray[i].count -= parseInt(resultArray[i].count / 3);
        }
    }

    return resultArray;

}

function isExists(element, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (collection[i] === element) {
            return true;
        }
    }
    return false;
}
