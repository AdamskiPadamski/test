var React = require('react');
var Link = require('react-router').Link;

var Basket = React.createClass({

  render: function() {
    var products = this.props.products;

    return (
      <div>
        <h2>Basket</h2>
          <ul>
            {this.props.products.map(product => <li key={product.id}>{product.name}</li>)}
          </ul>
          <Link to="/checkout"><button>Checkout</button></Link>
      </div>
    );
  }

});

module.exports = Basket;
