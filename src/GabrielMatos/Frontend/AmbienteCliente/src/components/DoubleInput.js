import React from "react";
import "../css/doubleInputs.css";

export class DoubleInput extends React.Component{
    constructor(props){
        super(props)
        this.validar = this.validar.bind(this)
    }

    validar(){
        const valor = document.getElementById("rep_valor").value
        const descricao = document.getElementById("rep_desc").value

        if(valor === "" || descricao === ""){ alert("Preencha os dados corretamente") }
    }

    render(){
        return(
            <div class="row div-search">
                <div className="col-md-6">
                    <input class="search-input" id="rep_desc" type="search" placeholder={this.props.placeholder1} />
                </div>
                <div className="col-md-6">
                    <input class="search-input" id="rep_valor" type="number" placeholder={this.props.placeholder2} />
                </div>
                <div>
                    <button onClick={this.validar} className="addButton">+ Adicionar</button>
                </div>
        
            </div>)
    }
}
