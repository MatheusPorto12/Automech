import '../css/generalStyle.css'
import '../css/menu.css'
import { MenuLateral } from './MenuLateral';

export function AlterarCadastro(){
    return(
        <div>
           < MenuLateral />
            <div>
                <section>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3 col-xs-6"></div>
                            <div class="col-md-7 col-xs-6">
                                <div class="row text-center mb-3">
                                    <span id="nomeLogado">Mathias</span>
                                </div>
                                <div class="row">
                                    <h2>Dados Pessoais</h2>
                                    <div class="col-md-4 col-xs-6 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="caduser_cpf" placeholder="CPF" required/>
                                    </div>
                                    <div class="col-md-8 col-xs-6 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="caduser_nome" placeholder="Nome Completo" required/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 col-xs-3 mb-3 text-left">
                                        <input class="editFields" type="email" name="" id="caduser_email" placeholder="E-mail" required/>
                                    </div>
                                    <div class="col-md-3 col-xs-3 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="caduser_senha" placeholder="Senha" required/>
                                    </div>
                                    <div class="col-md-3 col-xs-3 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="caduser_conSenha" placeholder="Confirmar senha" required/>
                                    </div>
                                </div>

                                <div class="row">
                                    <h2>Endereço</h2>
                                    <div class="col-md-9 col-xs-2 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="cadend_rua" placeholder="Logradouro" required/>
                                    </div>
                                    <div class="col-md-3 col-xs-1 mb-3 text-left">
                                        <input class="editFields" type="number" name="" id="cadend_numero" placeholder="Numero" required/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-4 col-xs-2 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="cadend_bairro" placeholder="Bairro" required/>
                                    </div>
                                    <div class="col-md-4 col-xs-1 mb-3 text-left">
                                        <input class="editFields" type="text" name="" id="cadend_complemento" placeholder="Complemento" required/>
                                    </div>
                                    <div class="col-md-4 col-xs-1 mb-3 text-left">
                                        <input class="editFields" type="number" name="" id="cadend_cep" placeholder="CEP" required/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 col-xs-6 text-center">
                                        <div class="col-md-12 col-xs-6 text-center" id="buttonFields">
                                            <input type="button" value="Salvar" id="caduser_salvar" class="btn btn-dark buttonFields mb-3"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2 col-xs-6"></div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    );
}