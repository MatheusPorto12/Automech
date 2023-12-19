import React from "react";
import "./style.css";
import { Table } from 'react-bootstrap';

export const TableResultReparos = () => {
    return (
        <div className="wrap-table">
            <Table id="tableReparos" striped bordered hover>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Reparo</th>
                    <th>Descrição</th>
                    <th>Prazo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>1</td>
                    <td>Suspensão</td>
                    <td>Trocar coilover</td>
                    <td>08/11/2023</td>
                    </tr>
                    <tr>
                    <td>2</td>
                    <td>Motor</td>
                    <td>Instalar turbo</td>
                    <td>09/11/2023</td>
                    </tr>
                </tbody>
            </Table>

            <div className="btnGroup">
                <button className="infoCliente">
                        <div className="div">Informar Cliente</div>
                </button>

                <button className="fimReparos">
                        <div className="div">Finalizar Reparos</div>
                </button>
            </div>

        </div>
    );
};
