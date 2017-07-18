'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
    const resultArray = [];

    for (let i = 0; i < collectionA.length; i++) {
        if (isExist(collectionA[i].key, objectB.value)) {
            resultArray.push(collectionA[i].key);
        }
    }

    return resultArray;
};

function isExist(element, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (element === collection[i]) {
            return true;
        }
    }
    return false;
}
