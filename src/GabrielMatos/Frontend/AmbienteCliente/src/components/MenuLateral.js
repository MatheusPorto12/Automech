import '../css/generalStyle.css'
import '../css/menu.css'
import React, { useState } from 'react';

export function MenuLateral() {

    const [showSubmenu, setShowSubmenu] = useState(false);


    return (
        <div>
            <nav class="menu-lateral">
                <ul>
                    <li class="itenMenu">
                        <a href='/Home'>
                            <span class="iconMenu"><i class="fa-solid fa-house"></i></span>
                            <span class="textMenu">Home</span>
                        </a>
                    </li>
                    <li class="itenMenu">
                        <a href="/alterarCadastro">
                            <span class="iconMenu"><i class="fa-regular fa-pen-to-square"></i></span>
                            <span class="textMenu">Editar Perfil</span>
                        </a>
                    </li>
                    <li class="itenMenu">
                        <a href="/feedbaak">
                            <span class="iconMenu"><i class="fa-solid fa-users-viewfinder"></i></span>
                            <span class="textMenu">Visualizar Cadastros</span>
                        </a>
                    </li>
                    <li class="itenMenu">
                        <a onClick={() => setShowSubmenu(!showSubmenu)} style={{ color: 'white' }}>
                            <span class="iconMenu"><i class="fa-regular fa-user"></i></span>
                            <span class="textMenu">Área do Cliente</span>
                            <span>{showSubmenu ? <i class="fa-solid fa-caret-up"></i> : <i class="fa-solid fa-caret-down"></i>}</span>
                        </a>
                        {showSubmenu && (
                            <ul>
                                <li><a href="/editarCadastro">Meus Orçamentos</a></li>
                                <li><a href="/editarNome">Meus Serviços</a></li>
                                <li><a href="/Feedback">Feedback</a></li>
                                <li><a href="/editarPerfil">Pesquisa oficina</a></li>

                            </ul>
                        )}
                    </li>
                    <li class="itenMenu">
                        <a href="/Feedback">
                            <span class="iconMenu"><i class="fa-solid fa-wrench"></i></span>
                            <span class="textMenu">Feedback</span>
                        </a>
                    </li>
                    <li class="itenMenu" id="caduser_logout">
                        <a href="/login">
                            <span class="iconMenu"><i class="fa-solid fa-arrow-right-from-bracket"></i></span>
                            <span class="textMenu">Logout</span>
                        </a>
                    </li>
                    <li class="itenMenu" id="caduser_excluir">
                        <a href="/login">
                            <span class="iconMenu"><i class="fa-solid fa-trash"></i></span>
                            <span class="textMenu">Excluir Cadastro</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    );
}