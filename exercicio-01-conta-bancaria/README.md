# 🏦 Exercício 01: Sistema de Conta Bancária

Este projeto foi desenvolvido como parte dos exercícios do Bootcamp **Itaú - Java com Inteligência Artificial**.

---

## 📌 Descrição do Problema

O objetivo deste exercício é implementar uma classe que simule uma **Conta Bancária** com suporte a regras de negócio específicas para **Cheque Especial**, saques, depósitos e pagamento de boletos.

### 📋 Operações Disponíveis:
- Consultar saldo
- Consultar cheque especial
- Depositar dinheiro
- Sacar dinheiro
- Pagar boleto
- Verificar uso do cheque especial (com cálculo de juros/taxa)

### 📏 Regras de Negócio:
1. **Definição do Limite do Cheque Especial:**
   - Calculado no **primeiro depósito** realizado na conta.
   - Depósitos $\le$ R$ 500,00: limite fixo de **R$ 50,00**.
   - Depósitos $>$ R$ 500,00: limite equivalente a **50% do valor depositado**.
2. **Uso do Cheque Especial:**
   - Consumido automaticamente caso o saldo próprio seja insuficiente para realizar um saque ou pagar um boleto.
   - Caso o limite do cheque especial seja utilizado, aplica-se uma taxa/juros de **20% sobre o valor utilizado**.

---

## 🛠️ Tecnologias e Conceitos Utilizados

Abaixo estão os principais recursos da linguagem **Java** aplicados na solução deste exercício:

- **Orientação a Objetos (POO):**
  - Encapsulamento de atributos (`private`) e disponibilização de métodos públicos getter e de manipulação.
  - Abstração e reuso de lógica (ex: o método `pagarBoleto()` reutiliza a lógica de `sacar()`).
- **Entrada de Dados com `Scanner`:**
  - Leitura de dados inseridos pelo usuário via terminal (`teclado.nextInt()`, `teclado.nextDouble()`).
- **Estruturas de Repetição (`while`):**
  - Mantém o menu interativo rodando em loop até que o usuário escolha a opção de sair (opção `07`).
- **Estruturas de Decisão (`switch-case` & `if / else`):**
  - `switch-case` com a sintaxe moderna de Java (*Arrow syntax* `->`) para direcionamento do menu.
  - Validações de limites e saldo usando `if / else`.
- **Tratamento de Exceções (`try-catch` & `throw`):**
  - Lançamento manual de exceções com `throw new IllegalArgumentException(...)` na classe `Conta` para validar entradas inválidas ou saldo insuficiente.
  - Captura das exceções no método `main` usando `try-catch`, exibindo mensagens amigáveis ao usuário sem interromper a execução do programa.
- **Saída Formatada (`System.out.printf`):**
  - Formatação de valores monetários utilizando `%.2f`.

---

## 🚀 Como Executar

1. Certifique-se de ter o **JDK 17+** instalado em sua máquina.
2. Clone o repositório ou navegue até a pasta deste exercício.
3. Compile os arquivos Java:
   ```bash
   javac Conta.java Main.java
