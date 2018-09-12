import React, { Component } from 'react';
import axios from 'axios';
import ProductList from '../ProductList/ProductList';
import './HomePage.css';
// import Toolbar from './../Toolbar/Toolbar';
// import Footer from './../../components/Footer/Footer';

export default class HomePage extends Component {

    state = {
        products: [],
        categories: []
    }

    componentDidMount() {
        axios.get('http://localhost:9090/products')
          .then(res => {
            this.setState({
              products: res.data
            });
          })

          axios.get('http://localhost:9090/categories')
          .then(res => {
              console.log(res)
            this.setState({
              categories: res.data
            });
          })
    }

    

    render () {
        return (
          
            <div className="Content">
            <ProductList products={this.state.products} categories={this.state.categories} />  
            </div>
        
        );
    }
}