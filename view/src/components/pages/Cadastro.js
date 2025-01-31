import Form from '../project/Form'
import styles from './Cadastro.module.css'


function Cadastro() {


    return(
        <div className={styles.cadastro_container}>
            <h1>Cadastre o Aluno no sistema</h1>
            <p>Digite as Notas e a Frequencia dele:</p>
            <Form btnText="Criar Projeto"/>
        </div>
    )
}

export default Cadastro