import React from "react";
import './styles.css';
import { Button } from "reactstrap";
import { Link } from "react-router-dom";

function Cadastro() {
  return (
    <>
      <div className="area-cadastro">
        <div className="container-cadastro">
          <form className="form" action="submit.php" method="post">
            <h2>Cadastro</h2>
            <div className="input">
              <div className="inputBox">
                <label htmlFor="nome">Nome:</label>
                <input
                  type="text"
                  id="nome"
                  name="nome"
                  required
                  placeholder="Digite seu nome"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="cpf">CPF:</label>
                <input
                  type="text"
                  id="cpf"
                  name="cpf"
                  required
                  placeholder="Digite seu CPF"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="dataNascimento">Data de Nascimento:</label>
                <input
                  type="date"
                  id="dataNascimento"
                  name="dataNascimento"
                  required
                />
              </div>
              <div className="inputBox">
                <label htmlFor="cnpj">CNPJ:</label>
                <input
                  type="text"
                  id="cnpj"
                  name="cnpj"
                  required
                  placeholder="Digite seu CNPJ"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="razaoSocial">Razão Social:</label>
                <input
                  type="text"
                  id="razaoSocial"
                  name="razaoSocial"
                  required
                  placeholder="Digite sua razão social"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="email">E-mail:</label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  required
                  placeholder="Digite seu e-mail"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="senha">Senha:</label>
                <input
                  type="password"
                  id="senha"
                  name="senha"
                  required
                  placeholder="Digite sua senha"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="cep">CEP:</label>
                <input
                  type="text"
                  id="cep"
                  name="cep"
                  required
                  placeholder="Digite seu CEP"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="celular">Celular:</label>
                <input
                  type="text"
                  id="celular"
                  name="celular"
                  required
                  placeholder="Digite seu número de celular"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="rua">Rua:</label>
                <input
                  type="text"
                  id="rua"
                  name="rua"
                  required
                  placeholder="Digite o nome da rua"
                />
              </div>
              <div className="inputBox">
                <label htmlFor="bairro">Bairro:</label>
                <input
                  type="text"
                  id="bairro"
                  name="bairro"
                  required
                  placeholder="Digite o nome do bairro"
                />
              </div>
            </div>
            <Button style={{marginTop: '20px'}}>
              Cadastrar-se
            </Button>
            <p className="forget">
              Já possuí conta? <Link to='/signin'>Clique aqui</Link>
            </p>
          </form>
        </div>
      </div>
    </>
  );
}

export default Cadastro;
