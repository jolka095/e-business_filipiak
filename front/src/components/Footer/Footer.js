import React, { Component } from 'react';

export default class Footer extends Component {
    render() {
        return (
            <div className={'my-3 text-center footer'}>

                <div className="row">

                    <div className="col-md-6 " id="info3">
                        <img className="mx-auto d-block" src="http://free-web-tools.com/wp-content/uploads/2015/08/free-logo-flower.png" alt="Logo" width="60" />
                        <p><strong> &copy; Alegroo 2018 </strong></p>
                    </div>

                    <div className="col-md-6 text-left" id="info2">
                        <ul className="list-unstyled">
                            <li>
                                <a href="/termsofuse" >Terms of use</a>
                            </li>
                            <li>
                                <a href="/policy">Privacy policy</a>
                            </li>
                            <li>
                                <a href="/contact">Contact</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}