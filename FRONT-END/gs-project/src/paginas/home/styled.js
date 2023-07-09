import styled from "styled-components";

export const AreaHome = styled.div`
  .hero {
    color: white;
  }
  .container1 {
    background-color: black;
    height: 800px;
    display: flex;
    flex-direction: column;
  }
  .container2 {
    height: 250px;
    margin-top: 200px;
    margin-left: 30px;
    h1 {
      font-size: 60px;
      text-shadow: 2px 2px black;
    }
  }
  .buttom{
    margin-left: 30px;

    @media screen and (max-width: 1632px){
        margin-top: -40px;
        transition: 0.3s ease-in-out;
    }
    @media screen and (max-width: 718px){
        margin-top: 60px;
        transition: 0.3s ease-in-out;
    }
    @media screen and (max-width: 452px){
        margin-top: 130px;
        transition: 0.3s ease-in-out;
    }
    @media screen and (max-width: 392px){
        margin-top: 200px;
        transition: 0.3s ease-in-out;
    }
  }
`;
