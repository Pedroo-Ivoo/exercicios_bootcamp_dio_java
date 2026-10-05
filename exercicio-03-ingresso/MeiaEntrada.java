/**
 * Representa um ingresso do tipo Meia Entrada.
 * Aplica uma regra de desconto de 50% sobre o valor do ingresso quando for elegivel para meia entrada..
 */
public class MeiaEntrada extends Ingresso {
    /**
     *Construtor da Meia Entrada que utiliza o construtor mãe (Ingresso) para a criação do ingresso
     * @param valor valor do ingresso
     * @param legenda booleano para verificar se há legenda
     * @param quantidade quantidade de ingressos
     * @param nomeFilme nome do filme
     */
    public MeiaEntrada(double valor,boolean legenda, int quantidade, String nomeFilme){
    super(valor, legenda, quantidade, nomeFilme);
    }

    /**
     * Método herdado do ingresso e sobreescrito para a criação do valor da meia entrada.
     * @return retorna o valor total do ingresso com desconto de 50%
     */
    @Override
    public double getTotal() {
        return super.getTotal()/2;
    }
}
