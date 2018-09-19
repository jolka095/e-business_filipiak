import React, { Component } from 'react';
import '../../style.css'
import axios from 'axios';
import Toolbar from './../Toolbar/Toolbar';
import Footer from './../../components/Footer/Footer';
// import { Card, CardBody, CardTitle, CardSubtitle, Row } from 'reactstrap';

export default class ProductProfile extends Component {

    componentDidMount() {
        const product_id = this.props.match.params.id
        axios.get(`http://localhost:9090/product/${product_id}`)
            .then((res) => {
                console.log("RESPONSE: ", res);
                this.setState({ product: res.data[0] })
            }).catch((err) => {
                console.log(err)
            });
    }

    state = {
        product: {}
    }

    render() {
        // const id = this.state.product.id;
        const name = this.state.product.name;
        const description = this.state.product.description;
        const keyword = this.state.product.keyword;
        const price = this.state.product.price;
        const url = this.state.product.imageUrl

        return (
            <div className="container">
                <Toolbar />
                <div className="main">
                    <br /><br /><br /><br />
                    <a href="/" className="btn btn-sm"> <strong> Go to all products </strong> </a>
                    <hr />
                    <div>
                        <div className="row">
                            <div className="col-md-3"></div>
                            <div className="col-md-3">
                                <img className="img-fluid img-responsive img-rounded" style={{ width: '250px', height: '250px' }} src={url} alt={name} />
                            </div>
                            <div className="card col-md-4">
                                <ul className="list-group list-group-flush">
                                    <   li className="list-group-item"><h2><strong>{name}</strong></h2></li>
                                    <li className="list-group-item">{description}</li>
                                    <li className="list-group-item">Keywords: <span className="badge badge-dark badge-pill">{keyword}</span></li>
                                    <li className="list-group-item"><strong>Price: <h3> {price} $ </h3></strong></li>
                                </ul>
                            </div>
                            <div className="col-md-2"></div>
                        </div>
                    </div>
                    <br />
                    <form action="/car_profile/<%= car.id %>/reserve/2" method="POST" name="reservationForm">
                        {/* <label for="start_date">Od: </label>
                        <input type="date" name="start_date" id="start_date" min="<%= date %>" /> */}

                        <button type="submit" className="btn btn-info btn-lg"> Add review </button>
                    </form>

                </div>
                <Footer />
            </div>
        )
    }
}