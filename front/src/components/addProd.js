import React, { Component } from 'react';
import axios from 'axios';

export default class addProd extends Component {
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
    
      }
    
      state = {
        categoryList : [],
        response : ''
      }

      handleSubmit(event) {
        event.preventDefault();
        const Proddata = new FormData(event.target);

        axios({
            method: 'post',
            url: 'http://localhost:9090/addproduct',
            data: Proddata
          }).then((res) => {
              alert('dodano produkt');
          }).catch((err) => {
            console.log('AXIOS addProduct FAILED', err)
          });
      }

  
    render(){
        const categories = this.state.categoryList;
        return(
          <div className="container content">
            <div className="row justify-content-md-center">
                <div className="col-lg-6 col-xl-4">
                    <div id="addProduct-panel" className="card customCard mb-5" style={{marginTop: 70 + 'px'}}>
                        <div className="card-body">
                            <h3 className="text-center mb-3">Dodaj nowy Produkt</h3>
                            <form onSubmit={this.handleSubmit}>
                              <div className="form-group">
                                <label>Nazwa Produktu: </label>
                                <input className="form-control" type="text" id="productName" name="name" placeholder="Podaj nazwę produktu" required/>
                              </div>
                              <div className="form-group">
                                <label>Opis Produktu: </label>
                                <textarea className="form-control" type="text" id="productDesc" name="description" placeholder="Podaj opis produktu" required/>
                              </div>
                              <div className="form-group">
                                <label>Słowa kluczowe: </label>
                                <input className="form-control" type="text" id="productKayWord" name="kayword" placeholder="Podaj słowa kluczowe" required/>
                              </div>
                              <div className="form-group">
                                <label>Wybierz kategorie: </label>
                                <select className="form-control" id="productCategory" name="category" required>
                                {
                                    categories.map(cat => {
                                    return <option value={cat.id} key={cat.id}>{cat.name}</option>
                                    })
                                }
                                </select>
                              </div>
    
    
                              <button type="submit" className="btn btn-block btn-success">Dodaj</button> 
                            </form>
                            <span>{this.state.response}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        )
      }
    }