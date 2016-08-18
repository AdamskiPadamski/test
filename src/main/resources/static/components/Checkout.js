var React = require('react');
var ProductStore = require('../stores/ProductStore');

function getSelectedProducts() {
    return {
        products: ProductStore.getProducts().filter(item => item.selected === true),
    };
}

var Checkout = React.createClass({

    getInitialState: function() {
        return getSelectedProducts();
    },

    render: function() {
        return (
            <div>
                <div style={{'width': '33%', 'float': 'left'}}>
                    <h1>Checkout</h1>
                    <h2>Basket</h2>
                    <ul>
                        {this.state.products.map(product => <li key={product.id}>{product.name}</li>)}
                    </ul>
                    <button>Purchase</button>
                </div>
            </div>
        );
    }

});

module.exports = Checkout;