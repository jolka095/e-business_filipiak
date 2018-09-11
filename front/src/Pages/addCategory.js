import React, { Component, Fragment } from 'react';


import Header from "../Components/header"
import Cat from "../Components/addCat"

export default class addCategory extends Component {

  
  
  render(){
    return(
      <Fragment>
            <Header/>
            <Cat/>
      </Fragment>
    )
  }
}