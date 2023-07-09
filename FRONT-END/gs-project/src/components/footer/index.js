import React from 'react'
import {Box, Container, Row, Column, FooterLink, Heading, Logo} from './styled';
import {BsInstagram, BsWhatsapp, BsTwitter, BsLinkedin, BsGithub} from "react-icons/bs"
import logo1 from '../img/logo1.png';
import { Link } from 'react-router-dom';

function Footer() {
  return (
    <>
      <Box>
      <Logo className='logo' to="/">
        <img src={logo1} alt='logo mundo com uma terra fértil ao luz do sol'/>
      </Logo>
      <Container>
        <Row>
          <Column className='menu'>
            <Heading>Menu</Heading>
            <FooterLink to="/" ActiveStyle>HOME</FooterLink>
            <FooterLink to="/noticias" ActiveStyle>NOTICIAS</FooterLink>
            <FooterLink to="/sobre" ActiveStyle>SOBRE NÓS</FooterLink>
            <FooterLink to="/comofunciona" ActiveStyle>COMO FUNCIONA</FooterLink>
            <FooterLink to="/forum" ActiveStyle>FORUM</FooterLink>
            <FooterLink to="/signup" ActiveStyle>CADASTRO | LOGIN</FooterLink>
          </Column>
          <Column className='contato'>
            <Heading>Fale com a gente!</Heading>
            <FooterLink>
              <BsWhatsapp style={{fontSize: '30px', marginRight: '10px'}}/>
              Whatsapp
            </FooterLink>
            <FooterLink>
              <Link to="/link1">
                <BsInstagram style={{ fontSize: '40px', marginRight: '13px', color: "#ad1187"}} />
              </Link>
              <Link to="/link2">
                <BsTwitter style={{ fontSize: '40px', marginRight: '13px' }} />
              </Link>
              <Link to="/link3">
                <BsLinkedin style={{ fontSize: '40px', marginRight: '13px', background: '#fff'}} />
              </Link>
              <Link to="/link4">
                <BsGithub style={{ fontSize: '40px', color: 'black'}} />
              </Link>
            </FooterLink>
          </Column>
          <Column className='integrantes'>
            <Heading>Desenvolvedores</Heading>
            <FooterLink to='' ActiveStyle>Leonardo Paganini</FooterLink>
            <FooterLink to='' ActiveStyle>Jhonn Brandon</FooterLink>
            <FooterLink to="" ActiveStyle>Regina Pompeo</FooterLink>
            <FooterLink to='' ActiveStyle>Matheus Leite</FooterLink>
          </Column>
        </Row>
      </Container>
      <p style={{textAlign: "center", paddingTop: "20px", color: "white"}}>
        Copyright @ Terra Fértil | Todos os direitos reservados
      </p>
      </Box>
    </>
  )
}

export default Footer