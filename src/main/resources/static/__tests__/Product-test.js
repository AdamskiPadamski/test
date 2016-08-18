jest.unmock('../components/Product');

var React = require('react');
var ReactDOM = require('react-dom');
var TestUtils = require('react-addons-test-utils');
var Product = require('../components/Product');

describe('Product', () => {
  it('should display the product name', () => {

    var product = TestUtils.renderIntoDocument(
      <Product product={{name: 'test'}} />
    );

    var productNode = ReactDOM.findDOMNode(product);

    expect(productNode.textContent).toEqual('test');
  });

  it('should call onButtonSubmit when a click is triggered', function() {
      Product.addToCart = jest.genMockFunction();

      var product = TestUtils.renderIntoDocument(
          <Product product={{name: 'test'}} />
      );

      var input = TestUtils.findRenderedDOMComponentWithTag(product, 'input');

      TestUtils.Simulate.change(input);

      expect(Product.addToCart).toBeCalled();
  });
});