import React, { Component } from 'react';
import axios from 'axios';

export default class addCat extends Component {

  handleSubmit(event) {
    event.preventDefault();
    const Proddata = new FormData(event.target);

    axios({
        method: 'post',
        url: 'http://localhost:9090/addcategory',
        data: Proddata
      }).then((res) => {
          
        
      }).catch((err) => {
        console.log('AXIOS addProduct FAILED', err)
      });
  }
  
  render(){
    return(
      <div className="container content">
        <div className="row justify-content-md-center">
            <div className="col-lg-6 col-xl-4">
                <div id="addCategory-panel" className="card customCard mb-5" style={{marginTop: 70 + 'px'}}>
                    <div className="card-body">
                        <h3 className="text-center mb-3">Dodaj nową kategorie</h3>
                        <form onSubmit={this.handleSubmit}>
                          <div className="form-group">
                            <label>Nazwa kategorii: </label>
                            <input className="form-control" type="text" id="categoryName" name="name" placeholder="Podaj nazwę kategorii"/>
                          </div>

                          <button type="submit" className="btn btn-block btn-success">Dodaj</button> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    )
  }
}