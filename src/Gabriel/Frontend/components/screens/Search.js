import '../../App.css';
import { SearchBar } from '../search/search';
import { TableResult } from '../tableResult/tableResult';
import '../../css/search.css'
import '../../css/style.css'
import React, { useState } from 'react';

export function SearchScreen() {

  const [busca, setBusca] = useState('');

  function handleInputChange(event) {
    setBusca(event.target.value);
  }

  return (
    
    <div>
    <SearchBar busca={busca} onInputChange={handleInputChange}></SearchBar>
    <TableResult busca={busca}></TableResult></div>
  );
}

