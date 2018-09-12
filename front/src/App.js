import React, { Component } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import HomePage from './containers/HomePage/HomePage';
// import Basket from './containers/Basket/Basket';
import Footer from './components/Footer/Footer';
import Toolbar from './containers/Toolbar/Toolbar';
import axios from 'axios';
import { Button } from 'reactstrap';

class App extends Component {

  constructor(){
    super();

    axios({
      method: 'get',
      url: 'http://localhost:9090/categories'
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

  render() {
    return (
        <div className="App">
          <div className="container">
            <Toolbar/>
            <HomePage/>
            <Footer/>
          </div>  
        </div>
    );
  }
}

export default App;
