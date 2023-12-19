
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { CadastroContainer } from "./components/CadastroContainer";
import LoginContainer from './components/LoginContainer';
import { AlterarCadastro } from "./components/AlterarCadastro";
import { Historico } from "./components/Historico";
import { Layout } from './Layout';
import FeedbackContainer from './components/FeedbackConteiner'
import Home from "./components/Home";



import './css/nav.css'


function App(){
    return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="Login" element={<LoginContainer />} />
          <Route path="Cadastro" element={<CadastroContainer />} />
          <Route path="AlterarCadastro" element={<AlterarCadastro />} />
          <Route path="HistoricoVeiculo" element={<Historico />} />
          <Route path="Feedback" element={<FeedbackContainer/>} />
          <Route path="home" element={<Home/>} />

          
        </Route>
      </Routes>
    </BrowserRouter>
    );
}

export default App;