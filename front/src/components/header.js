import React, { Component } from 'react';

export default class header extends Component {
  myClick2(e){
    sessionStorage.clear();
};
  checkAuth(){
    var obj1 = sessionStorage.getItem('log');
    if(obj1 === "true") {
      return (
        
        <div >
            <a className="nav-link " onClick={this.myClick2.bind()} href="http://localhost:9090/signOut">
                Wyloguj
            </a>
        </div>)
    }else{
      return (
        <a className="nav-link " href="http://localhost:9090/signIn">
            Zaloguj się 
        </a>
      )
    }
  }


  render(){
    return(
      <div>
          <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a className="navbar-brand" href="/">Sklep</a>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarCollapse">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item">
            <a className="nav-link" href="koszyk">Koszyk</a>
          </li>
          <li className="nav-item">
            <a href="#submenu2" data-toggle="collapse" className="nav-link ">Dodaj</a>
            <ul id="submenu2" className="list-unstyled collapse">
                <li><a className="nav-link " href="addCategory">Kategorie</a></li>
                <li><a className="nav-link " href="addProduct">Produkt</a></li>
            </ul>
        </li>
        </ul>
        <div className="navbar-nav">
          {this.checkAuth()}
        </div>
      </div>
    </nav>
      </div>
    )
  }
}