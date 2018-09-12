import React, { Component } from 'react';
import '../../style.css'
import Icon from 'react-fontawesome';
import axios from 'axios';
import { Button, Card, CardImg, CardText, CardBody, CardLink,
  CardTitle, CardSubtitle, Row, Col } from 'reactstrap';

export default class Product extends Component {

    state = {
        quantity: 1,
        log: false
    }

    updateQuantity (event) {
        // let oldQuantity = this.state.quantityToBasket;
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
              <button type="button" className="btn btn-link btn-lg add_to_cart" onClick={this.addToCart.bind(this, name, id, price)} >
                <Icon name="cart-plus"/>
              </button>
            )
        }
    }

    checkUserLog() {
        let isLogged = sessionStorage.getItem('log');
        if(isLogged === "true") {
        return (
            <input className="form-control input-sm" type="number" min="1" value={this.state.quantity} onChange={this.updateQuantity.bind(this)} />
        )
      }
    }
  
    render () {
        const name = this.props.product.name;
        const id = this.props.product.id;
        const price = this.props.product.price;
        const url = this.props.product.imageUrl;
    
        return (

          <Card className="col-md-3">
            <CardBody>
              <CardTitle>{name.toUpperCase()}</CardTitle>
              <CardSubtitle className="price-text-color">{price} $</CardSubtitle>
            </CardBody>
             <img src={url} className="img-fluid rounded mx-auto d-block" alt={name} />
            <CardBody>
              <Row>
              <span className="section-qty col-sm-6">                
                  {this.checkUserLog()}
                </span>

                <span className="section-add col-sm-6">
                  {this.checkUserStatus(name,id,price)}
                </span>  

                {/* <CardText>Some quick example text to build on the card title and make up the bulk of the card's content.</CardText> */}
                {/* <CardLink href="#">Another Link</CardLink> */}
              </Row>                         
            </CardBody>
          </Card>
        );
    };

}