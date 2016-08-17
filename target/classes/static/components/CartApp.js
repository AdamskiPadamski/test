var React = require('react');
var CartStore = require('../stores/CartStore');
var ProductStore = require('../stores/ProductStore');
var ProductList = require('./ProductList');
var Cart = require('./Cart');
var _ = require('underscore');

function getCartState() {
    return {
        products: ProductStore.getProduct(),
        cartItems: CartStore.getCartItems(),
    };
}

var CartApp = React.createClass({

    getInitialState: function() {
        return getCartState();
      },

    componentDidMount: function() {
        ProductStore.addChangeListener(this._onChange);
        CartStore.addChangeListener(this._onChange);
    },

    componentWillUnmount: function() {
        ProductStore.removeChangeListener(this._onChange);
        CartStore.removeChangeListener(this._onChange);
    },

    render: function() {
        var productsByCategory = _.groupBy(this.state.products, 'category');
        var headings = Object.keys(productsByCategory);

        return (
          <div>
            <div style={{'width': '66%', 'float': 'left'}}>
                {headings.map(heading => <ProductList key={heading} heading={heading} products={productsByCategory[heading]} />)}
            </div>
            <div style={{'width': '33%', 'float': 'left'}}>
                <Cart products={this.state.cartItems} />
            </div>
          </div>
        );
    },

    _onChange: function() {
        this.setState(getCartState());
    }

});

module.exports = CartApp;