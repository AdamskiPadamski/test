var React = require('react');
var CartActions = require('../actions/CartActions');
var Link = require('react-router').Link;

var Cart = React.createClass({

  render: function() {
    var products = this.props.products;

    return (
      <div>
        <h1>Basket</h1>
          <ul>
            {Object.keys(products).map(function(product){
              return (
                <li key={products[product].id}>{products[product].name}</li>
              )
            })}
          </ul>
          <Link to="/confirmation"><button>Checkout</button></Link>
      </div>
    );
  }

});

module.exports = Cart;
