/**
 * Representa um ingresso base de cinema, contendo as informações gerais
 * como valor unitário, filme, quantidade e tipo de áudio (dublado/legendado).
 *
 * @author Pedro Ivo
 * @version 1.0
 */

public class Ingresso {
    private double valor;
    private boolean legenda;
    private int quantidade;
    private String nomeFilme;


    /**
     * Construtor base do ingresso.
     * @param valor recebe o valor do ingresso
     * @param legenda recebe um booleano para a legenda
     * @param quantidade quantidade de ingressos a ser vendidos
     * @param nomeFilme recebe o nome do Filme.

     */
    public Ingresso(double valor,boolean legenda, int quantidade, String nomeFilme){
        this.valor=valor;
        this.legenda = legenda;
        this.quantidade = quantidade;
        this.nomeFilme =nomeFilme;
    }

    /**
     * Realiza a consulta ao valor base do ingresso
     * @return o valor do ingresso
     */
    public double getValor(){
        return valor;
    }

    /**
     * Realiza a alteração do valor do ingresso
     * @param valor Novo valor unitário do ingresso.
     */
    public void setValor(double valor){
        this.valor=valor;
    }

    /**
     * Realiza a consulta a legenda
     * @return {@code true} se o filme for legendado, ou {@code false} se for dublado.
     */
    public boolean getLegenda(){
        return legenda;
    }

    /**
     * Altera o status do filme com ou sem legenda
     * @param legenda recebe o parâmetro booleano para alterar o status do filme.
     */
    public void setLegenda(boolean legenda){
        this.legenda =legenda;
    }

    /**
     * Metodo que imprime na tela a opção por filme Dublado ou legendado.
     */
    public void exibirStatusLegenda(){
        if(this.legenda){
            System.out.println("Filme legendado");
        }else{
            System.out.println("Filme dublado");
        }
    }

    /**
     * Metodo que retorna o número de ingressos adquiridos
     * @return retorna o número de ingresso
     */
    public int getQuantidade(){
        return quantidade;

    }

    /**
     * Metódo que altera a quantidade de ingressos
     * @param numero recebe um número inteiro como quantidade de ingresso.
     */
    public void setQuantidade(int numero){
        this.quantidade =numero;
    }

    /**
     * Obtém o nome do filme escolhido
     * @return retorna o nome do filme
     */
    public String getNomeFilme() {
        return nomeFilme;
    }

    /**
     * Altera o nome do filme.
     * @param nomeFilme Recebe o nome do filme para a venda do ingresso.
     */
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    /**
     * Método que obtém o valor total dos ingressos.
     * @return retorna o valor total dos ingressos
     */
    public double getTotal(){

        return this.quantidade * this.valor;
    }
}
