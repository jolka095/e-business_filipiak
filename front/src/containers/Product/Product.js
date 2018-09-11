import React, { Component } from 'react';
import '../../style.css'
import Icon from 'react-fontawesome';
import axios from 'axios';

export default class Product extends Component {

    state = {
        quantity: 1,
        log: false
    }

    updateQuantity (event) {
        let oldQuantity = this.state.quantityToBasket;
        this.setState({
            quantity: event.target.value
      })
    }

    addToCart (name, id, price) {
       const userId = sessionStorage.getItem('userID').toString();
       const params = new URLSearchParams();
       
       params.append('user', userId);
       params.append('product', id);
       params.append('productName', name);
       params.append('quantity', this.state.quantity);
       params.append('price', price);

       axios({
        method: 'post',
        url: 'http://localhost:9090/addproductkoszyk',
        data: params
       });
    }

    checkUserStatus(name, id, price){
        let isLogged = sessionStorage.getItem('log');
        if(isLogged === "true") {
            return(
                <button type="button" className="btn btn-link btn-xs" onClick={this.addToCart.bind(this, name, id, price)} >
                <Icon name="shopping-cart"/><span className="hidden-sm">  Do koszyka</span>
              </button>
            )
        }
    }

    checkUserLog() {
        let isLogged = sessionStorage.getItem('log');
        if(isLogged === "true") {
        return (
            <input className="form-control input-sm" type="text" value={this.state.quantity} onChange={this.updateQuantity.bind(this)} />
        )
      }
    }
  
    render () {
    
        const name = this.props.product.name;
        const id = this.props.product.id;
        const price = this.props.product.price;
        const url = this.props.product.imageUrl;
    
        return (
          <div className="col-sm-3">
            <div className="col-item">
              <div className="photo">
                <img src={url} className="img-responsive" alt="a" />
              </div>
              <div className="info">
                <div className="row">
                  <div className="price col-md-12">
                    <h6>{name}</h6>
                    <h6 className="price-text-color">{price} zł</h6>
                  </div>
                </div>
                <div className="separator clear-left">
               <p className="section-qty">
                    {this.checkUserLog()}
                  </p>
                  <p className="section-add">
                   {this.checkUserStatus(name,id,price)}
                  </p> 
                </div>
                <div className="clearfix"></div>
              </div>
            </div>
          </div>
        );
    };

}





