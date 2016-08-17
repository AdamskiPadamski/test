var React = require('react');
var CartStore = require('../stores/CartStore');
var Cart = require('./Cart');

function getCartState() {
    return {
        cartItems: CartStore.getCartItems(),
    };
}

var Confirmation = React.createClass({

    getInitialState: function() {
        return getCartState();
    },

    render: function() {

        return (
          <div>
            <div style={{'width': '33%', 'float': 'left'}}>
                <Cart products={this.state.cartItems} />
            </div>
          </div>
        );
    }

});

module.exports = Confirmation;