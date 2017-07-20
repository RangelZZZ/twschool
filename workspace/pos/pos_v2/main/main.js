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
  for (const promotion of promotions) {
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

function buildReceiptText(receiptItems) {
  let currentTime = getCurrentDate();
  let receiptText = `***<没钱赚商店>收据***
打印时间：${currentTime}
----------------------\n`;
  const receiptTextInformation = generateItemText(receiptItems, receiptText);

  return `${receiptText}${receiptTextInformation.itemInformation}----------------------
总计：${receiptTextInformation.total.toFixed(2)}(元)
节省：${receiptTextInformation.savedTotal.toFixed(2)}(元)
**********************`;
}

function generateItemText(receiptItems) {
  let [total, savedTotal] = [0, 0];
  let itemInformation = [];

  receiptItems.forEach(receiptItem => {
    total += receiptItem.subTotal;
    savedTotal += receiptItem.savedTotal;
    itemInformation += `名称：${receiptItem.cartItem.name}，数量：${receiptItem.cartItem.count}${receiptItem.cartItem.unit}，单价：${receiptItem.cartItem.price.toFixed(2)}(元)，小计：${receiptItem.subTotal.toFixed(2)}(元)\n`;
  });
  return {total, savedTotal, itemInformation};
}


function getCurrentDate() {
  const currentDate = new Date(),
    year = dateDigitToString(currentDate.getFullYear()),
    month = dateDigitToString(currentDate.getMonth() + 1),
    date = dateDigitToString(currentDate.getDate()),
    hour = dateDigitToString(currentDate.getHours()),
    minute = dateDigitToString(currentDate.getMinutes()),
    second = dateDigitToString(currentDate.getSeconds());

  return `${year}年${month}月${date}日 ${hour}:${minute}:${second}`;
}

const dateDigitToString = num => (num < 10 ? `0${num}` : num);


