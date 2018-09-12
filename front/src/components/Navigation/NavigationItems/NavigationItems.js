import React, {Component} from 'react';
import Icon from 'react-fontawesome';
import './NavigationItems.css';
import NavigationItem from '../NavigationItem/NavigationItem';
import '../NavigationItem/NavigationItem.css';

class NavigationItems extends Component {

    clearSession(e) {
        sessionStorage.clear();
    };

    checkUserStatus() {
        let isLogged = sessionStorage.getItem('log');
        if (isLogged === "true") {
            return ( 
                    <li className = "NavigationItem" >
                    <a href = "http://localhost:9090/signOut" 
                        onClick = { 
                            this.clearSession.bind() 
                        }> 
                            < Icon className = "Icon" name = "sign-out" / > Log out 
                        </a>                
                    </li>
            );
        } else {
            return ( 
                    <li className = "NavigationItem" >
                        <a href = "http://localhost:9090/signIn" > 
                            < Icon className = "Icon" name = "sign-in" / > Log in 
                        </a>
                    </li>
            );
        }
    }

    checkBasket() {
        let isLogged = sessionStorage.getItem('log');
        if (isLogged === "true") {
            return ( 
                <NavigationItem link = "/basket" > 
                    < Icon className = "Icon" name = "shopping-basket" / > 
                </NavigationItem>  
            );
        }
    }

    render() {
        return (             
            <ul className = "NavigationItems" style={{  top: 10 }}>
                <NavigationItem link = "/" exact > 
                    < Icon className = "Icon" name = "home" / >
                </NavigationItem>
                { this.checkBasket()}
                { this.checkUserStatus()}
            </ul>
        );
    }
}


export default NavigationItems;