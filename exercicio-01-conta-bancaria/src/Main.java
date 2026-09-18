import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var carro = new Carro();
        Scanner teclado = new Scanner(System.in);
        boolean ligar = true;

        System.out.println("Simulador de direção");
        System.out.println("1 - Ligar o carro");
        System.out.println("2 - Desligar o carro");
        System.out.println("3 - Acelerar o carro");
        System.out.println("4 - Desacelerar o carro");
        System.out.println("5 - Virar o carro");
        System.out.println("6 - Exibir a velocidade do carro");
        System.out.println("7 - Mudar a marcha do carro");
        System.out.println("8 - Sair do simulador de direção");

        while(ligar){
            System.out.print("\nEscolha ação para dirigir: ");
            int opcao = teclado.nextInt();

            switch (opcao){
                case 1 -> {
                    carro.darPartida();
                    System.out.println("Carro Ligado");
                }
                case 2 -> {
                    try {
                        carro.desligarCarro();
                        System.out.println("Carro desligado");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        carro.setAcelerar(1);
                        System.out.println("Carro acelerou! Velocidade atual: " + carro.getVelocidade() + " km/h");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        carro.setDesacelerar(2);
                        System.out.println("Carro desacelerou! Velocidade atual: " + carro.getVelocidade() + " km/h");
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Digite a direção que quer virar (1 - Direita ou 2 - Esquerda): ");
                        int direcao = teclado.nextInt();
                        carro.setMudarDirecao(direcao);
                        System.out.printf("O carro virou para a %s \n", carro.getVirar());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.printf("A velocidade do carro é %d km/h | Marcha: %d\n", carro.getVelocidade(), carro.getTrocarMarcha());
                }
                case 7 -> {
                    try {
                        System.out.print("Coloque a marcha de 0 a 6: ");
                        int marcha = teclado.nextInt();
                        carro.marcha(marcha);
                        System.out.printf("A marcha está na %d \n", carro.getTrocarMarcha());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 8 -> {
                    System.out.println("Encerrar o programa...");
                    ligar = false;
                    System.out.println("Até a próxima!");
                }
                default -> System.out.println("Opção inválida! Escolha um número de 1 a 8.");
            }
        }

        teclado.close();
    }
}
