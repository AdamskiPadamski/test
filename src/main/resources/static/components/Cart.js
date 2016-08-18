var React = require('react');
var Link = require('react-router').Link;

var Cart = React.createClass({

  render: function() {
    var products = this.props.products;

    return (
      <div>
        <h1>Basket</h1>
          <ul>
            {this.props.products.map(product => <li key={product.id}>{product.name}</li>)}
          </ul>
          <Link to="/confirmation"><button>Checkout</button></Link>
      </div>
    );
  }

});

module.exports = Cart;
