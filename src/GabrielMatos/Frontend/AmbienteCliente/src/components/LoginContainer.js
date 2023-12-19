import '../css/generalStyle.css'
import '../css/login.css';

export function LoginConteiner(){
    return(
        <div class="container">
        <h1>LOGIN</h1>
        <div class="row">
            <div class="col-md-12 col-xs-1">
                <div class="col-md-12 col-xs-6 mb-3 text-center">
                    <input class="infoFields" type="number" name="" id="caduser_cpf" placeholder="CPF" required/>
                </div>
                <div class="col-md-12 col-xs-6 mb-3 text-center">
                    <input class="infoFields" type="password" name="" id="caduser_senha" placeholder="Senha" required/>
                </div>

                <div class="col-md-12 col-xs-6 mb-3 text-center">
                    <button type="button" class="btn">Login</button>
                </div>
                <div class="col-md-12 col-xs-6 mb-3 text-center">
                    <a href="/cadastro"> Não tenho uma conta. Cadastrar agora!</a>
                </div>
            </div>
        </div>

    </div>
    );
}

const styles = {
    container: {
        display: "flex",
        flexDirection: "column",
        alignItems: "center"
    },
    stars: {
        display: "flex",
        flexDirection: "row",
    },
    textarea: {
        border: "1px solid #a9a9a9",
        borderRadius: 5,
        padding: 10,
        margin: "20px 0",
        minHeight: 100,
        width: 300
    },
    button: {
        border: "1px solid #a9a9a9",
        borderRadius: 5,
        width: 300,
        padding: 10,
    }

};
export default LoginConteiner;

