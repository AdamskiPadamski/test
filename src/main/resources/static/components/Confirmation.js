var React = require('react');
var ProductStore = require('../stores/ProductStore');
var Cart = require('./Cart');

function getCartState() {
    return {
        cartItems: ProductStore.getProducts().filter(item => item.selected === true),
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
                <h1>Confirm purchase</h1>
                <ul>
                    {this.state.cartItems.map(item => <li key={item.id}>{item.name}</li>)}
                </ul>
                <button>Purchase</button>
            </div>
          </div>
        );
    }

});

module.exports = Confirmation;