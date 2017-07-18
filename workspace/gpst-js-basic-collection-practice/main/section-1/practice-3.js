'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
    const resultArray = [];

    for (let i = 0; i < collectionA.length; i++) {
        if (isExists(collectionA[i], objectB.value)) {
            resultArray.push(collectionA[i]);
        }
    }

    return resultArray;
};

function isExists(element, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (element === collection[i]) {
            return true;
        }
    }

    return false;
}
