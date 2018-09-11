import React, { Component } from 'react';
import axios from 'axios';


export default class Product extends Component {
  state = {
    filter : null
  }
  
    myClick(id,name, e){
        var formData = new FormData();
        var Uid = sessionStorage.getItem('userID').toString();
        console.log(Uid);
        formData.append('user', Uid);
        formData.append('product', id);
        formData.append('productName',name)
        formData.append('liczba', 1);
        console.log(Uid);
        
        axios({
            method: 'post',
            url: 'http://localhost:9090/addproductkoszyk',
            data: formData
          }).then((res) => {
              alert("dodano produkt do koszyka");
          }).catch((err) => {
            alert('AXIOS addProduct FAILED', err)
          });
    };


  clickFilter(id,e){
    const allProducts = this.props.productList;
      
      let Products = null;
      if (id === 'all') {
          Products = allProducts;
      } else {
          Products = allProducts.filter(p => p.category === id);
          
      }

      this.setState({filter: Products});
      
    }

    category(){
      const categorys = this.props.categoryList;
      return(
        <div className="d-flex align-items-stretch" style={{marginRight: 35+"px"}}>
        <div className="sidebar bg-dark">
            <ul className="list-unstyled">
            <li><a href  onClick={this.clickFilter.bind(this,"all")}> Wszystkie </a></li>
          {
            categorys.map(cat => {
            return <li><a  href key={cat.id} onClick={this.clickFilter.bind(this,cat.id)}> {cat.name}</a></li>
            })
          }
         </ul>
        </div>
    </div>
    )
    }

    check(){
      var obj1 = sessionStorage.getItem('log');
      var products = null;
      if(this.state.filter){
        products = this.state.filter;
      }else{
        products = this.props.productList;
      }


      if(obj1 === "true") {
        return(
          <div className="row">
              {
                products.map(prod => {
                return <div key={prod.id} className="card text-center" style={{width : 20 + "rem", marginLeft: 35+"px", marginTop: 5+"px"}}>
                <div className="card-header">{prod.name}</div>
                <div className="card-body">
                  <h5 className="card-title">{prod.kayword}</h5>
                  <p className="card-text"><pre>{prod.description}</pre></p>
                </div>
                <div className='wrapper text-center'>
                <div className="btn-group " role="group" aria-label="Basic example">
                  <a type="button" id={`${prod.id}`} onClick={this.myClick.bind(this,prod.id,prod.name)} className="btn btn-success">Dodaj do koszyka</a>
                  <a type="button" href={`/komentarze/${prod.id}`} className="btn btn-secondary">Komentarze</a>
                </div>
              </div>
              </div>
                })
              }
              </div>
        )
      }else{
        return(
         
            <div className = "row">
              {
                products.map(prod => {
                return <div key={prod.id} className="card text-center" style={{width : 22 + "rem", marginLeft: 5+"px", marginTop: 5+"px"}}>
                <div className="card-header">{prod.name}</div>
                <div className="card-body">
                  <h5 className="card-title">{prod.kayword}</h5>
                  <p className="card-text">{prod.description}</p>
                </div>
                <div className='wrapper text-center'>
                <div className="btn-group " role="group" aria-label="Basic example">
                  <a type="button" href={`/komentarze/${prod.id}`} className="btn btn-secondary">Komentarze</a>
                </div>
              </div>
              </div>
                })
              }
              </div>
        )
      }
    }

  render(){
    return(
      
      <div className="container">
          {this.category()}
          {this.check()}
      </div>
    )
    
  }
}


