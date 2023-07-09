import{useState,useEffect} from 'react';
import "./styled.css";


export default function RankingDoacao() {
const [doacao, setDoacao] = useState([]);
useEffect(()=>{
    fetch("http://localhost:8080/TFWeb2/rest/rank").then((resp)=>{
        return resp.json();
    }).then((resp)=>{
        setDoacao(resp)
        console.log(resp)
    }).catch((error)=>{
        console.log(error)
      });
    }, []);
return (
  <>
     <section className="rank" id="rank">
        <h2 className="title">RANKING</h2>
        <div class="rank-content">
          <div class="column left">
          </div>
          <div class="column right">
            <div class="text">
              {" "}
            </div>
        <h1>Ranking Mensal de Doações</h1>
        <table>
        <thead>
          <tr>
            <th>Doador</th>
            <th>Quantidade</th>
          </tr>
        </thead>
        <tbody>
        {doacao.map((doacao) => (
              <tr key={doacao.id}>
                <td>{doacao.nome}</td>
                <td>{doacao.quantidade}kg</td>
                <td></td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </section>
    </>
  );
}