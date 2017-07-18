'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {
    const resultArray = [];
    
    for (let i = 0; i < collectionA.length; i++) {
        if (isExist(collectionA[i], collectionB)) {
            resultArray.push(collectionA[i]);
        }
    }

    return resultArray;
};

function isExist(element, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (collection[i] === element) {
            return true;
        }
    }

    return false;

}