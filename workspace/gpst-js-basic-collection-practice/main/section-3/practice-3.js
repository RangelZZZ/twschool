'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {
    const resultArray = [];

    for (let i = 0; i < collectionA.length; i++) {
        if (isNotExists(collectionA[i], resultArray)) {
            const count = calculateCount(collectionA[i], collectionA);
            resultArray.push({key: collectionA[i], count: count});
        }
    }

    return printResult(resultArray, objectB);

};

function isNotExists(element, resultArray) {
    for (let i = 0; i < resultArray.length; i++) {
        if (resultArray[i].key === element) {
            return false;
        }
    }

    return true;
}

function calculateCount(element, collectionA) {
    let count = 0;

    for (let i = 0; i < collectionA.length; i++) {
        if (collectionA[i] === element) {
            count++;
        }
    }

    return count;
}

function printResult(resultArray,object) {
    for (let i = 0; i < resultArray.length; i++) {
        if (isExists(resultArray[i].key, object.value)) {
            resultArray[i].count  -= parseInt(resultArray[i].count / 3 );
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
