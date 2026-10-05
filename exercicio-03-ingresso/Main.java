void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    Ingresso ingressoEscolhido = null;


    System.out.println("===Venda de ingressos do Cinema===");
    System.out.print("Escolha o tipo de ingresso (Normal, Meia Entrada, Familia): ");
    String opcao = teclado.nextLine();
    System.out.print("Escolha o filme: ");
    String escolhaFilme = teclado.nextLine();
    System.out.print("Dublado ou Legendado: ");
    String tipoAudio = teclado.nextLine().toLowerCase().strip();
    //Verifica se é Legendado se for é true do contrário é false.
    boolean ehlegendado = tipoAudio.equalsIgnoreCase("legendado");
    System.out.print("Quantos ingressos: ");
    int qdtIngressos = teclado.nextInt();
    teclado.nextLine();

    switch (opcao.toLowerCase().strip()){
        case "normal" ->{
            ingressoEscolhido = new Ingresso(60, ehlegendado, qdtIngressos, escolhaFilme);
        }
        case "meia entrada" ->{
            ingressoEscolhido = new MeiaEntrada(60, ehlegendado,qdtIngressos,escolhaFilme);
        }
        case "familia" ->{
            ingressoEscolhido = new IngressoFamilia(60, ehlegendado, qdtIngressos, escolhaFilme);
        }
        default -> {
            System.out.println("Opção inválida.");
        }

    }
        if (ingressoEscolhido != null) {
            imprimirIngresso(ingressoEscolhido);
        }

}

/**
 * Método de impressão dos ingressos.
 * @param ingresso Recebe o objeto do ingresso e imprime os dados relativos a ele.
 */
    void imprimirIngresso(Ingresso ingresso){
        System.out.println("\n== Detalhes do Ingresso ==");
        System.out.println("Filme: " + ingresso.getNomeFilme());
        System.out.println("Valor base: R$ " + ingresso.getValor());
        ingresso.exibirStatusLegenda();
        System.out.println("Quantidade: " + ingresso.getQuantidade());
        // Se for MeiaEntrada:
        if (ingresso instanceof MeiaEntrada) {
            System.out.println("Tipo: Meia Entrada (50% de desconto aplicado)");
        }
        // Se for IngressoFamilia:
        else if (ingresso instanceof IngressoFamilia familia) {
            System.out.println("Tipo: Ingresso Família");
            if (familia.getQuantidade() > 3) {
                System.out.println("Desconto especial de 5% aplicado por ser mais de 3 pessoas!");
            }
        }
        // Se for o Ingresso padrão:
        else {
            System.out.println("Tipo: Ingresso Normal/Padrão");
        }
        System.out.printf("Valor Total a pagar: R$ %.2f\n", ingresso.getTotal());
    }
