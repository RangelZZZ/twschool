'use strict';

describe(' Integration pos', () => {

  it('should print text', () => {

    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];

    spyOn(console, 'log');

    printReceipt(tags);

    const expectText = `***<没钱赚商店>收据***
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    expect(console.log).toHaveBeenCalledWith(expectText);
  });
});

describe("unit pos", () => {
  it("should build cartItems", () => {
    const allItems = loadAllItems();
    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];

    const expectCartItems = [{
      barcode: 'ITEM000001',
      name: '雪碧',
      unit: '瓶',
      price: 3.00,
      count: 5
    }, {
      barcode: 'ITEM000003',
      name: '荔枝',
      unit: '斤',
      price: 15.00,
      count: 2.5
    }, {
      barcode: 'ITEM000005',
      name: '方便面',
      unit: '袋',
      price: 4.50,
      count: 3
    }];

    const cartItems = buildCartItems(tags, allItems);

    expect(cartItems).toEqual(expectCartItems);
  });

  it("should build receiptItems", () => {

    const promotions = loadPromotions();

    const cartItems = [{
      barcode: 'ITEM000001',
      name: '雪碧',
      unit: '瓶',
      price: 3.00,
      count: 5
    }, {
      barcode: 'ITEM000003',
      name: '荔枝',
      unit: '斤',
      price: 15.00,
      count: 2.5
    }, {
      barcode: 'ITEM000005',
      name: '方便面',
      unit: '袋',
      price: 4.50,
      count: 3
    }];

    const expectReceiptItems = [{
      cartItem: {
        barcode: 'ITEM000001',
        name: '雪碧',
        unit: '瓶',
        price: 3.00,
        count: 5
      },
      subTotal: 12,
      savedTotal: 3
    }, {
      cartItem: {
        barcode: 'ITEM000003',
        name: '荔枝',
        unit: '斤',
        price: 15.00,
        count: 2.5
      },
      subTotal: 37.5,
      savedTotal: 0

    }, {
      cartItem: {
        barcode: 'ITEM000005',
        name: '方便面',
        unit: '袋',
        price: 4.50,
        count: 3
      },
      subTotal: 9,
      savedTotal: 4.5
    }
    ];

    const receiptItems = buildReceiptItems(promotions, cartItems);

    expect(receiptItems).toEqual(expectReceiptItems);
  });

  it("should build receiptText", () => {
    const receiptItems = [{
      cartItem: {
        barcode: 'ITEM000001',
        name: '雪碧',
        unit: '瓶',
        price: 3.00,
        count: 5
      },
      subTotal: 12,
      savedTotal: 3
    }, {
      cartItem: {
        barcode: 'ITEM000003',
        name: '荔枝',
        unit: '斤',
        price: 15.00,
        count: 2.5
      },
      subTotal: 37.5,
      savedTotal: 0

    }, {
      cartItem: {
        barcode: 'ITEM000005',
        name: '方便面',
        unit: '袋',
        price: 4.50,
        count: 3
      },
      subTotal: 9,
      savedTotal: 4.5
    }
    ];

    const expectReceiptText = `***<没钱赚商店>收据***
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    const receiptText = buildReceiptText(receiptItems);

    expect(receiptText).toEqual(expectReceiptText);
  })
});
