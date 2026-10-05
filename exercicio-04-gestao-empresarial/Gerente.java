public class Gerente extends Funcionario{
    /**
     * Contrutor base de funcionários
     *
     * @param nome          recebe uma String de nome
     * @param email         recebe um String com o e-mail
     * @param senha         recebe uma String com a senha
     */
    public Gerente(String nome, String email, String senha ) {
        super(nome, email, senha, true);

    }

    /**
     * Método que exibe o relatório financeiro
     */
    public void gerarRelatorioFinanceiro(){
        System.out.println("==RELATÓRIO==");
        System.out.println("Saldo da empresa: R$ 50.000,00");
        System.out.println("Status: Operação dentro do esperado.");
    }

    /**
     * Método que exibe as vendas.
     */
    public void consultarVendas(){
        System.out.println("Vendas realizadas no período do último mês");
        System.out.println("Total: 1500 vendas");
    }
}

