import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import Notas from './components/pages/Notas';
import Cadastro from './components/pages/Cadastro';
import { useState, useEffect } from 'react';

import NavBar from './components/layout/Navbar'


function App() {

  const [alunos, setAlunos] = useState([]);
  const [faltante, setFaltante] = useState([]);
  const [matematica, setMatematica] = useState(0);
  const [portugues, setPortugues] = useState(0);
  const [ciencia, setCiencia] = useState(0);
  const [geografia, setGeografia] = useState(0);
  const [literatura, setLiteratura] = useState(0);
  const [media, setMedia] = useState(0);

  useEffect( () => {
    fetch("http://localhost:8080/sala/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setAlunos(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);

  useEffect( () => {
    fetch("http://localhost:8080/sala/alunos-frequencia-baixa")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setFaltante(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);

  useEffect( () => {
    fetch("http://localhost:8080/sala/media-matematica")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setMatematica(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);
  useEffect( () => {
    fetch("http://localhost:8080/sala/media-portugues")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setPortugues(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);
  useEffect( () => {
    fetch("http://localhost:8080/sala/media-ciencia")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setCiencia(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);
  useEffect( () => {
    fetch("http://localhost:8080/sala/media-geografia")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setGeografia(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);
  useEffect( () => {
    fetch("http://localhost:8080/sala/media-literatura")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setLiteratura(retorno_convertido);
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);
  useEffect( () => {
    fetch("http://localhost:8080/sala/media")
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      setMedia(retorno_convertido);
    })   .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);


  return (
    <div className="App">
      
 <Router>
        <div>
          <NavBar />
        </div>
        <Switch>
          <Route path="/cadastro" component={Cadastro} />
        </Switch>
      </Router>
      <Notas vetor={alunos} matematica={matematica} portugues={portugues} ciencia={ciencia} 
      geografia={geografia} literatura={literatura} media={media} faltante={faltante}/>
    </div>
  );
}

export default App;
