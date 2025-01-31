import { Link } from 'react-router-dom'



import styles from './Navbar.module.css'

function Navbar() {
    return (
        <nav className={styles.navbar}>
            <ul className={styles.list}>
                <li className={styles.item}>
                    <Link to="/">Notas</Link>
                </li>
                <li className={styles.item}>
                    <Link to="/cadastro">Cadastro</Link>
                </li>
            </ul>
        </nav>
    )
}

export default Navbar