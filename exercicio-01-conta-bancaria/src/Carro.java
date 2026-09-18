public class Carro {
    private Boolean ligarCarro;
    private int acelerar = 1;
    private int reduzir = -1;
    private String virar;
    private int velocidade;
    private int trocarMarcha;

    /**
     * Construtor do Carro.
     * Inicializa o veículo desligado, em ponto morto (marcha 0) e parado (velocidade 0).
     */
    public Carro(){
        this.ligarCarro = false;
        this.velocidade = 0;
        this.trocarMarcha = 0;
    }

    /**
     * Obtém a última direção para a qual o carro virou.
     *
     * @return direção atual ("Direita" ou "Esquerda").
     */
    public String getVirar(){
        return virar;
    }

    /**
     * Obtém a marcha atualmente engatada no carro.
     *
     * @return número da marcha atual (0 a 6).
     */
    public int getTrocarMarcha(){
        return trocarMarcha;
    }

    /**
     * Obtém a velocidade atual do carro.
     *
     * @return velocidade em km/h.
     */
    public int getVelocidade(){
        return velocidade;
    }

    /**
     * Liga o carro e ativa a ignição.
     */
    public void darPartida(){
        this.ligarCarro = true;
    }


    /**
     * Desliga o carro se ele estiver totalmente parado e no ponto morto.
     *
     * @throws IllegalArgumentException se o carro estiver em movimento (velocidade > 0)
     *                                  ou se a marcha não estiver no ponto morto (marcha != 0).
     */
    public void desligarCarro(){
        // O carro só pode ser desligado totalmente parado e em ponto morto
        if (this.velocidade==0 && this.trocarMarcha==0){
            this.ligarCarro = false;
        } else {
            throw new IllegalArgumentException("Não é possível parar o carro. Reduza a velocidade a 0 e coloque a marcha no ponto morto para desligar.");
        }
    }

    /**
     * Incrementa ou decrementa a velocidade do carro em 1 km/h.
     *
     * @param entrada 1 para acelerar (+1 km/h) ou qualquer outro valor para reduzir (-1 km/h).
     */
    public void acelerarOuReduzir(int entrada){
        if(entrada==1){
            this.velocidade += acelerar;
        } else {
            this.velocidade += reduzir;
        }
    }

    /**
     * Altera a marcha do veículo validando a ignição, a sequência de marchas
     * e a compatibilidade com a velocidade atual.
     *
     * @param marcha nova marcha a ser engatada (de 0 a 6).
     * @throws IllegalArgumentException se o carro estiver desligado;
     *                                  se a marcha informada for inválida (fora de 0 a 6);
     *                                  se houver tentativa de pular marcha;
     *                                  se a velocidade atual for incompatível com a nova marcha.
     */
    public void marcha(int marcha){
        // 1. O carro precisa estar ligado
        if(!this.ligarCarro){
            throw new IllegalArgumentException("O carro precisa estar ligado para trocar de marcha.");
        }

        // 2. Valida se a marcha existe no intervalo permitido
        if (marcha < 0 || marcha > 6){
            throw new IllegalArgumentException("A marcha " + marcha + " não existe! O carro possui apenas as marchas de 0 a 6.");
        }

        // 3. Impede pular marcha (a diferença entre a atual e a nova não pode ser maior que 1)
        if(Math.abs(marcha - this.trocarMarcha) > 1){
            throw new IllegalArgumentException("Não é permitido pular marcha! Você está na marcha "
                    + this.trocarMarcha + " e não pode ir direto para a " + marcha + ".");
        }

        // 4. Valida se a velocidade atual é compatível com a nova marcha
        boolean velocidadeCompativel = switch (marcha) {
            case 0 -> this.velocidade == 0;
            case 1 -> this.velocidade >= 0 && this.velocidade <= 20;
            case 2 -> this.velocidade >= 21 && this.velocidade <= 40;
            case 3 -> this.velocidade >= 41 && this.velocidade <= 60;
            case 4 -> this.velocidade >= 61 && this.velocidade <= 80;
            case 5 -> this.velocidade >= 81 && this.velocidade <= 100;
            case 6 -> this.velocidade >= 101 && this.velocidade <= 120;
            default -> false;
        };

        if (!velocidadeCompativel) {
            throw new IllegalArgumentException("Velocidade incompatível! A " + marcha
                    + "ª marcha não comporta a velocidade atual de " + this.velocidade + " km/h.");
        }

        // Se passou em todas as validações, engata a marcha
        this.trocarMarcha = marcha;
    }

    /**
     * Acelera o carro em 1 km/h, respeitando o limite máximo da marcha atual.
     *
     * @param entrada valor de controle para acelerar (espera 1).
     * @throws IllegalArgumentException se o carro estiver desligado;
     *                                  se o carro já estiver na velocidade máxima permitida (120 km/h);
     *                                  se atingir o limite da marcha atual e for necessário engatar a próxima.
     */
    public void setAcelerar(int entrada){
        if (this.ligarCarro){
            // Verifica se a velocidade atual permite aceleração dentro da marcha engatada
            if(this.trocarMarcha==1 && this.velocidade <=20){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha==2 && this.velocidade<=40){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha==3 && this.velocidade<=60){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha==4 && this.velocidade<=80){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha==5 && this.velocidade<=100){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha==6 && this.velocidade<120){
                acelerarOuReduzir(entrada);
            }else if(this.velocidade==120){
                throw new IllegalArgumentException("O carro já está na velocidade máxima permitida (120 km/h).");
            }else {
                throw new IllegalArgumentException("Troque a marcha para continuar acelerando.");
            }
        } else {
            throw new IllegalArgumentException("Para acelerar é preciso ligar o carro.");
        }
    }

    /**
     * Desacelera o carro em 1 km/h, respeitando o limite mínimo da marcha atual.
     *
     * @param entrada valor de controle para desacelerar.
     * @throws IllegalArgumentException se o carro estiver desligado;
     *                                  se o carro já estiver completamente parado (0 km/h);
     *                                  se for necessário reduzir a marcha para continuar desacelerando.
     */
    public void setDesacelerar(int entrada){
        if(this.ligarCarro){
            // Verifica o limite inferior de velocidade suportado pela marcha atual
            if(this.trocarMarcha==6 && this.velocidade>=101){
                acelerarOuReduzir(entrada);
            }else if(this.trocarMarcha==5 && this.velocidade>=81){
                acelerarOuReduzir(entrada);
            }else if(this.trocarMarcha==4 && this.velocidade>=61) {
                acelerarOuReduzir(entrada);
            }else if(this.trocarMarcha==3 && this.velocidade>=41){
                acelerarOuReduzir(entrada);
            }else if (this.trocarMarcha == 2 && this.velocidade>=21){
                acelerarOuReduzir(entrada);
            }else if(this.trocarMarcha ==1 && this.velocidade<21 && this.velocidade>0){
                acelerarOuReduzir(entrada);
            } else if (this.velocidade==0) {
                throw new IllegalArgumentException("O carro já está parado. Para desligar, coloque a marcha em ponto morto.");
            } else {
                throw new IllegalArgumentException("Troque a marcha para continuar desacelerando.");
            }
        } else {
            throw new IllegalArgumentException("Para desacelerar é preciso ligar o carro.");
        }
    }

    /**
     * Altera a direção do veículo para direita ou esquerda.
     * A manobra só é permitida se o carro estiver ligado e em movimento entre 1 km/h e 40 km/h.
     *
     * @param direcao código da direção (1 para Direita, 2 para Esquerda).
     * @throws IllegalArgumentException se o carro estiver desligado;
     *                                  se o código informado for inválido (diferente de 1 e 2);
     *                                  se o carro estiver parado ou acima de 40 km/h.
     */
    public void setMudarDirecao(int direcao){
        if (this.ligarCarro){
            // O veículo só pode virar se estiver em movimento entre 1 km/h e 40 km/h
            if(direcao == 1 && this.velocidade>=1 && this.velocidade <=40){
                this.virar = "Direita";
            } else if (direcao == 2 && this.velocidade>=1 && this.velocidade<=40) {
                this.virar = "Esquerda";
            } else if (direcao!=1 && direcao!=2) {
                throw new IllegalArgumentException("Erro de instrução. A direção deve ser 1 para Direita ou 2 para Esquerda.");
            } else {
                throw new IllegalArgumentException("O carro não pode virar se estiver parado ou acima de 40 km/h.");
            }
        } else {
            throw new IllegalArgumentException("Para virar o carro é preciso que ele esteja ligado e em movimento.");
        }
    }
}
