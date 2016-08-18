var React = require('react');
var ProductActions = require('../actions/ProductActions');

var Product = React.createClass({

    toggleSelected: function(event) {
        if (event.target.checked) {
            ProductActions.addProduct(this.props.product);
        } else {
            ProductActions.removeProduct(this.props.product);
        }
    },

    render: function() {
        return (
            <div>
                <input type="checkbox" onChange={this.toggleSelected} checked={this.props.product.selected} />{this.props.product.name}
            </div>
        );
    }

});

module.exports = Product;