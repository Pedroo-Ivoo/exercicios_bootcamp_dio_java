# 🚗 Exercício 02: Simulador de Controle de Carro

Este projeto foi desenvolvido como parte dos exercícios do Bootcamp **Itaú - Java com Inteligência Artificial**.

---

## 📌 Descrição do Problema

O objetivo deste exercício é criar um **Simulador de Carro** orientado a objetos, controlando seu estado (ligado/desligado), velocidade, trocas de marcha e direção com base em regras rígidas de segurança e operação.

### 📋 Funções do Veículo:
- Ligar e desligar o carro
- Acelerar (+1 km/h) e desacelerar (-1 km/h)
- Virar para a esquerda ou direita
- Verificar a velocidade e a marcha atual
- Trocar de marcha (0 a 6)

### 📏 Regras de Negócio e Validações:
1. **Estado Inicial:** O carro é instanciado desligado, em ponto morto (marcha 0) e com velocidade de 0 km/h.
2. **Ignição Obrigatória:** Nenhuma ação (acelerar, desacelerar, trocar marcha, virar) pode ser realizada com o carro desligado.
3. **Regra para Desligar:** O veículo só pode ser desligado se estiver totalmente parado (0 km/h) e em ponto morto (marcha 0).
4. **Troca Sequencial de Marchas:** Não é permitido pular marchas (ex: passar da 1ª direto para a 3ª).
5. **Limites de Velocidade por Marcha:**
   - **Marcha 0 (Ponto Morto):** 0 km/h (não permite acelerar)
   - **1ª Marcha:** 0 km/h a 20 km/h
   - **2ª Marcha:** 21 km/h a 40 km/h
   - **3ª Marcha:** 41 km/h a 60 km/h
   - **4ª Marcha:** 61 km/h a 80 km/h
   - **5ª Marcha:** 81 km/h a 100 km/h
   - **6ª Marcha:** 101 km/h a 120 km/h (Velocidade máxima permitida)
6. **Manobras/Direção:** O carro só pode virar para a esquerda ou direita se estiver em movimento entre **1 km/h e 40 km/h**.

---

## 🛠️ Tecnologias e Conceitos Utilizados

Abaixo estão os principais recursos da linguagem **Java** aplicados na solução deste exercício:

- **Orientação a Objetos (POO):**
  - Encapsulamento rigoroso de atributos privados (`ligarCarro`, `velocidade`, `trocarMarcha`, `virar`).
  - Métodos utilitários de apoio (`acelerarOuReduzir`) para evitar duplicação de código.
- **Estruturas de Decisão e Seleção:**
  - `switch-case` com a sintaxe moderna de Java (*Arrow syntax* `->`) utilizado para validação de faixas de velocidade por marcha e para a construção do menu do console.
  - Encadeamento de `if / else` para validação dos limites de velocidade mínimos e máximos antes de alterar o estado do veículo.
- **Entrada de Dados com `Scanner`:**
  - Leitura de escolhas do menu, trocas de marcha e direções informadas pelo usuário.
- **Estruturas de Repetição (`while`):**
  - Loop interativo `while(ligar)` mantendo o simulador rodando até o acionamento explícito da opção de saída (`8`).
- **Tratamento de Exceções (`try-catch` & `throw`):**
  - Lançamento de `IllegalArgumentException` na classe `Carro` para interceptar violações de regras (tentativa de acelerar desligado, troca de marcha incompatível com a velocidade, tentativa de virar parado, etc.).
  - Captura das exceções no menu `Main` via bloco `try-catch`, exibindo a mensagem explicativa sem interromper a execução do simulador.
- **Uso da Classe `Math`:**
  - Aplicação de `Math.abs()` para verificar a diferença absoluta entre marchas e impedir saltos de marcha.

---

## 🚀 Como Executar

1. Certifique-se de ter o **JDK 17+** instalado.
2. Navegue até o diretório do exercício.
3. Compile as classes:
   ```bash
   javac Carro.java Main.java
