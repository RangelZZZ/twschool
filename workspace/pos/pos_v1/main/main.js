'use strict';

function printReceipt(tags) {
  const allItems = loadAllItems();
  const cartItems = buildCartItems(tags, allItems);

  const promotions = loadPromotions();
  const receiptItems = buidReceiptItems(promotions, cartItems);

  const receiptText = buildReceitpText(receiptItems);

  console.log(receiptText);
}

function buildCartItems(tags, allItems) {
  const cartItems = [];
  for (const tag of tags) {
    const tagArray = tag.split('-');
    const barcode = tagArray[0];
    const count = parseFloat(tagArray[1] || 1);
    const cartItem = findCartItem(cartItems, barcode);
    if (cartItem) {
      cartItem.count += count;
    } else {
      const item = findItem(allItems, barcode);
      cartItems.push({barcode:item.barcode,name:item.name,unit:item.unit,price:item.price,count: count});
    }
  }
  return cartItems;
}


function findCartItem(cartItems, barcode) {
  for (let i = 0; i < cartItems.length; i++) {
    if (cartItems[i].barcode === barcode) {
      return cartItems[i];
    }
  }

  return false;
}

function findItem(allItems, barcode) {
  for (let i = 0; i < allItems.length; i++) {
    if (allItems[i].barcode === barcode) {
      return allItems[i];
    }
  }
}
