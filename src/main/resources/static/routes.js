var React = require('react');
var Route = require('react-router').Route;
var IndexRedirect = require('react-router').IndexRedirect;
var CartApp = require('./components/CartApp');
var Confirmation = require('./components/Confirmation');
var Container = require('./components/Container');

module.exports = (
    <Route path="/" component={Container}>
        <IndexRedirect to="/product-selection" />
        <Route path="product-selection" component={CartApp} />
        <Route path="confirmation" component={Confirmation} />
    </Route>
);