import React, { useState } from 'react';
import './styles.css'
import api from '../../../services/api'

function CadastroPessoa(props) {
    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [apartamento, setApartamento] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const [telefone, setTelefone] = useState('');

    async function handleSubmit() {
        const data = {
            nome: nome, 
            cpf: cpf,
            apartamento: apartamento, 
            dataNascimento: dataNascimento, 
            telefone: telefone}

            const response = await api.post('/pessoa', data);

            if(response.status === 200) {
                alert('Pessoa cadastrada com sucesso!')
            }
            else {
                alert('Erro ao cadastrar, tente novamente!')
            }
    }

    return ( props.trigger ) ? (
        <div className="form">
            <h1 className="form__title">Cadastrar Pessoa</h1>
            <div className="form__org">
                <label className="form--block">Nome: </label>
                <input className="form--input" type="text" id="nome" name="nome" value={nome} onChange={e => setNome(e.target.value)}/>
            </div>

            <div className="form__org">
                <label className="form--block">Cpf: </label>
                <input className="form--input" type="text" id="cpf" name="cpf" value={cpf} onChange={e => setCpf(e.target.value)}/>
            </div>

            <div className="form__org">
                <label className="form--block">Apartamento: </label>
                <input className="form--input" type="number" id="apartamento" name="apartamento" value={apartamento} onChange={e => setApartamento(e.target.value)}/>
            </div>

            <div className="form__org">
                <label className="form--block">Data de Nascimento (dd/mm/aaaa): </label>
                <input className="form--input" type="text" id="born" name="born" value={dataNascimento} onChange={e => setDataNascimento(e.target.value)}/>
            </div>

            <div className="form__org">
                <label className="form--block">Telefone: </label>
                <input className="form--input" type="text" id="number" name="number" value={telefone} onChange={e => setTelefone(e.target.value)}/>
            </div>

            <div>
                <button className="form__btn" onClick={handleSubmit}>Enviar</button>
                <button className="form__btn btn--red" onClick={() => props.setTrigger(false)}>Fechar</button>
            </div>
        </div> 
    ) : "";
}

export default CadastroPessoa;
