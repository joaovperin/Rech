import React , { useState, useEffect } from 'react';
import api from '../../services/api';
import './styles.css';

function PessoaComponent() {
    const [pessoas, setPessoas] = useState([]);

    useEffect(() => {
        async function carregarPessoas() {
            const response = await api.get('/pessoas')
            setPessoas(response.data)
            
            return response
        }
        carregarPessoas()

    }, [pessoas]);

    function deletePessoa(id) {
        api.delete(`/pessoa/${id}`)
    };

    return (
        <div className="content">
            {     
            pessoas.map(pessoa => 
                <article className="card" key = {pessoa.id}>
                    <div className="card__header">
                        <img className="card__image" src="logo.png" alt="Logomarca" />
                    </div>
               
                    <div className="card__circle">
                        <p>{pessoa.id}</p>
                    </div>
                        
                    <div className="card__body">
                        <div className="card__content">
                            <h4 className="content__title">{pessoa.nome}</h4>
                            <div className="content__text">
                                <p><span>CPF:</span> {pessoa.cpf}</p>
                                <p><span>Apartamento:</span> {pessoa.apartamento}</p>
                                <p><span>Nascimento:</span> {pessoa.dataNascimento}</p>
                                <p><span>Telefone:</span> {pessoa.telefone}</p>
                            </div>
                        </div>

                        <div className="card__btn">
                            <button className="btn">Editar</button>
                            <button className="btn btn--red" onClick={(e) => deletePessoa(pessoa.id)}>Apagar</button>
                        </div>
                        
                        <div className="card__btnTwo">
                            <button className="btn--large">Ver carros em vagas</button>
                        </div>
                    </div>
                </article> 
                ) 
            }
        </div>
    )
}

export default PessoaComponent;