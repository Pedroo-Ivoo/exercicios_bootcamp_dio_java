# 🚀 Exercícios - Bootcamp Itaú | Java com Inteligência Artificial

Bem-vindo(a) ao repositório! Aqui compartilho as minhas resoluções para os exercícios práticos desenvolvidos durante o Bootcamp **Itaú - Java com Inteligência Artificial**.

O objetivo deste repositório é documentar minha evolução na linguagem **Java**, demonstrando na prática a aplicação dos conceitos fundamentais de **Programação Orientada a Objetos (POO)**, validação de regras de negócio e boas práticas de desenvolvimento.

---

## 🛠️ Tecnologias & Conceitos Aplicados

Em todos os exercícios desenvolvidos neste módulo, foram praticados os seguintes tópicos:

- **Programação Orientada a Objetos (POO):** Encapsulamento, Abstração, Herança (`extends`), Sobrescrita de Métodos (`@Override`), Polimorfismo, Reuso de Construtores (`super()`) e checagem de tipos com `instanceof`.
- **Controle de Acesso e Autenticação:** Gestão de estado de sessão (`login`/`logout`), controle de níveis de permissão (administrador vs. padrão) e validações para alteração de credenciais.
- **Estruturas de Controle e Decisão:** `if / else`, operador ternário (`? :`), `switch-case` com *Arrow Syntax* (Java 17+) e laços de repetição (`while`).
- **Tratamento de Exceções:** Lançamento explícito de exceções (`throw new IllegalArgumentException`) para garantir integridade do domínio e tratamento de erros no console com blocos `try-catch`.
- **Entrada/Saída de Dados:** Leitura interativa via terminal (`Scanner`), limpeza de buffer (`nextLine()`), higienização de entradas (`strip()`, `toLowerCase()`) e formatação de valores monetários e numéricos com `System.out.printf`.
- **Documentação com Javadoc:** Utilização de comentários estruturados (`/** ... */`) com tags como `@param`, `@return` e `@throws` para documentar a finalidade, parâmetros, retornos e exceções lançadas por cada método do sistema.
---

## 📁 Estrutura do Repositório & Exercícios

Cada exercício possui sua pasta dedicada contendo o código fonte e um `README` explicativo detalhando os requisitos e regras de negócio específicas:

| Exercício | Descrição / Domínio | Conceitos Destacados | Link |
| :--- | :--- | :--- | :---: |
| **01. Conta Bancária** | Sistema bancário com regras de saque, depósito, pagamento de boleto e limite dinâmico de cheque especial. | POO, `try-catch`, validação de saldo e cálculo de juros. | [Acessar](./exercicio-01-conta-bancaria/) |
| **02. Controle de Carro** | Simulador de veículo controlando ignição, trocas sequenciais de marcha e limites de velocidade. | POO, validação de regras complexas, `Math.abs()`, `switch-case`. | [Acessar](./exercicio-02-carro/) |
| **03. Cinema - Ingressos** | Sistema de venda de ingressos com regras para Meia Entrada (50% desc.) e Ingresso Família (5% desc. acima de 3 pessoas). | POO, Herança (`extends`), Sobrescrita (`@Override`), Polimorfismo e `instanceof`. | [Acessar](./exercicio-03-ingresso/) |
| **04. Gestão Empresarial** | Sistema corporativo com perfis de Gerente, Vendedor e Atendente, controle de login, relatórios e gestão de caixa. | Herança, Encapsulamento, Operadores Ternários, Tratamento de Exceções (`try-catch`) e Menus Interativos. | [Acessar](./exercicio-04-gestao-empresarial/) |

---

