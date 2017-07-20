'use strict';

function printReceipt(tags) {
  const items = Item.all();
  const cartItems = buildCartItems(tags, items);

  const promotions = Promotion.all();
  const receiptItems = buildReceiptItems(promotions, cartItems);

  const receiptText = buildReceiptText(receiptItems);

  console.log(receiptText);
}

function buildCartItems(tags, items) {
  let cartItems = [];

  for (const tag of tags) {
    let tagArray = tag.split('-');
    let barcode = tagArray[0];
    let count = parseFloat(tagArray[1]) || 1;

    const cartItem = cartItems.find(element => element.barcode === barcode);
    if (cartItem) {
      calculateItemsCount(cartItem, count);
    } else {
      cartItems = findItemByBarcode(items, barcode, cartItems, count);
    }
  }

  return cartItems;
}

function calculateItemsCount(cartItem, count) {
  cartItem.count += count;
}

function findItemByBarcode(items, barcode, cartItems, count) {
  let item = items.find(element => element.barcode === barcode);
  cartItems.push({barcode: item.barcode, name: item.name, unit: item.unit, price: item.price, count: count});

  return cartItems;
}

function buildReceiptItems(promotions, cartItems) {

  return cartItems.map(cartItem => {
    let [subTotal, savedTotal] = [0, 0];
    let total = parseFloat(cartItem.price * cartItem.count);

    if (judgeDisCountType(promotions, cartItem)) {
      subTotal = calculateItemsMoney(cartItem);
      savedTotal = parseFloat(total - subTotal);
    } else {
      savedTotal = 0;
      subTotal = total;
    }

    return {cartItem, savedTotal, subTotal};
  });
}


function judgeDisCountType(promotions, cartItem) {
  for(const promotion of promotions) {
    if (promotion.type === 'BUY_TWO_GET_ONE_FREE') {
      if (promotion.barcodes.find(barcode => barcode === cartItem.barcode)) {
        return true;
      }
    }
  }
}

function calculateItemsMoney(cartItem) {
  let price = cartItem.price;
  return cartItem.count >= 3 ? (cartItem.count - 1) * price : (cartItem.count * price);
}
