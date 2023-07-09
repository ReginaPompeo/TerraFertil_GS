import React, { Component } from "react";
import { Link as NavLink } from "react-router-dom";
import logo1 from "../img/logo1.png";
import "./styled.css";

class Navbar extends Component {
  state = { clicked: false };
  handleClick = () => {
    this.setState({ clicked: !this.state.clicked });
  };
  render() {
    return (
      <>
        <nav className='sticky'>
          <NavLink to="/">
            <img className="logo" src={logo1} alt="" />
          </NavLink>
          <ul id="navbar" className={this.state.clicked ? "#navbar active" : "#navbar"}>
            <li>
              <NavLink to="/noticias" className="active">
                NOTICIAS
              </NavLink>
            </li>
            <li>
              <NavLink to="/sobre" className="active">
                SOBRE NÓS
              </NavLink>
            </li>
            <li>
              <NavLink to="/forum" className="active">
                FORUM
              </NavLink>
            </li>
            <li>
              <NavLink to="/signup" className="active">
                CADASTRE-SE | LOGIN
              </NavLink>
            </li>
            <li>
              <NavLink to="/ranking" className="active">
                RANKING
              </NavLink>
            </li>
          </ul>
          <div id="mobile" onClick={this.handleClick}>
            <iconClass id='bar' className={this.state.clicked ? 'fas fa-times' : 'fas fa-bars'}></iconClass>     
          </div>
        </nav>
      </>
    );
  }
}

export default Navbar;
