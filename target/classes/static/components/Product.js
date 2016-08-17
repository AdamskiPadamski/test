var React = require('react');
var CartActions = require('../actions/CartActions');

var Product = React.createClass({

    addToCart: function(event) {
        if (event.target.checked) {
            CartActions.addToCart(this.props.product);
        } else {
            CartActions.removeFromCart(this.props.product);
        }
    },

    render: function() {
        return (
            <div>
                <input type="checkbox" onChange={this.addToCart} /> {this.props.product.name}
            </div>
        );
    }

});

module.exports = Product;