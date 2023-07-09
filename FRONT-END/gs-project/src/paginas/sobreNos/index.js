import React from "react";
import "./styled.css";
import foto1 from "../../components/img/doacao.jpg";
import { Link } from "react-router-dom";

function SobreNos() {
  return (
    <>
      <section className="about" id="about">
        <h2 className="title">Sobre Nós</h2>
        <div class="about-content">
          <div class="column left">
            <img src={foto1} alt="" />
          </div>
          <div class="column right">
            <div class="text">
              {" "}
              Somos a <span class="typing-2">Terra Fértil!</span>
            </div>
            <p>
              Somos uma empresa comprometida em combater a escassez de alimentos
              e a fome mundial. Através do nosso site, oferecemos informações,
              tecnologia e recursos para ajudar agricultores de pequeno porte a
              aumentar sua produtividade. Além disso, incentivamos a doação
              mensal de 5% dos alimentos produzidos pelos agricultores para uma
              ONG parceira. Essa doação não apenas ajuda a alimentar os
              necessitados, mas também proporciona benefícios fiscais aos
              agricultores. Junte-se a nós nessa missão de fortalecer a
              comunidade agrícola e fazer a diferença na luta contra a fome
              mundial.
            </p>
            <Link to="/SignUp">Junte-se à comunidade!</Link>
          </div>
        </div>
      </section>
    </>
  );
}

export default SobreNos;
