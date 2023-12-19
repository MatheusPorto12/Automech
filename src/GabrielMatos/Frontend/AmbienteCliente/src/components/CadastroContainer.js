import React from 'react';
import '../css/cadastro.css'
import '../css/generalStyle.css'
import { LoginType } from "./LoginType";

export class CadastroContainer extends React.Component{
    
    constructor(){
        super()
        this.state = {validado : false}
        this.validarCadastro = this.validarCadastro.bind(this)
        this.changeState = this.changeState.bind(this)
    }

    validarCadastro(){
        const nome = document.getElementById("caduser_nome").value
        const cpf = document.getElementById("caduser_cpf").value
        const email = document.getElementById("caduser_email").value
        const endereco = document.getElementById("caduser_endereco").value
        // const numero = document.getElementById("caduser_numero").value
        // const senha = document.getElementById("caduser_senha").value
        // const repetesenha = document.getElementById("caduser_repetesenha").value

        if(nome === "" || cpf === ""|| email === "" ||endereco === "" ){
            alert("Falhou")
        }
        else{
            alert("Cadastrou")
            window.location.href = "/login"
        }
    }

    changeState(){

    }

    render (){
        return(
        <div className="container">
            <div id='login' className="row">
                <h1>CADASTRO</h1>
                <div className="col-md-12 col-xs-6">
                    <div className="col-md-12 col-xs-6 mb-3 mt-5 text-center">
                        <img width="100px"/>
                    </div>
                    <div className="col-md-12 col-xs-6 mb-3 text-center">
                        <input className="infoFields" type="text" name="" id="caduser_nome" placeholder="Nome Completo" required/>
                    </div>
                    <div className="col-md-12 col-xs-6 mb-3 text-center">
                        <input className="infoFields" type="number" id="caduser_cpf" placeholder="CPF" required/>
                    </div>
                    <div className="col-md-12 col-xs-6 mb-3 text-center">
                        <input className="infoFields" type="email" name="" id="caduser_email" placeholder="E-mail" required/>
                    </div>

                    <div>
                        <h3>Endereço</h3>
                        <div className="col-md-12 col-xs-6 mb-3 text-center">
                            <input className="infoFields" type="text" name="" id="caduser_endereco" placeholder="Endereço" required/>
                        </div>
                        <div className="col-md-12 col-xs-6 mb-3 text-center">
                            <input className="infoFields" type="number" name="" id="caduser_numero" placeholder="Numero" required/>
                        </div>
                    </div>

                    <div>
                        <h3>Confirmação</h3>
                        <div className="col-md-12 col-xs-6 mb-3 text-center">
                            <input minLength={8} className="infoFields" type="password" name="" id="caduser_senha" placeholder="Senha" required/>
                        </div>
                        <div className="col-md-12 col-xs-6 mb-3 text-center">
                            <input minLength={8} className="infoFields" type="password" name="" id="caduser_repetesenha" placeholder="Confirmar Senha" required/>
                        </div>
                    </div>

                    <input type="" id="id_logado" hidden/>

                    <div className="col-md-12 col-xs-6 mb-3 text-center">
                        <button onClick={this.validarCadastro} type="button" className="btn">Cadastrar</button>
                    </div>

                    <div id='jaTemConta' className="col-md-12 col-xs-6 text-center">
                            <a href="/login">Ja tenho uma conta cadastrada!</a>
                    </div>

                    <div className="col-md-12 col-xs-6 mb-3 text-center">
                        <p>________________________ ou ________________________</p>
                    </div>

                    <LoginType className="loginFields" type="button" fa_icon="fa-brands fa-facebook" text="Continuar com Facebook"></LoginType>
                    <LoginType className="loginFields" type="button" fa_icon="fa-brands fa-apple" text="Continuar com Apple"></LoginType>
                    <LoginType className="loginFields" type="button" fa_icon="fa-brands fa-google" text="Continuar com Google"></LoginType>
                </div>
            </div>
        </div>
    )};
}

