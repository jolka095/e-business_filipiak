import React, { Component, Fragment } from 'react';
import axios from 'axios';

import Product from "../Components/Product"
import Header from "../Components/header"

export default class Home extends Component {
  constructor(){
    super();

    axios({
      method: 'get',
      url: 'http://localhost:9090/categorys'
    }).then((res) => {
      this.setState({categoryList: res.data})
    }).catch((err) => {
      console.log('AXIOS addProduct FAILED', err)
    });

    axios({
      method: 'get',
      url: 'http://localhost:9090/products'
    }).then((res) => {
      this.setState({productList: res.data})
    }).catch((err) => {
      console.log('AXIOS addProduct FAILED', err)
    });
  }
  async User(){
    try {

        const {data: response} = await axios.get('/user');
        sessionStorage.setItem('log',  response.log);
        sessionStorage.setItem('userID',  response.userID);
        sessionStorage.setItem('email', response.email);
        sessionStorage.setItem('fullName',  response.fullName);
       
    } catch (e) {
        console.error(e);
    }
};

componentWillMount(){
  this.User();
}

  state = {
    categoryList : [],
    productList : []
  }
  
  render(){
    return(
      <Fragment>
        <Header/>
        <Product productList={this.state.productList} categoryList = {this.state.categoryList}/>
      </Fragment>
    )
  }
}


