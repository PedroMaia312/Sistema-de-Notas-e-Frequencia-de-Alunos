import PropTypes from 'prop-types';
function Notas({ vetor, matematica, portugues, ciencia, 
    geografia, literatura, media, faltante}) {

          const nomes = ["kelber", "Maria", "teste"];

    return (
        <div>
            <h1>Notas e Frenquencia</h1>
            <h2>Alunos</h2>
            <table className='table'>
            <thead>
                <tr>
                    <th>#Nome</th>
                    <th>#Media</th>
                    <th>#Frequencia</th>
                </tr>
            </thead>

            <tbody>
                {
                    vetor.map((obj, indice) => (
                        <tr key={indice}>
                            <td>{obj.nome}</td>
                            <td>{obj.media.toFixed(2)}</td>
                            <td>{obj.frequencia}%</td>
                        </tr>
                    ))
                }
            </tbody>
            </table>

            <h2>Media da Turma em cada Disciplina</h2>
            <table className='table'>
            <thead>
                <tr>
                    <th>#Materia</th>
                    <th>#Media</th>
                </tr>
            </thead>

            <tbody>
            
                        <tr>
                            <td>Matemática</td>   
                            <td>{matematica}</td>
                        </tr>
                        <tr>
                            <td>Português</td>   
                            <td>{portugues}</td>
                        </tr>
                        <tr>
                            <td>Ciência</td>   
                            <td>{ciencia}</td>
                        </tr>
                        <tr>
                            <td>Geografia</td>   
                            <td>{geografia}</td>
                        </tr>
                        <tr>
                            <td>Literatura</td>   
                            <td>{literatura}</td>
                        </tr>
            </tbody>
            </table>
            <h2>Alunos acima da media</h2>
            <table className='table'>
            <thead>
                <tr>
                    <th>#Nome</th>
                    <th>#Media</th>
                    
                </tr>
            </thead>

            <tbody>
            {
                  vetor
                  .filter((obj) => obj.media > media && faltante.includes(obj.nome)) // Filtra os alunos com média abaixo da média da sala e com frequência baixa
                  .map((obj, indice) => (
                    <tr key={indice}>
                      <td>{obj.nome}</td>
                      <td>{obj.media.toFixed(2)}</td>
                      </tr>
                  ))
                }
            </tbody>
            </table>

            <h2>Alunos que precisam de atenção</h2>
            <table className='table'>
            <thead>
                <tr>
                    <th>#Nome</th>
                </tr>
            </thead>

            <tbody>
            {faltante.map((nome, index) => (
            <tr key={index}>
              <td>{nome}</td>
            </tr>
          ))}
            </tbody>
            </table>
        </div>
    )
}

Notas.propTypes = {
    vetor: PropTypes.array.isRequired,
    matematica: PropTypes.number,
    portugues: PropTypes.number,
    ciencia: PropTypes.number,
    geografia: PropTypes.number,
    literatura: PropTypes.number,
    media: PropTypes.number,
};

export default Notas