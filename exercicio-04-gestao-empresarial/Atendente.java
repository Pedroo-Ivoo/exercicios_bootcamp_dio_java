public class Atendente extends Funcionario{
    private boolean funcionamentoCaixa = false;
    private double caixa = 0;
    /**
     * Contrutor base de funcionários
     *
     * @param nome          recebe uma String de nome
     * @param email         recebe um String com o e-mail
     * @param senha         recebe uma String com a senha
     */
    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    /**
     * Exibe a verificação se o caixa está aberto ou fechado
     * @return Funcionamento do Caixa
     */
    public boolean isFuncionamentoCaixa() {
        return funcionamentoCaixa;
    }

    /**
     * Método que exibe o valor que está em caixa.
     * @return caixa.
     */
    public double getCaixa() {
        return caixa;
    }

    /**
     * Método que abre o Caixa para poder iniciar as vendas.
     */
    public void abrirCaixa(){
        if (!funcionamentoCaixa){
            this.funcionamentoCaixa = true;
            System.out.println("\nCaixa Aberto");
        }else{
            System.out.println("O caixa já está aberto");
        }
    }

    /**
     * Método que fecha o Caixa, informa o valor total e após zerá o valor do caixa.
     */
    public void fecharCaixa(){
        if(funcionamentoCaixa){
        this.funcionamentoCaixa=false;
        System.out.println("\nCaixa Fechado");
        System.out.printf("O valor total do caixa: %.2f\n", caixa);
        this.caixa=0;
        }else {
        System.out.println("O caixa não foi aberto. Ele se encontra fechado.");

        }
    }

    /**
     * Metódo que recebe o valor das quantidades de vendas e atualiza o valor do caixa.
     * @param valor
     */
    public void receberPagamentos(double valor){
     if(funcionamentoCaixa) {
         if (valor < 0) {
             System.out.println("\nValor deve ser um número positivo");
         } else {
             this.caixa += valor;
             System.out.println("\nValor recebido com sucesso");
         }
     }else{
         System.out.println("Para receber o pagamento é necessário abrir o caixa.");
     }
    }
}
