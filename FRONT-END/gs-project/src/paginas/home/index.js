import React from 'react'
import { AreaHome } from './styled'
import backgroundHome from '../../components/img/backgroundImage.jpg'
import {Button} from 'reactstrap'

function Home() {
  return (
    <>
      <AreaHome>
        <div className='hero' >
          <div className='container1' style={{
            backgroundImage: `url(${backgroundHome})`, // Corrigido o uso das template strings
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            width: "100%"
          }}>
            <div className='container2'>
              <h1>Lutando pelo seu negócio
                <p>e por um mundo melhor!</p>
              </h1>
            </div>
            <div className='buttom'>
              <Button color="success" size="lg" style={{boxShadow: '0 5px 15px rgba(0,0,0,0.06)', borderRadius: '50px', textShadow: '1px 1px 4px #000000'}}> Faça parte da comunidade!</Button>
            </div>
          </div>
        </div>
      </AreaHome>
    </>
  )
}

export default Home
