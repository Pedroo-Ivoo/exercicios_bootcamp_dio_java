
void main() {
    Scanner teclado = new Scanner(System.in);
    double entrada = 0;
    var novaConta = new Conta();
//    double saldo = novaConta.getSaldo();
    boolean ativo = true;
    while (ativo) {
        System.out.println("Sistema Bancário");
        System.out.println("Escolha uma das opções abaixo");
        System.out.println("01 - Consultar Saldo");
        System.out.println("02 - Consultar Cheque Especial");
        System.out.println("03 - Depositar Dinheiro");
        System.out.println("04 - Sacar Saldo");
        System.out.println("05 - Pagar Boleto");
        System.out.println("06 - Verificar se a conta está usando cheque especial");
        System.out.println("07 - Sair");
        System.out.print("Opção: ");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println("===Saldo===");
                System.out.printf("Saldo Disponível - R$ %.2f \n", novaConta.getSaldo());
                System.out.printf("Limite do Cheque Especial - R$ %.2f \n", novaConta.getLimiteChequeEspecial());
                System.out.printf("Total - R$ %.2f \n", novaConta.saldoTotal());
                System.out.println("===========");
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;

            }
            case 2 -> {
                System.out.println("===Cheque Especial===");
                System.out.printf("Cheque Especial Disponível - R$ %.2f \n", novaConta.getChequeEspecial());
                System.out.println("===========");
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;

            }
            case 3 -> {
                System.out.println("===Depositar Dinheiro===");
                System.out.print("Qual é o valor do deposito: ");
                entrada = teclado.nextDouble();
                try {
                    novaConta.depositar(entrada);
                    System.out.printf("Depósito do valor de R$ %.2f \n", entrada);
                    System.out.println("===========");

                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao depositar: " + e.getMessage());
                    System.out.println("===========");


                }
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;
            }
            case 4 -> {
                System.out.println("==Sacar Saldo==");
                System.out.print("Qual é o valor do saque: ");
                entrada = teclado.nextDouble();
                try {
                    novaConta.sacar(entrada);
                    System.out.printf("Saque realizado no valor de R$ %.2f \n", entrada);
                    System.out.println("===========");

                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao sacar dinheiro: " + e.getMessage());
                    System.out.println("===========");


                }
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;
            }

            case 5 -> {
                System.out.println("==Pagar Boleto==");
                System.out.print("Qual é o valor do boleto: ");
                entrada = teclado.nextDouble();
                try {
                    novaConta.pagarBoleto(entrada);
                    System.out.printf("Boleto no valor de R$ %.2f pago com sucesso!\n", entrada);
                    System.out.println("===========");

                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao pagar o boleto: " + e.getMessage());
                    System.out.println("===========");


                }
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;
            }
            case 6 -> {
                System.out.println("==Verificar se a conta está usando cheque especial==");
                try {
                    System.out.printf("Valor a ser pago do Cheque Especial - R$ %.2f \n", novaConta.usoChequeEspecial());
                    System.out.println("===========");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("===========");

                }
                teclado.nextLine();
                System.out.println("Aperte qualquer tecla para continuar");
                teclado.nextLine();
                continue;
                }
            case 7 -> {
                System.out.println("===========");
                System.out.println("Programa Encerrado");
                System.out.println("===========");

                ativo = false;
            }
        }

    }
        teclado.close();
}