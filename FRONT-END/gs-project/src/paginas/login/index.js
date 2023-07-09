import React from "react";
import "./styles.css";

function Login() {
  return (
    <>
      <div className="area-login">
        <div className="container-como">
          <div className="form">
            <h2>Login</h2>
            <div className="input">
              <div className="inputBox">
                <label>Usuário</label>
                <input type="text" placeholder="example@gmail.com" />
              </div>
              <div className="inputBox">
                <label>Senha</label>
                <input type="password" placeholder="······" />
              </div>
              <div className="inputBox">
                <input type="submit" value="Signin" />
              </div>
            </div>
            <p className="forget">
              Forgot Password? <a href="#">Click Here</a>
            </p>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;
