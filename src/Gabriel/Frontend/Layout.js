import { Outlet, Link } from "react-router-dom";
import "./layout.css";
import React from "react";

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
              <Link id="nav-item" to="">Home</Link>
            </li>
            <li>
              <Link id="nav-item" to="">Serviços</Link>
            </li>
            <li>
              <Link id="nav-item" to="">Orçamentos</Link>
            </li>
            <li>
              <Link id="nav-item" to="">Feedback</Link>
            </li>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/Oficina">Pesquisar</Link>
            </li>
            <li>
              <Link onClick={this.onClickLink} id="nav-item" to="/Reparo">Reparos</Link>
            </li>
  
            <div className="btnGroup">
                  <button className="cadastroCliente">
                          <div className="div">Cadastre-se</div>
                  </button>
  
                  <button className="loginCliente">
                          <div className="div">Login</div>
                  </button>
              </div>
            
          </ul>
        </nav>
  
        <Outlet />
      </>
    )
  }  
};

