import React from 'react';
import './styles.css';

function HeaderComponent() {
    return (
        <div className="header">
            <div className="header__start">
                <img className="header__icon" src="logo.png" alt="Logomarca" />
                <input className="header__search" type="search" placeholder="Buscar Pessoa" />
            </div>
    
            <nav className="header__end">
                <button href="" className="header__nav">Pessoas</button>
                <button href="" className="header__nav">Veículos</button>
            </nav>
        </div>
    )
}

export default HeaderComponent;
