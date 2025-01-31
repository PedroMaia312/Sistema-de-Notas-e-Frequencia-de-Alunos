import styles from './Form.module.css';
import { useState } from 'react';

function Form({ btnText }) {
    const [aluno, setAluno] = useState({
        nome: "",
        notaMatematica: "",
        notaPortugues: "",
        notaCiencia: "",
        notaGeografia: "",
        notaLiteratura: "",
        frequencia: ""
    });

    function handleChange(e) {
        const { name, value } = e.target;
        setAluno(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    async function handleSubmit(e) {
        e.preventDefault();

        for (const key in aluno) {
            if (!aluno[key].toString().trim()) {
                alert(`O campo "${key}" não pode estar vazio!`);
                return;
            }
        }

        const alunoFormatado = {
            nome: aluno.nome,
            notaMatematica: parseFloat(aluno.notaMatematica),
            notaPortugues: parseFloat(aluno.notaPortugues),
            notaCiencia: parseFloat(aluno.notaCiencia),
            notaGeografia: parseFloat(aluno.notaGeografia),
            notaLiteratura: parseFloat(aluno.notaLiteratura),
            frequencia: parseInt(aluno.frequencia, 10)
        };

        try {
            const response = await fetch('http://localhost:8080/sala', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(alunoFormatado)
            });

            if (!response.ok) {
                throw new Error('Erro ao enviar os dados');
            }

            alert('Aluno cadastrado com sucesso!');
            

            setAluno({
                nome: "",
                notaMatematica: "",
                notaPortugues: "",
                notaCiencia: "",
                notaGeografia: "",
                notaLiteratura: "",
                frequencia: ""
            });

        } catch (error) {
            console.error(error);
            alert('Erro ao cadastrar aluno');
        }
    }

    return (
        <div>
            <form className={styles.form} onSubmit={handleSubmit}>
                <div>
                    <label>Nome</label>
                    <input 
                        type="text" 
                        name="nome" 
                        value={aluno.nome} 
                        placeholder="Digite o nome do aluno" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Nota Matemática</label>
                    <input 
                        type="number" 
                        name="notaMatematica" 
                        value={aluno.notaMatematica} 
                        placeholder="Digite a nota aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Nota Português</label>
                    <input 
                        type="number" 
                        name="notaPortugues" 
                        value={aluno.notaPortugues} 
                        placeholder="Digite a nota aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Nota Ciência</label>
                    <input 
                        type="number" 
                        name="notaCiencia" 
                        value={aluno.notaCiencia} 
                        placeholder="Digite a nota aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Nota Geografia</label>
                    <input 
                        type="number" 
                        name="notaGeografia" 
                        value={aluno.notaGeografia} 
                        placeholder="Digite a nota aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Nota Literatura</label>
                    <input 
                        type="number" 
                        name="notaLiteratura" 
                        value={aluno.notaLiteratura} 
                        placeholder="Digite a nota aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <div>
                    <label>Frequência</label>
                    <input 
                        type="number" 
                        name="frequencia" 
                        value={aluno.frequencia} 
                        placeholder="Digite aqui" 
                        onChange={handleChange} 
                    />
                </div>
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
}

export default Form;
