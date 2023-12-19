import { Outlet, Link } from "react-router-dom";
import "./css/nav.css";
import React from "react";
import {MenuLateral} from "../src/components/MenuLateral"

export class Layout extends React.Component{

  constructor(){
    super();
    this.state = {active: false};
  }

  onClickLink(e){
    let itens = document.querySelectorAll("[id='nav-item']");
    for(var i = 0; i < itens.length; i++){
      itens[i].classList.remove("active");
    }
    e.target.classList.add("active");
  }


  render(){
    return (
      <>
         <MenuLateral />
        <nav id="top-navbar">
          <ul>
          <div className="logo">
            <div className="overlap-group">
              <div className="text-wrapper">AUTOMECH</div>
              <img
                className="img"
                alt="Img"
                src="https://c.animaapp.com/yFUKwoyF/img/eszacrc99cevlnkuctzwc3zlkiushvdjdts5chlwmynsaoctowlvsbnanig5vmzg@2x.png"
              />
            </div>
          </div>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/Home">Home</Link>
            </li>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/repair">Sobre nós</Link>
            </li>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/repair">Contato</Link>
            </li>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/Feedback">Feedback</Link>
            </li>
  
            <div className="btnGroup">
                  <button className="cadastroCliente">
                      <Link to="/cadastro">
                          <div className="div">Cadastre-se</div>
                      </Link>
                  </button>
  
                  <button className="loginCliente">
                  <Link to="/login">
                          <div className="div">Login</div>
                      </Link>
                  </button>
              </div>
              
          </ul>
        </nav>
       
        <Outlet />
      </>
    )
  }  
};