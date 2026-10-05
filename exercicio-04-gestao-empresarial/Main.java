void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Gerente gerente = new Gerente("Pedro","email","1234");
    Vendedor vendedor = new Vendedor("Pedro","email","1234");
    Atendente atendente =  new Atendente("Pedro","email","1234");
    boolean rodandoSistema = true;
    while(rodandoSistema){

        System.out.println("==================================================");
        System.out.println("        SISTEMA DE GESTÃO EMPRESARIAL - DIO      ");
        System.out.println("==================================================");
        System.out.println("* Dica: Todos os usuários iniciam com:");
        System.out.println("  - Usuário: Pedro | Senha inicial: 1234");
        System.out.println("--------------------------------------------------");
        System.out.println("Escolha o perfil de acesso:");
        System.out.println("1- Gerente");
        System.out.println("2- Vendedor");
        System.out.println("3- Atendente");
        System.out.println("0- Encerrar Programa");

        System.out.print("Opção: ");
        String opcao = teclado.nextLine();


            switch (opcao){
                case "1"-> menuGerente(gerente, teclado);
                case "2"-> menuVendedor(vendedor, teclado);
                case "3"-> menuAtendente(atendente, teclado);
                case "0"-> rodandoSistema=false;
                default -> System.out.print("\nOpção invalida.\n");
            }


    }
    teclado.close();
}
public void menuGerente(Gerente gerente, Scanner teclado){
    boolean noMenu = true;
    while (noMenu){

        String status = gerente.isLogin() ? "Logado (" + gerente.getNome() + ")" : "Deslogado";


        System.out.println("\n--------------------------------------------------");
        System.out.println("              PAINEL DO GERENTE                   ");
        System.out.println("  [Status: " + status + "] | Administrador: Sim");
        System.out.println("--------------------------------------------------");
        System.out.println("* Fluxo recomendado:\n" +
                "  1º Faça Login (Opção 1)\n" +
                "  2º Acesse Relatórios e Vendas (Opções 2 e 3)");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Realizar Login");
        System.out.println("2 - Gerar Relatório Financeiro");
        System.out.println("3 - Consultar Vendas");
        System.out.println("4 - Alterar Dados (Nome / E-mail)");
        System.out.println("5 - Alterar Senha");
        System.out.println("6 - Logout");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        String opcao = teclado.nextLine();
        switch (opcao){
            case "1" -> {
                //Login
                System.out.print("\nDigite o nome do usuário: ");
                String usuario = teclado.nextLine().strip();
                System.out.print("Digite a senha: ");
                String senha = teclado.nextLine().strip();
                gerente.realizarLogin(usuario,senha);

            }
            case "2"-> {
                //Gerar relatório
                if(gerente.isLogin()){
                    gerente.gerarRelatorioFinanceiro();
                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "3"->{
                //Consultar vendas
                if(gerente.isLogin()){
                    gerente.consultarVendas();
                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }

            }
            case "4" ->{
                //Alterar dados
                if(gerente.isLogin()){
                    System.out.println("\nAlteração de dados");
                    System.out.println("Se quiser alterar os dois dados (Nome e e-mail) informe os dois. ");
                    System.out.println("Se quiser alterar apenas um dado confirme o dado a ser mantido e informe altere apenas o outro. ");
                    System.out.print("Informe o novo nome:  ");
                    String novoNome = teclado.nextLine().strip();
                    System.out.print("Informe o novo e-mail:  ");
                    String novoEmail = teclado.nextLine().strip();
                    gerente.alterarDados(novoNome,novoEmail);
                } else{
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "5"-> {
                //Alterar Senha
                if(gerente.isLogin()){
                    System.out.print("\nInforme a nova senha: ");
                    String novaSenha =teclado.nextLine().strip().toLowerCase();
                    gerente.alterarSenha(novaSenha);
                }else {
                    System.out.println("\nÉ preciso fazer o login");

                }

            }
            case "6"->{
                //Logout
                gerente.logout();
            }
            //Voltar ao menu principal.
            case "0"-> noMenu=false;
            default -> System.out.print("\nOpção invalida.");
        }
    }

}

public void menuVendedor(Vendedor vendedor, Scanner teclado){
    boolean noMenu =true;


    while(noMenu){
    String status = vendedor.isLogin() ? "Logado (" + vendedor.getNome() + ")" : "Deslogado";
    int statusVendas = vendedor.getQuantidadeVendas();

        System.out.println("\n--------------------------------------------------");
        System.out.println("              PAINEL DO VENDEDOR                  ");
        System.out.println("  [Status: " + status + "] |  [Vendas registradas: "+ statusVendas +"]");
        System.out.println("--------------------------------------------------");
        System.out.println("* Fluxo recomendado:\n" +
                "  1º Faça Login (Opção 1)\n" +
                "  2º Lance as vendas realizadas (Opção 2)\n" +
                "  3º Acompanhe o total vendido (Opção 3)");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Realizar Login");
        System.out.println("2 - Realizar Venda (Incrementar)");
        System.out.println("3 - Consultar Vendas Acumuladas");
        System.out.println("4 - Alterar Dados (Nome / E-mail)");
        System.out.println("5 - Alterar Senha");
        System.out.println("6 - Logout");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        String opcao = teclado.nextLine();

        switch (opcao){
            case "1" -> {
                //Login
                System.out.print("\nDigite o nome do usuário: ");
                String usuario = teclado.nextLine().strip();
                System.out.print("Digite a senha: ");
                String senha = teclado.nextLine().strip();
                vendedor.realizarLogin(usuario,senha);

            }
            case "2"-> {
                //Realizar Vendas
                if(vendedor.isLogin()){
                    try {
                    System.out.println("\nInforme a quantidade de produtos vendidos");
                    System.out.print("Qtd: ");
                    int qtdProdutos = teclado.nextInt();
                    teclado.nextLine();
                    vendedor.realizarVendas(qtdProdutos);
                }catch (Exception e){
                        System.out.println("\nSomente é permitido a entrada de números. Qualquer outro caracter não é permitido.\n");
                        teclado.nextLine();
                 }

                }else {
                    System.out.println("\nÉ preciso fazer o login");
                    }
            }
            case "3"->{
                //Consultar vendas
                if(vendedor.isLogin()){
                    vendedor.consultarVendas();
                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }

            }
            case "4" ->{
                //Alterar dados
                if(vendedor.isLogin()){
                    System.out.println("\nAlteração de dados");
                    System.out.println("Se quiser alterar os dois dados (Nome e e-mail) informe os dois. ");
                    System.out.println("Se quiser alterar apenas um dado confirme o dado a ser mantido e informe altere apenas o outro. ");
                    System.out.print("Informe o novo nome:  ");
                    String novoNome = teclado.nextLine().strip();
                    System.out.print("Informe o novo e-mail:  ");
                    String novoEmail = teclado.nextLine().strip();
                    vendedor.alterarDados(novoNome,novoEmail);
                } else{
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "5"-> {
                //Alterar Senha
                if(vendedor.isLogin()){
                    System.out.print("\nInforme a nova senha: ");
                    String novaSenha =teclado.nextLine().strip().toLowerCase();
                    vendedor.alterarSenha(novaSenha);
                }else {
                    System.out.println("\nÉ preciso fazer o login");

                }

            }
            case "6"->{
                //Logout
                vendedor.logout();
            }
            //Voltar ao menu principal.
            case "0"-> noMenu=false;
            default -> System.out.print("\nOpção invalida.\n");

        }
    }
}
public void menuAtendente(Atendente atendente, Scanner teclado){
    boolean noMenu = true;
    while (noMenu){

        String status = atendente.isLogin() ? "Logado (" + atendente.getNome() + ")" : "Deslogado";
        String statusCaixa = atendente.isFuncionamentoCaixa() ?"Aberto | R$ " + atendente.getCaixa() : "Fechado";

        System.out.println("\n--------------------------------------------------");
        System.out.println("              PAINEL DO ATENDENTE                   ");
        System.out.println("  [Status: " + status + "] |  [Caixa: "+ statusCaixa +"]");
        System.out.println("--------------------------------------------------");
        System.out.println("* Fluxo do Caixa:\n" +
                "  1º Faça Login (Opção 1)\n" +
                "  2º Abra o Caixa para iniciar o turno (Opção 2)\n" +
                "  3º Lance os pagamentos recebidos (Opção 3)\n" +
                "  4º Feche o Caixa ao encerrar o expediente (Opção 5)");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Realizar Login");
        System.out.println("2 - Abrir Caixa");
        System.out.println("3 - Receber Pagamento de Venda");
        System.out.println("4 - Consultar Valor Atual em Caixa");
        System.out.println("5 - Fechar Caixa (Zerar saldo)");
        System.out.println("6 - Alterar Dados (Nome / E-mail)");
        System.out.println("7 - Alterar Senha");
        System.out.println("8 - Logout");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        String opcao = teclado.nextLine();

        switch (opcao){
            case "1" -> {
                //Login
                System.out.print("\nDigite o nome do usuário: ");
                String usuario = teclado.nextLine().strip();
                System.out.print("Digite a senha: ");
                String senha = teclado.nextLine().strip();
                atendente.realizarLogin(usuario,senha);

            }
            case "2"-> {
                //Abrir Caixa
                if(atendente.isLogin()){
                    atendente.abrirCaixa();
                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "3"->{
                //Pagamentos das vendas
                if(atendente.isLogin() && atendente.isFuncionamentoCaixa()){
                   try {
                    System.out.printf("Informe o valor das vendas: ");
                    double valor = teclado.nextDouble();
                    teclado.nextLine();
                    atendente.receberPagamentos(valor);
                   } catch (Exception e){
                       System.out.println("\nSomente é permitido a entrada de números. Qualquer outro caracter não é permitido.\n");
                    teclado.nextLine();
                   }
                }else if (atendente.isLogin() && !atendente.isFuncionamentoCaixa()){
                       System.out.println("\nÉ preciso abrir o caixa para lançar o pagamento\n");

                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }

            }
            case "4"-> {

                if (atendente.isLogin()) {
                    System.out.printf("\nValor atualizado do caixa %.2f\n", atendente.getCaixa());
                } else {
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "5"->{
                //Fechar Caixa
                if(atendente.isLogin()){
                    atendente.fecharCaixa();
                }else {
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "6" ->{
                //Alterar dados
                if(atendente.isLogin()){
                    System.out.println("\nAlteração de dados");
                    System.out.println("Se quiser alterar os dois dados (Nome e e-mail) informe os dois. ");
                    System.out.println("Se quiser alterar apenas um dado confirme o dado a ser mantido e informe altere apenas o outro. ");
                    System.out.print("Informe o novo nome:  ");
                    String novoNome = teclado.nextLine().strip();
                    System.out.print("Informe o novo e-mail:  ");
                    String novoEmail = teclado.nextLine().strip();
                    atendente.alterarDados(novoNome,novoEmail);
                } else{
                    System.out.println("\nÉ preciso fazer o login");
                }
            }
            case "7"-> {
                //Alterar Senha
                if(atendente.isLogin()){
                    System.out.print("\nInforme a nova senha: ");
                    String novaSenha =teclado.nextLine().strip().toLowerCase();
                    atendente.alterarSenha(novaSenha);
                }else {
                    System.out.println("\nÉ preciso fazer o login");

                }

            }
            case "8"->{
                //Logout
                atendente.logout();
            }
            //Voltar ao menu principal.
            case "0"-> noMenu=false;
            default -> System.out.print("\nOpção invalida.\n");

        }
    }

}