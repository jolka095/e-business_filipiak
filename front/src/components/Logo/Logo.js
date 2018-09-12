import React from 'react';
import './Logo.css';

const logo = (props) => (
    <div className="Logo" style={{height: props.height}}>
        <img src={"http://free-web-tools.com/wp-content/uploads/2015/08/free-logo-flower.png"} alt="Alegroo" />
    </div>
);

export default logo;