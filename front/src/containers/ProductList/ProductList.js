import React, { Component } from 'react';
import Product from '../Product/Product'
import './ProductList.css'

import '../../style.css'

export default class ProductList extends Component {

    state = {
        activeCategory: 6,
        productList: []
    }

    setCategory = (categoryId) => {
        this.setState({activeCategory: categoryId});
    };

    filterProductsByCategory () {
        if(this.state.activeCategory === 6) {
            return (this.props.products.map(function (product, index) {
            return <Product product={product} key={index} />}))
        }
        return (this.props.products.filter((product) => product.category === this.state.activeCategory).map(function (product, index) {
            return <Product product={product} key={index} />
          }))
    };

    renderCategory() {
        return (
            this.props.categories.map((category, index) => {
            return (
            <div key={index} className={this.state.activeCategory === category.id ? "category active" : "category"}
                        onClick={() => this.setCategory(category.id)}>
                {category.name}
            </div>
            );
        })
    )
    };

    render() {
        return (
        <div className="row extra-bottom-margin">
         <div className="container">
            <div className="row">
                <div className="categories-wrapper">
                {this.renderCategory()}
                </div>
            </div>
        </div> 
            {this.filterProductsByCategory()} 
        </div>
        );
    }     
}
