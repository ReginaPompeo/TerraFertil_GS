import React, { useState } from 'react';
import { AreaForum } from './styled';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

function Forum() {
  const [mostrarFormulario, setMostrarFormulario] = useState(false);

  const toggleFormulario = () => {
    setMostrarFormulario(!mostrarFormulario);
  };
  return (
    <>
      <AreaForum>
        <div className='container-flex'>
          <div className='container-1'>
            <h3 className='texto'>Explore as nossas perguntas</h3>
            <div className='Button'>
              <Button
                color="primary"
                onClick={toggleFormulario} // Adicionei o evento onClick para alternar a exibição do formulário
              >
                Faça uma pergunta
              </Button>
            </div>
          </div>
          {mostrarFormulario && (
            <div className='container-formulario'>
              <Form>
                <FormGroup>
                  <Label for="nome">Nome</Label>
                  <Input type="text" name="nome" id="nome" placeholder="Digite seu nome" />
                </FormGroup>
                <FormGroup>
                  <Label for="email">Email</Label>
                  <Input type="email" name="email" id="email" placeholder="Digite seu email" />
                </FormGroup>
                <FormGroup>
                  <Label for="mensagem">Mensagem</Label>
                  <Input type="textarea" name="mensagem" id="mensagem" placeholder="Digite sua mensagem" />
                </FormGroup>
                <Button color="primary">Enviar</Button>
              </Form>
            </div>
          )}
          <div className='container-2'>
              <p className='pergunta'>1. Qual é o melhor momento para plantar batatas?</p>
              <p className='date'>5 comentário | 3 horas atrás</p>
          </div>
          <div className='container-2'>
              <p className='pergunta'>1. Qual é o melhor momento para plantar batatas?</p>
              <p className='date'>5 comentário | 3 horas atrás</p>
          </div>
          <div className='container-2'>
              <p className='pergunta'>1. Qual é o melhor momento para plantar batatas?</p>
              <p className='date'>5 comentário | 3 horas atrás</p>
          </div>
          <div className='container-2'>
              <p className='pergunta'>1. Qual é o melhor momento para plantar batatas?</p>
              <p className='date'>5 comentário | 3 horas atrás</p>
          </div>
          <div className='container-2'>
              <p className='pergunta'>1. Qual é o melhor momento para plantar batatas?</p>
              <p className='date'>5 comentário | 3 horas atrás</p>
          </div>
        </div>
      </AreaForum>
    </>
  )
}

export default Forum