import React, { Component } from 'react';
import '../../style.css'
import CartItem from './../../components/CartItem/CartItem';
import Toolbar from './../Toolbar/Toolbar';
import Footer from './../../components/Footer/Footer';
import './Basket.css'
import Icon from 'react-fontawesome';
import axios from 'axios';

export default class Basket extends Component {
    
   state = {
        products: [],
    }

    componentDidMount() {
        const userID = sessionStorage.getItem('userID');
        axios.get(`http://localhost:9090/koszyk/${userID}`)
            .then((res) => {
                console.log(res);
                this.setState({products: res.data})
        }).catch((err) => {
        console.log(err)});
    }
     
    emptyBasket() {
        alert('to do');
    }

    render () {
        let sumPerItem = this.state.products.map((item) => { return item.quantity * item.price });
        let totalSum = sumPerItem.reduce((pricePrev, priceNext) => { return pricePrev + priceNext},0);
        let itemsMapped = this.state.products.map(function (item, index) {
        return <CartItem item={item} key={index} />
   });
          
    let empty = <div className="alert alert-info">Koszyk jest pusty</div>;

    return (
        <div className="container">
        <Toolbar/>
        <div className="Content">
        <div className="row extra-bottom-margin">
          <div className="col-md-8 col-md-offset-2">
            <div className="card card-info card-inverse">
              <div className="card-header">
                <div className="card-title">
                  <div className="row">
                    <div className="col-md-12">
                      <h4><Icon name="shopping-cart"></Icon> Mój koszyk</h4>
                    </div>
                  </div>
                </div>
              </div>
              <div className="card-block">
                <div className="row">
                  <div className="col-md-6">
                    <h6><strong>Produkty</strong></h6>
                  </div>
                  <div className="row col-md-6">
                    <div className="col-md-4 text-center">
                      <h6><strong>Cena</strong></h6>
                    </div>
                    <div className="col-md-4 text-center">
                      <h6><strong>Ilość</strong></h6>
                    </div>
                    <div className="col-md-4 text-center"></div>
                  </div>
                </div>
               {itemsMapped.length > 0 ? itemsMapped : empty}

              </div>
              <div className="card-footer">
                <div className="row text-center">
                  <div className="col-md-9">
                    <h4 className="text-right">Suma: <strong>{itemsMapped.length > 0 ? totalSum : 0} zł</strong></h4>
                  </div>
                  <div className="col-md-3">
                    <button type="button" className="btn btn-info btn-sm btn-block" onClick={this.emptyBasket} disabled={itemsMapped.length == 0}>
                     Kupuję i płacę
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Footer/>
        </div>
        </div>
      );
  }
}