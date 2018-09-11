import React, { Component } from 'react';
import axios from 'axios';

export default class addCom extends Component {
  constructor(props){
    super(props);
    
    axios({
        method: 'get',
        url: 'http://localhost:9090/opinion/'+ this.props.id
      }).then((res) => {
        this.setState({comentList: res.data})
      }).catch((err) => {
        console.log('AXIOS addProduct FAILED', err)
      });


  }

  state = {
    comentList : []
  }

  handleSubmit(event) {
    event.preventDefault();
    const Proddata = new FormData(event.target);
    axios({
        method: 'post',
        url: 'http://localhost:9090/addopinion',
        data: Proddata
      }).then((res) => {
        window.location.reload();
      }).catch((err) => {
        console.log('AXIOS addProduct FAILED', err)
      });
  }

  
  render(){
    const coment = this.state.comentList;
    return(
      <div className="container text-center">
        <div className = "row">
        {
           coment.map(com => {
             return <p className="col-md-12" key={com.id}>{com.opin}</p>
            })
           }
        </div>
        <div className="row">
        <div className="col-md-12">
                    <div id="addOpinion-panel" className="card customCard mb-12" style={{marginTop: 70 + 'px'}}>
                        <div className="card-body">
                            <h3 className="text-center mb-3">Dodaj nowy Komentarz</h3>
                            <form onSubmit={this.handleSubmit}>
                              <div className="form-group">
                                <textarea className="form-control" type="text" id="productDesc" name="opin" placeholder="Dodaj nowy komentarz" required/>
                              </div>
                              <div >
                              <select className="form-control" id="productCategory" name="product" required><option value={this.props.id} >Product id = {this.props.id}</option></select>
                              </div>
                              
                              <button type="submit" className="btn btn-block btn-success" style={{marginTop: 10 + 'px'}}>Dodaj</button> 
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


