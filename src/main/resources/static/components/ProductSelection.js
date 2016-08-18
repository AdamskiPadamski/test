var React = require('react');
var ProductStore = require('../stores/ProductStore');
var ProductList = require('./ProductList');
var Basket = require('./Basket');
var _ = require('underscore');

function getProducts() {
    return {
        products: ProductStore.getProducts()
    };
}

var ProductSelection = React.createClass({

    getInitialState: function() {
        return getProducts();
    },

    componentDidMount: function() {
        ProductStore.addChangeListener(this._onChange);
    },

    componentWillUnmount: function() {
        ProductStore.removeChangeListener(this._onChange);
    },

    render: function() {
        var productsByCategory = _.groupBy(this.state.products, 'category');
        var headings = Object.keys(productsByCategory);

        return (
            <div>
                <h1>Product Selection</h1>
                <div style={{'width': '66%', 'float': 'left'}}>
                    {headings.map(heading => <ProductList key={heading} heading={heading} products={productsByCategory[heading]} />)}
                </div>
                <div style={{'width': '33%', 'float': 'left'}}>
                    <Basket products={this.state.products.filter(product => product.selected === true)} />
                </div>
            </div>
        );
    },

    _onChange: function() {
        this.setState(getProducts());
    }

});

module.exports = ProductSelection;