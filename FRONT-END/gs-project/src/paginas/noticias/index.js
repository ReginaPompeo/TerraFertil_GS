import React, { useEffect, useState } from "react";
import { AreaNoticias } from "./styled";
import { Link } from "react-router-dom";
import axios from "axios";
import artigo0 from "../../components/img/artigo0.jpg";
import artigo6 from "../../components/img/artigo6.jpg";
import artigo3 from "../../components/img/artigo3.jpg";
import apiNoticias from "../../services/apiNoticias";

function Noticias() {

// UTILIZAÇÃO DE API EXTERNA

  const [articles, setArticles] = useState([]);
  useEffect(() => {
    const apikey = "63f8813ec798b90988b2eac6371bc860";
    const url = `https://gnews.io/api/v4/search?q=combate%20à%20fome%20mundial&lang=pt&country=br&max=10&apikey=${apikey}`;

    axios
      .get(url)
      .then((response) => {
        const articles = response.data.articles;
        if (articles.length > 0) {
          setArticles(articles);
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

// UTILIZAÇÃO DE API REST JAVA

  const [listaNoticias, setListNoticias] = useState({});

  useEffect(() => {
    const fetchNoticias = async () => {
      try {
        const resposta = await apiNoticias(
          "http://localhost:8080/LojaApp/rest/noticias"
        );
        setListNoticias(resposta.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchNoticias();
  }, []);

  return (
    <AreaNoticias>
      {listaNoticias.title}
      <div className="background">
        <header className="header">
          <h1>NOTÍCIAS</h1>
        </header>
        <main className="main columns">
          <section className="column main-column">
            <Link to="/Artigo1" className="article first-article">
              <figure className="article-image is-4by3">
                <img src={artigo0} alt="" />
              </figure>
              <div className="article-body">
                <h2 id="title" className="article-title">
                  Desafios do Combate à Fome Mundial e à Escassez de Alimentos
                </h2>
                <p className="article-content">
                  A fome mundial e a escassez de alimentos são problemas
                  urgentes que afetam milhões de pessoas em todo o mundo. A
                  falta...
                </p>
                <footer className="article-info">
                  <span>By Paganini</span>
                  <span>42 comments</span>
                </footer>
              </div>
            </Link>
            <div className="columns">
              <div className="column nested-column">
                {articles.map((article, index) => (
                  <a
                    key={index}
                    href="https://www.correiobraziliense.com.br/diversao-e-arte/2022/06/5014134-cupula-bolsonaro-desembarca-em-los-angeles-para-encontro-com-biden.html"
                    className="article"
                  >
                    <figure className="article-image is-4by3">
                      <img src={article.image} alt={article.title} />
                    </figure>
                    <div className="article-body">
                      <h2 className="article-title">{article.title}</h2>
                      <p className="article-content">{article.description}</p>
                      <footer className="article-info">
                        <span>By {article.source.name}</span>
                        <span>{article.publishedAt}</span>
                      </footer>
                    </div>
                  </a>
                ))}
              </div>
              <div className="column">
                <Link to="/Artigo2" className="article">
                  <figure className="article-image is-16by9">
                    <img
                      src={artigo3}
                      alt="foto do jovem Aadit Palicha, prodígio e fundador de empresa que vale US$1 bi"
                    />
                  </figure>
                  <div className="article-body">
                    <h2 className="article-title">
                      A Importância da Distribuição de Alimentos e como a IA
                      ajuda você no processo
                    </h2>
                    <p className="article-content">
                      A distribuição eficiente de alimentos é fundamental para
                      garantir que pessoas de todas as regiões tenham acesso...
                    </p>
                    <footer className="article-info">
                      <span>By Paganini</span>
                      <span>42 comments</span>
                    </footer>
                  </div>
                </Link>
                <Link
                  to="https://globoplay.globo.com/v/11363394/"
                  className="article"
                >
                  <div className="article-body">
                    <h2 className="article-title">
                      {listaNoticias[3]?.titulo}
                    </h2>
                    <p className="article-content">
                      {listaNoticias[3]?.descricao}
                    </p>
                    <footer className="article-info">
                      <span>{listaNoticias[3]?.autor}</span>
                      <span>{listaNoticias[3]?.data}</span>
                    </footer>
                  </div>
                </Link>
                <Link
                  to="https://g1.globo.com/ba/bahia/bahia-farm-show/noticia/2023/06/06/com-lancamentos-segunda-maior-feira-de-agronegocios-do-brasil-e-aberta-para-visitantes-na-bahia-apos-cerimonia-com-lula.ghtml"
                  className="article"
                >
                  <div className="article-body">
                    <h2 className="article-title">
                      {listaNoticias[2]?.titulo}
                    </h2>
                    <p className="article-content">
                      {listaNoticias[2]?.descricao}
                    </p>
                    <footer className="article-info">
                      <span>{listaNoticias[2]?.autor}</span>
                      <span>{listaNoticias[2]?.data}</span>
                    </footer>
                  </div>
                </Link>
              </div>
            </div>
          </section>
          <section className="column">
            <Link to="/Artigo3" className="article">
              <figure className="article-image is-3by2">
                <img src={artigo6} alt="" />
              </figure>
              <div className="article-body">
                <h2 className="article-title">
                  Tecnologias Inovadoras na Agricultura Sustentável
                </h2>
                <p className="article-content">
                  Agricultura sustentável é uma necessidade crescente para
                  enfrentar os desafios de produção de alimentos...
                </p>
                <footer className="article-info">
                  <span>By Paganini</span>
                  <span>42 comments</span>
                </footer>
              </div>
            </Link>
            <Link
              to="https://globoplay.globo.com/v/11652615/"
              className="article"
            >
              <div className="article-body">
                <h2 className="article-title">{listaNoticias[0]?.titulo}</h2>
                <p className="article-content">{listaNoticias[0]?.descricao}</p>
                <footer className="article-info">
                  <span>{listaNoticias[0]?.autor}</span>
                  <span>{listaNoticias[0]?.data}</span>
                </footer>
              </div>
            </Link>
            <Link
              to="https://g1.globo.com/ba/bahia/bahia-farm-show/noticia/2023/06/07/maior-colheitadeira-do-mundo-e-drones-de-pulverizacao-bahia-farm-show-mostra-tecnologia-de-ponta-que-auxilia-o-agronegocio.ghtml"
              className="article"
            >
              <div className="article-body">
                <h2 className="article-title">{listaNoticias[1]?.titulo}</h2>
                <p className="article-content">{listaNoticias[1]?.descricao}</p>
                <footer className="article-info">
                  <span>{listaNoticias[1]?.autor}</span>
                  <span>{listaNoticias[1]?.data}</span>
                </footer>
              </div>
            </Link>
          </section>
        </main>
      </div>
    </AreaNoticias>
  );
}

export default Noticias;
