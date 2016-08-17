var CartActions = require('../actions/CartActions');

module.exports = {

  getProductData: function () {
    var data = {id: 1, name: "test"};
    CartActions.addToCart(data);
  }

};