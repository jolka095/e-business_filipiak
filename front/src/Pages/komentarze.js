import React, { Component,Fragment } from 'react';

import Header from "../Components/header"
import Com from "../Components/addCom"

export default class Komentarze extends Component {
  
  render(){
    return(
      <Fragment>
            <Header/>
            <Com id={this.props.match.params.id}/>
      </Fragment>
    )
  }
}


