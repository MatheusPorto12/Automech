import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import { SearchScreen } from './components/screens/Search';
import { RepairScreen } from './components/screens/Reparos';
import { OficinaScreen } from './components/screens/Oficina';
import { Layout } from './Layout';
import './css/search.css'
import './css/style.css'
import * as React from 'react'

// 1. import `ChakraProvider` component
import { ChakraProvider } from '@chakra-ui/react'

function App() {
  return (
    <ChakraProvider>
      <BrowserRouter>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"></link>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="Oficina" element={<SearchScreen />} />
            <Route path="Reparo" element={<RepairScreen />} />
            <Route path="Oficina/Detalhes/:id" element={<OficinaScreen />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </ChakraProvider>
  );
}

export default App;
