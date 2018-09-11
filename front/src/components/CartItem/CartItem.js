import React, { Component } from 'react';
import Icon from 'react-fontawesome';
import '../../style.css';
import axios from 'axios';

export default class CartItem extends Component {

    deleteItem (id) {
      console.log(id);
      axios.get(`http://localhost:9090/deleteproduct/${id}`)
      .then((res) => {
          window.location.reload();
      }).catch((err) => {
       console.log(err);
      });
    }

    render () {
        const name = this.props.item.productName;
        const id = this.props.item.id;
        const price = this.props.item.price;
        const quantity = this.props.item.quantity;
    
        return (
          <div className="row cart-item">
            <div className="col-md-6">
              <h6 className="product-name">{name}</h6>
            </div>
            <div className="row col-md-6">
              <div className="col-md-4 text-center">
                <h6>{price}</h6>
              </div>
              <div className="col-md-4 text-center">
                <h6>{quantity}</h6>
              </div>
              <div className="col-md-4 text-center">
                <button type="button" className="btn btn-link btn-xs btn-cart" onClick={this.deleteItem.bind(this,id)}>
                  <Icon name="trash"></Icon>
                </button>
              </div>
            </div>
          </div>
        );
    }
}