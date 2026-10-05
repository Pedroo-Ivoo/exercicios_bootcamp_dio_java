 🎟️ Exercício 03: Sistema de Venda de Ingressos de Cinema

Este projeto foi desenvolvido como parte dos exercícios do Bootcamp **Itaú - Java com Inteligência Artificial**.

---

## 📌 Descrição do Problema

O objetivo deste exercício é implementar uma hierarquia de classes em **Java** para tratar os diferentes tipos de ingressos comercializados em um cinema (**Ingresso Normal**, **Meia Entrada** e **Ingresso Família**), aplicando os conceitos de herança e polimorfismo para o cálculo do valor real/total da compra.

### 📋 Operações Disponíveis:
- Escolher o tipo de ingresso (Normal, Meia Entrada ou Família)
- Selecionar o filme desejado
- Informar se o filme é Dublado ou Legendado
- Definir a quantidade de ingressos
- Visualizar o resumo com os detalhes e o valor total calculado com desconto aplicado

### 📏 Regras de Negócio:
1. **Atributos do Ingresso Base (`Ingresso`):**
   - Possui valor unitário, nome do filme, quantidade e indicação de legenda (dublado/legendado).
   - O cálculo do valor total padrão é dado pela quantidade de ingressos multiplicada pelo valor unitário (`quantidade * valor`).
2. **Meia Entrada (`MeiaEntrada`):**
   - Herda de `Ingresso`.
   - Aplica **50% de desconto** sobre o valor total do ingresso.
3. **Ingresso Família (`IngressoFamilia`):**
   - Herda de `Ingresso`.
   - Concede um **desconto especial de 5%** sobre o valor total caso a quantidade de ingressos adquiridos seja **maior que 3 pessoas**.

---

## 🛠️ Tecnologias e Conceitos Utilizados

Abaixo estão os principais recursos da linguagem **Java** aplicados na solução deste exercício:

- **Orientação a Objetos (POO):**
  - **Herança (`extends`):** Reuso de atributos e construtores da classe mãe `Ingresso` através da palavra-chave `super()`.
  - **Sobrescrita de Métodos (`@Override`):** Redefinição do método `getTotal()` nas subclasses para aplicar as regras de desconto específicas.
  - **Polimorfismo e `instanceof`:** Verificação dinâmica do tipo de objeto no momento da impressão para exibir mensagens personalizadas.
  - **Encapsulamento:** Proteção dos atributos com modificadores `private` e métodos de acesso `get/set`.
- **Entrada de Dados com `Scanner`:**
  - Leitura de texto e números via terminal (`teclado.nextLine()`, `teclado.nextInt()`) com limpeza adequada do buffer.
- **Estruturas de Decisão (`switch-case` & `if / else`):**
  - `switch-case` com *Arrow syntax* (`->`) para seleção do tipo de ingresso.
  - `if / else` para verificação de legendas e validação da quantidade de pessoas para aplicação do desconto família.
- **Saída Formatada (`System.out.printf`):**
  - Formatação de valores monetários utilizando `%.2f`.

---

## 🚀 Como Executar

1. Certifique-se de ter o **JDK 17+** (ou JDK 21+) instalado em sua máquina.
2. Clone o repositório ou navegue até a pasta deste exercício.
3. Compile os arquivos Java:
   ```bash
   javac Ingresso.java MeiaEntrada.java IngressoFamilia.java Main.java
