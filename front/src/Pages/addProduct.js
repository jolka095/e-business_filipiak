import React, { Component, Fragment } from 'react';

import Header from "../Components/header"
import Add from "../Components/addProd"

export default class addProduct extends Component {

  
    render(){
        return(
          <Fragment>
            <Header/>
            <Add/>
          </Fragment>
        )
      }
    }