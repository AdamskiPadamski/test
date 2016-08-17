var React = require('react');
var CartAPI = require('./utils/CartAPI');
var ProductAPI = require('./utils/ProductAPI');
var CartApp = require('./components/CartApp');
var ReactDOM = require('react-dom');
var Router = require('react-router').Router;
var hashHistory = require('react-router').hashHistory;
var routes = require('./routes');

localStorage.customerId = 1;

ProductAPI.getProductData();

ReactDOM.render(<Router routes={routes} history={hashHistory} />, document.getElementById('app'));