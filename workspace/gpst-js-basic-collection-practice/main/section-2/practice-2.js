'use strict';

module.exports = function countSameElements(collection) {
    const resultArray = [];

    for (let i = 0; i < collection.length; i++) {
        if (isNotExist(collection[i], resultArray)) {
            const result = calculateCount(collection[i], collection);
            resultArray.push({key: result.key, count: result.count});
        }
    }

    return resultArray;
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
