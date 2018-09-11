import React, { Component } from 'react';
import axios from 'axios';


export default class koszCom extends Component {
    myClick(id, e){
        axios({
          method: 'get',
          url: `http://localhost:9090/deleteproduct/${id}`,
        }).then((res) => {
            alert("usunieto");
            window.location.reload();
        }).catch((err) => {
          alert('AXIOS addProduct FAILED', err)
        });
    };
  render(){
    return(
      <div key="kosz1" className="row">
        <div key="kosz2" className="row col-md-12" >
          <h3 key="kosz2">Mój koszyk</h3>
          <table key="kosz4" className={'table table-hover'}>
            <thead key="kosz5">
            <tr key="kosz6">
              <th>Nazwa produktu </th>
              <th>Liczba sztuk</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            {this.props.items.map(item => {
                return <tr key="kosz111">
                    <td>
                      <h5 key="kosz11">{item.productName}</h5>
                    </td>
                    <td>
                    <h5 key="kosz12">{item.liczba}</h5>
                    </td>
                    <td>
                      <button key="kosz31" id={`${item.id}`} onClick={this.myClick.bind(this,item.id)} className="btn btn-danger">usuń z koszyka</button>
                    </td>
                  </tr>
                
              })}

            </tbody>
          </table>
        </div>
      </div>
    )
  }
}