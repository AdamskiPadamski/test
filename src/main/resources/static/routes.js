var React = require('react');
var Route = require('react-router').Route;
var IndexRedirect = require('react-router').IndexRedirect;
var ProductSelection = require('./components/ProductSelection');
var Checkout = require('./components/Checkout');
var AppContainer = require('./components/AppContainer');

module.exports = (
    <Route path="/" component={AppContainer}>
        <IndexRedirect to="/product-selection" />
        <Route path="product-selection" component={ProductSelection} />
        <Route path="checkout" component={Checkout} />
    </Route>
);