'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {
    const resultArray = [];
    
    collectionA.forEach(element=>{
        if(collectionB.find(item=> item === element)){
            resultArray.push(element);
        }
    });

    return resultArray;
};
