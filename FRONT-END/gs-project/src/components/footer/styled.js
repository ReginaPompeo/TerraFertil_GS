import styled from "styled-components";
import { Link } from "react-router-dom";

export const Box = styled.div`
  padding: 32px;
  background: rgb(61, 107, 11);
  background: linear-gradient(
    260deg,
    rgba(61, 107, 11, 1) 0%,
    rgba(139, 69, 19, 1) 75%
  );
  bottom: 0;
  width: 100%;
  box-shadow: 0 5px 15px rgba(0,0,0,0.06);

  @media screen and (max-width: 1082px) {
    padding: 10px 10px;
    padding-top: 70px;
    transition: 0.3s ease-in-out;
  }
`;

export const Logo = styled(Link)`
  display: flex;
  justify-content: center;
  height: 60px;

  @media (max-width: 1082px) {
    display: flex;
    justify-content: center;
    height: 60px;
  }
`;

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  max-width: 1000px;
  margin: 0 auto;

  @media (max-width: 877px) {
    .integrantes {
      display: none;
    }
  }
`;

export const Column = styled.div`
  display: flex;
  flex-direction: column;
  text-align: left;
  margin-left: 60px;
  text-shadow: 2px 2px 4px #000000;
`;

export const Row = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(236px, 1fr));
  grid-gap: 20px;

  @media (max-width: 1082px) {
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  }
`;

export const FooterLink = styled(Link)`
  color: #fff;
  margin-bottom: 20px;
  font-size: 18px;
  text-decoration: none;

  &:hover {
    color: #d4a707;
    transition: color 0.3s ease;
  }
`;

export const Heading = styled.p`
  padding-top: 30px;
  font-size: 24px;
  color: #fff;
  margin-bottom: 40px;
  font-weight: bold;
`;
