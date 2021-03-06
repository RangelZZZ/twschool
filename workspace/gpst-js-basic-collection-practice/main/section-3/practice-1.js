'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {
    for (let i = 0; i < collectionA.length; i++) {
        if (isExists(collectionA[i].key, objectB.value)) {
            collectionA[i].count--;
        }
    }

    return collectionA;
};

function isExists(element, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (collection[i] === element) {
            return true;
        }
    }
    return false;
}