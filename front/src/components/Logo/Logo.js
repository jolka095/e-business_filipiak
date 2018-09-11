import React from 'react';

import dogLogo from '../assets/images/dog.png';
import './Logo.css';

const logo = (props) => (
    <div className="Logo" style={{height: props.height}}>
        <img src={dogLogo} alt="Happy Paws" />
    </div>
);

export default logo;