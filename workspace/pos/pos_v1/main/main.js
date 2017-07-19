'use strict';

function printReceipt(tags) {
  const allItems = loadAllItems();
  const cartItems = buildCartItems(tags, allItems);

  const promotions = loadPromotions();
  const receiptItems = buildReceiptItems(promotions, cartItems);

  const receiptText = buildReceiptText(receiptItems);

  console.log(receiptText);
}

function buildCartItems(tags, allItems) {
  const cartItems = [];

  tags.forEach(tag => {
    let barcodeArray = tag.split("-");
    let barcode = barcodeArray[0];
    let count = parseFloat(barcodeArray[1]) || 1;
    let cartItem = cartItems.find(item => item.barcode === barcode);

    if (cartItem) {
      cartItem.count += count;
    } else {
      let item = allItems.find(item => item.barcode === barcode);
      if (item) {
        cartItems.push({barcode: item.barcode, name: item.name, price: item.price, unit: item.unit, count});
      }
    }
  });

  return cartItems;

}


function buildReceiptItems(promotions, cartItems) {
  let subTotal = 0;
  let total = 0;
  let savedTotal = 0;

  return cartItems.map(cartItem => {
    promotions.forEach(promotion => {
      if (promotion.type === "BUY_TWO_GET_ONE_FREE") {
        if (promotion.barcodes.find(code => code === cartItem.barcode)) {
          total = parseFloat(cartItem.count * cartItem.price);
          subTotal = parseFloat((cartItem.price * (cartItem.count - parseInt(cartItem.count / 3))));
          savedTotal = parseFloat(total - subTotal);
        } else {
          savedTotal = 0;
          subTotal = parseFloat(cartItem.count * cartItem.price);
        }
      }
    });

    return {cartItem, savedTotal, subTotal};
  });
}

function buildReceiptText(receiptItems) {
  let receiptText = "***<没钱赚商店>收据***\n";
  let total = 0;
  let savedTotal = 0;

  receiptItems.forEach(receiptItem => {
    total += receiptItem.subTotal;
    savedTotal += receiptItem.savedTotal;
    receiptText += `名称：${receiptItem.cartItem.name}，数量：${receiptItem.cartItem.count}${receiptItem.cartItem.unit}，单价：${receiptItem.cartItem.price.toFixed(2)}(元)，小计：${receiptItem.subTotal.toFixed(2)}(元)\n`;
  });

  return receiptText += `----------------------
总计：${total.toFixed(2)}(元)
节省：${savedTotal.toFixed(2)}(元)
**********************`;
}

