import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter, Route } from 'react-router-dom';
import Basket from './containers/Basket/Basket';
import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
    <BrowserRouter>
     <div>
        <Route exact path="/" component={App}/>
        <Route path="/basket" component={Basket}/>
        </div>
    </BrowserRouter>
, document.getElementById('root'));
registerServiceWorker();
