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
          <tr>
            <td>                
              <button type="button" className="btn btn-link btn-xs btn-cart" onClick={this.deleteItem.bind(this,id)}>
                <Icon name="trash"></Icon>
              </button>
            </td>
            <td ><h6 className="product-name">{name}</h6></td>
            <td ><h6>{quantity}</h6></td>
            <td ><h6>{price} PLN</h6></td>
          </tr>
        );
    }
}