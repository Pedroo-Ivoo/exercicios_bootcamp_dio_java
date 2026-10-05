/**
 * Representa um ingresso do tipo família.
 * Aplica uma regra de desconto de 5% caso a quantidade de pessoas seja superior a 3.
 */
public class IngressoFamilia extends Ingresso{
    /**
     *Construtor do Ingresso Familia que utiliza o construtor mãe (Ingresso) para a criação do ingresso
     * @param valor valor do ingresso
     * @param legenda booleano para verificar se há legenda
     * @param quantidade quantidade de ingressos
     * @param nomeFilme nome do filme
     */
    public IngressoFamilia(double valor,boolean legenda, int quantidade, String nomeFilme){
        super(valor, legenda,quantidade,nomeFilme);
    }

    /**
     * * Método herdado do ingresso e sobreescrito para a criação do valor do ingresso familia.
     * faz a verificação se a quantidade de ingresso for superior a 3 concede desconto de 5%
     * @return retorna o valor total do ingresso
     *
     */
    @Override
    public double getTotal() {
        if(getQuantidade()>3){
        return super.getTotal() - (super.getTotal()*0.05);

        }else{
        return super.getTotal();
        }
    }
}
