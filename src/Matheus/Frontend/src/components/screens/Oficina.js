import '../../App.css';
import '../../css/style.css'
import '../../css/detalhes.css'
import React, { useState } from 'react';
import { useLocation } from "react-router-dom";

//Imports Chakra
import { Button, ButtonGroup } from '@chakra-ui/react'
import { Grid, GridItem } from '@chakra-ui/react'

import { ClienteValidado } from "../EntidadesValidadas/clienteValidado"

export function OficinaScreen() {

    const location = useLocation();
    const dadosOficinas = location.state.idOficina;
    console.log(parseInt(dadosOficinas))
    
    getDadosOficina(parseInt(dadosOficinas))
    
    async function getDadosOficina(id){

      let url = `http://localhost:8080/Oficina/Detalhes/${id}`
      const response = await fetch(url, { method: 'GET' })
      var data = await response.json();

      console.log(data)

      document.getElementById('nomeOficina').innerHTML = data.nome
      document.getElementById('descricaoOficina').innerHTML = data.descricao
      document.getElementById('horarioFuncionamento').innerHTML = data.horarioFuncionamento
      document.getElementById('enderecoOficina').innerHTML = data.endereco
    }
    return (
      <>
        <ClienteValidado/>
        <div className='normalBackground'  id='wrapDados'>
            <Grid id='containerDadosOficina'
              templateAreas={`"header header"
                              "nav main"
                              "nav footer"`}
              gridTemplateRows={'50px 1fr 30px'}
              gridTemplateColumns={'30% 1fr'}
              gap='1'
              color='blackAlpha.700'
              fontWeight='bold'
              >
              <GridItem pl='2' area={'header'}>
                <h3 id='nomeOficina'></h3>
              </GridItem>

              <GridItem pl='2' area={'nav'}>
                <div id='infoOficina'>
                  <h4>Funcionamento:</h4>
                  <p id='horarioFuncionamento'></p>

                  <h4>Endereço:</h4>
                  <p id='enderecoOficina'></p>
                </div>
              </GridItem>

              <GridItem pl='2' area={'main'}>
                <p id='descricaoOficina'></p>
              </GridItem>
              
              <GridItem pl='2' area={'footer'}>
                <Button color='#f7b925' backgroundColor='#575756' variant='ghost'>Realize seu orçamento</Button>
              </GridItem>
            </Grid>
        </div>
      </>
    );
  }