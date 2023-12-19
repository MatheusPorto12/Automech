import React from "react";
import "./style.css";
import { Table } from 'react-bootstrap';

export const TableResult = () => {
    return (
        <div class="wrap-table">
            <Table id="tableOficinas" striped bordered hover>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Oficina</th>
                    <th>Descrição</th>
                    <th>Funcionamento</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>1</td>
                    <td>AutoMech</td>
                    <td>Reparos gerais</td>
                    <td>Segunda a Sexta 08:00 - 18:00</td>
                    </tr>
                    <tr>
                    <td>2</td>
                    <td>Garage 96</td>
                    <td>Preparação Automotiva</td>
                    <td>Segunda a Sexta 08:00 - 18:00</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
};
