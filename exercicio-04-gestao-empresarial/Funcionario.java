/**
 * Representa um funcionário base de uma empresa contendo as informações gerais
 *
 *
 * @author Pedro Ivo
 * @version 1.0
 */
public class Funcionario {

    private String nome;
    private String email;
    private String senha;
    private boolean administrador;
    private boolean login;

    /**
     * Contrutor base de funcionários
     * @param nome recebe uma String de nome
     * @param email recebe um String com o e-mail
     * @param senha recebe uma String com a senha
     * @param administrador recebe um booleano
     */
    public Funcionario(String nome, String email, String senha, boolean administrador){
        this.nome =nome;
        this.email = email;
        this.senha=senha;
        this.login=false;
        this.administrador=administrador;

    }

    /**
     * Método que exibe o nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metódo que exibe o email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que exibe se o usuário é administrador.
     * @return administrador
     */
    public boolean ehAdministrador(){
        return administrador;
    }

    /**
     * Método para a realização do login
     * @param senha recebe a senha para verificação
     * @param nome recebe o nome do usuário.
     */
    public void realizarLogin(String nome,String senha){
        if(this.senha.equalsIgnoreCase(senha) && this.nome.equalsIgnoreCase(nome)){
            System.out.println("Login realizado com sucesso!");
            this.login=true;
        }else{
            System.out.println("Erro ao realizar o login. Verifique o nome e a senha.");
        }
    }

    /**
     * Verifica o status de login
     * @return login;
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * Método que realiza o logout do sistema.
     */
    public void logout(){
        if(this.login){
            System.out.println("Logout realizado com sucesso.");
            this.login=false;
        }else {
            System.out.println("Você não está logado no sistema");
        }
    }
    /**
     * Método para alterar os dados de nome e e-mail. Realiza a verificação de qual dado é necessário atualizar.
     * @param novoNome recebe o novo nome para alteração
     * @param novoEmail recebe o novo e-mail para alteração
     */
    public void alterarDados(String novoNome, String novoEmail){

        if(this.nome.equalsIgnoreCase(novoNome) && !this.email.equalsIgnoreCase(novoEmail)) {
            this.email =novoEmail;
            System.out.println("E-mail atualizado com sucesso");
        }else if (this.email.equalsIgnoreCase(novoEmail) && !this.nome.equalsIgnoreCase(novoNome)){
            this.nome=novoNome;
            System.out.println("Nome atualizado com sucesso");
        }else if (this.nome.equalsIgnoreCase(novoNome) && this.email.equalsIgnoreCase(novoEmail)){
            System.out.println("Nome e e-mail iguais ao cadastro nenhuma atualização feita.");
        } else{
            this.nome =novoNome;
            this.email=novoEmail;
            System.out.println("Nome e e-mail atualizados com sucesso..");
        }
        }

    /**
     * Metódo responsável por alterar a senha do usuário. Faz a verificação se a nova senha é diferente da senha atual.
     * @param novaSenha recebe a nova senha.
     */
    public void alterarSenha(String novaSenha){
        if(this.login){
            if(this.senha.equalsIgnoreCase(novaSenha)){
                System.out.println("A nova senha não pode ser igual a anterior");
            }else{
                System.out.println("Nova senha cadastrada com sucesso");
                this.senha=novaSenha;
            }
        }
}

}


