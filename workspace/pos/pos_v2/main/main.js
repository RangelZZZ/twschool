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
      cartItem.count += count;
    } else {
      let item = items.find(element => element.barcode === barcode);
      cartItems.push({barcode: item.barcode, name: item.name, unit: item.unit, price: item.price, count: count});
    }
  }

  return cartItems;
}
