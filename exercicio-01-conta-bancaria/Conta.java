public class Conta {
    //Atributo Saldo
    private double saldo;
    //Atributo Crédito (deposito)

    private double chequeEspecial;


   private int contador = 0;
   private double limiteChequeEspecial = 0;
   double valorChequeEspecial= 0;

    //Construtor
    public Conta(){
        this.saldo = 0;
        this.chequeEspecial = 0;
    }

    /** Realiza a consulta do Limite do Cheque Especial
     * @return Retorna o valor do Limite da conta.
     */
    public double getLimiteChequeEspecial(){
        return limiteChequeEspecial;
    }

    /**Realiza a consulta do saldo disponível em conta
     *
     * @return Retorna o valor do saldo.
     */
    public double getSaldo(){
        return saldo;
    }
    /**Realiza a verificaçãod do saldo do cheque especial da conta.
     * @return o valor do cheque especial disponível.
     */
    public double getChequeEspecial(){
        return chequeEspecial;
    }

    /**Realiza a consulta do valor do total do saldo disponível em conta.
     * Sendo esse a soma do saldo e do saldo do cheque especial da conta.
     *
     * @return Retorna o valor total.
     */
    public double saldoTotal(){
        return getChequeEspecial() + getSaldo();
    }

    /**
     * Realiza a definição do valor do Cheque Especial.
     * Se o valor for até 500 define o limite e cheque especial em 50.
     * Se o valor for acima de 500 define o valor do limite e o cheque especial em 50% do valor informado.
     * @param credito recebe o valor do primeiro depósito para a definição do limite do cheque especial.
     */
    public void chequeEspecialValor(double credito){
        if (credito <= 500){
            chequeEspecial =  50;
            limiteChequeEspecial =  50;
        }else {
            chequeEspecial = credito * 0.5;
            limiteChequeEspecial = credito * 0.5;
        }
    }

    /**
     *
     * Metodo criado para dar entrada no valor do depósito.
     * Realiza o depósito na conta, atualizando o saldo. Caso seja o primeiro depósito realizado após a abertura da conta, calcula e ativa o limite do cheque especial
     * @param deposito recebe o valor que será depositado em conta.
     */
    public void depositar(double deposito){
        setSaldo(deposito);
        if (contador==0){
        chequeEspecialValor(deposito);
        contador = contador + 1;}
    }

    /**
     * Realiza a verificação se o valor do depósito é positivo e atualiza o saldo somando com o valor do depósito.
     * Se o valor não for positivo ele lança um aviso e não conclui a operação.
     *
     * @param deposito Recebe o valor do depósito
     * @throws IllegalArgumentException Utilizado para retornar o aviso de que o valor deve ser positivo.
     */
    public void setSaldo (double deposito) {
        if (deposito <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo");
        }
        this.saldo =saldo + deposito;
    }

    /** Realiza as verificações da regra de negócio para o saque ou pagamento de boleto.
     * Ele verifica se o valor a ser utizado na transação(saque ou pagamento) tem saldo disponível em conta para a sua conclusão.
     * Se o saldo for maior que o valor a ser utilizado realiza a operação de subtração do valor com o saldo e atualiza o saldo.
     * Se o valor for maior que o saldo e menor que o saldo total(Saldo + Cheque Especial disponível) subtrai o valor do saldo, deixa o saldo com valor de zero e o restante desconta do Cheque especial.
     * @param saque recebe o valor a ser utilizado no saque ou pagamento de boleto.
     * @throws IllegalArgumentException Se o valor a ser utilizado é positivo e maior que zero, se o não for lança um aviso.
     * @throws IllegalArgumentException Se o valor utilizado for mais que o saldo total disónível (Saldo + Cheque Especial disponível) lança outro aviso com a informação do Saldo Insuficiente.
     */
    public void verificadorSaque(double saque){
        if (saque<= 0){
            throw new IllegalArgumentException("O valor deve ser positivo");
        }
        if (saque>saldoTotal()){
            throw new IllegalArgumentException("Saldo insuficiente. Verifique o seu saldo.");
        }
        if (saldo>=saque){
            this.saldo= saldo-saque;
        } else {
            double restante = saque -saldo;
            this.saldo=0;
            this.chequeEspecial -= restante;

        }


    }
    /**
     * Realiza o saque na conta.
     * Consome primeiro o saldo próprio e, caso necessário, utiliza o limite do cheque especial.
     *
     * @param saque Valor a ser sacado (deve ser positivo e menor ou igual ao saldo total).
     * @throws IllegalArgumentException se o valor for inválido ou se não houver saldo suficiente.
     */
    public void sacar(double saque){
        verificadorSaque(saque);
    }

    /**
     * Realiza o pagamento de boletos.
     * Invoca o metodo Sacar() por debaixo dos panos e usas as mesmas regras de negócio para o pagamento.
     *
     * @param boleto Valor a ser utilizado no pagamento (deve ser positivo e menor ou igual ao saldo total).
     * @throws IllegalArgumentException se o valor for inválido ou se não houver saldo suficiente.
     */
    public void pagarBoleto(double boleto){
        sacar(boleto);
    }

    /**
     * Realiza a verificação se o cliente usou o valor do Cheque Especial disponível na sua conta.
     * A taxa de Juros é de 20% sobre o valor utilizado do Cheque Especial.
     * @return valorChequeEspecial que é o valor dos juros cobrados sobre o valor do Cheque Especial utilizado.
     * @throws  IllegalArgumentException Lança a informação ao usuário dde que não está em uso o Cheque Especial.
     */
    public double usoChequeEspecial(){
        if(limiteChequeEspecial == chequeEspecial){
            throw new IllegalArgumentException("Você não está usando o Cheque Especial");
        }
        double juros = (limiteChequeEspecial -chequeEspecial) * 0.2;
        return valorChequeEspecial = juros;


    }

}
