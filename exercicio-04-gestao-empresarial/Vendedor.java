public class Vendedor extends Funcionario{
    private int quantidadeVendas=0;
    /**
     * Contrutor base de funcionários
     *
     * @param nome          recebe uma String de nome
     * @param email         recebe um String com o e-mail
     * @param senha         recebe uma String com a senha
     */
    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    /**
     * Exibe a quantidade de vendas realizadas
     * @return quantidade de vendas.
     */
    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    /**
     * Método que faz o registro das vendas incrementando o valor na quantidade de vendas.
     * @param vendas recebe o valor da quandidade de vendas
     */

    public void realizarVendas(int vendas){
        if(vendas>0){
            this.quantidadeVendas += vendas;
        }else {
            System.out.println("A quantidade de vendas tem que ter valor positivo");
        }
    }

    /**
     * Metódo que consulta a quantidade de vendas.
     */
    public void consultarVendas() {
        System.out.printf("\nA quantidade total de vendas é %S\n", this.quantidadeVendas);
    }
}
