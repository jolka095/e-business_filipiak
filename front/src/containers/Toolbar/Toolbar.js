import React from 'react';
import './Toolbar.css'
import Logo from './../../components/Logo/Logo';
import NavigationItems from './../../components/Navigation/NavigationItems/NavigationItems';

const toolbar = (props) => (
    <header className="Toolbar">
        <div className="row">
            <div className="Logo">
                <Logo />
            </div>
            <span className="Title">Alegroo</span>
        </div>
        <nav className="DesktopOnly">
            <NavigationItems />
        </nav>
    </header>
);

export default toolbar;