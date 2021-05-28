import React , { useState } from 'react';
import './styles.css';
import PessoaComponent from '../Pessoa'
import CadastroPessoa from '../Formularios/CadastroPessoa'

function BodyComponent() {
    const [buttonPopup, setButtonPopup] = useState(false);

    return(
        <div className="body">
            <div className="body__header">
                <h2 className="body__title">Pessoas</h2>

                <button className="body__register" onClick={() => setButtonPopup(true)}>Cadastrar</button>
            </div>

            <CadastroPessoa trigger={buttonPopup} setTrigger={setButtonPopup} />
 
            <PessoaComponent />
        </div>
    )
}

export default BodyComponent;