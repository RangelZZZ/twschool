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
        cartItems.push({barcode: item.barcode, name: item.name, price: item.price, unit: item.unit, count: count});
      }
    }
  });

  return cartItems;

}
