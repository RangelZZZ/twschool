'use strict';

module.exports = function countSameElements(collection) {
    const resultArray = [];

    for (let i = 0; i < collection.length; i++) {
        if (isNotExist(collection[i], resultArray)) {
            const count = calculateCount(collection[i], collection);
            resultArray.push({key: collection[i], count: count});
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

    for (let i = 0; i < collection.length; i++) {
        if (collection[i] === element) {
            count++;
        }
    }

    return count;
}
