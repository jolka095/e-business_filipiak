import React, { Component, Fragment } from 'react';
import axios from 'axios';
import Kosz from "../Components/koszCom"
import Header from "../Components/header"

export default class koszyk extends Component {
  constructor() {
    super();
    this.state = {
      items: []
    }
    var Uid = sessionStorage.getItem('userID');
    axios({
      method: 'get',
      url: `http://localhost:9090/koszyk/${Uid}`
    }).then((res) => {
      this.setState({items: res.data})
    }).catch((err) => {
      console.log('AXIOS addProduct FAILED', err)
    });
  }
  
  render(){
    return(
      <Fragment>
        <Header/>
        <Kosz items={this.state.items}/>
      </Fragment>
    )
  }
}