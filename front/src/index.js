import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter, Route } from 'react-router-dom';
import Basket from './containers/Basket/Basket';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductProfile from "./containers/ProductProfile/ProductProfile"

ReactDOM.render(
    <BrowserRouter>
        <div>
            <Route exact path="/" component={App} />
            <Route path="/basket" component={Basket} />
            <Route path="/product/:id" component={ProductProfile} />
        </div>
    </BrowserRouter>
    , document.getElementById('root'));

registerServiceWorker();