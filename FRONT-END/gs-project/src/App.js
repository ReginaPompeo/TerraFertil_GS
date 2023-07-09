import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from './components/navbar';
import Footer from './components/footer'
import Home from './paginas/home';
import SobreNos from './paginas/sobreNos';
import Noticias from './paginas/noticias';
import Forum from "./paginas/forum";
import Artigo1 from "./paginas/noticias/Artigos/Artigo1";
import Artigo2 from "./paginas/noticias/Artigos/Artigo2";
import Artigo3 from "./paginas/noticias/Artigos/Artigo3";
import Login from "./paginas/login";
import Cadastro from "./paginas/cadastro";
import Ranking from "./paginas/ranking";


function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/sobre" element={<SobreNos />} />
        <Route path="/noticias" element={<Noticias />} />
        <Route path="/forum" element={<Forum />}/>
        <Route path="/signup" element={<Cadastro/>}/>
        <Route path="/artigo1" element={<Artigo1/>}/>
        <Route path="/artigo2" element={<Artigo2/>}/>
        <Route path="/artigo3" element={<Artigo3/>}/>
        <Route path="/signin" element={<Login/>}/>
        <Route path="/signup" element={<Cadastro/>}/>
        <Route path="/ranking" element={<Ranking/>}/>
      </Routes>
      <Footer/>
    </Router>
  );
}

export default App;
