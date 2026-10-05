# 🏢 Exercício 04: Sistema de Gestão Empresarial

Este projeto foi desenvolvido como parte dos exercícios do Bootcamp **Itaú - Java com Inteligência Artificial**.

---

## 📌 Descrição do Problema

O objetivo deste exercício é desenvolver uma hierarquia de classes em **Java** para gerenciar diferentes perfis de funcionários de uma empresa (**Gerente**, **Vendedor** e **Atendente**), permitindo controle de login/logout, alteração de credenciais e operações específicas para cada cargo.

### 📋 Operações Disponíveis:
- Autenticação de usuários (`Login` e `Logout`)
- Alteração segura de dados cadastrais (Nome, E-mail e Senha)
- **Painel do Gerente:** Geração de relatórios financeiros e consulta consolidada de vendas.
- **Painel do Vendedor:** Lançamento/incremento de vendas e consulta de vendas acumuladas.
- **Painel do Atendente:** Controle completo de caixa (Abertura, Recebimento de Pagamentos, Consulta de Saldo e Fechamento com zeramento de saldo).

### 📏 Regras de Negócio:
1. **Funcionário Base (`Funcionario`):**
   - Armazena nome, e-mail, senha, status de administrador e status de sessão (`login`).
   - Bloqueia o acesso às funcionalidades caso o funcionário não esteja logado no sistema.
   - A alteração de senha exige que a nova senha seja diferente da atual.
2. **Gerente (`Gerente`):**
   - Possui perfil de administrador (`administrador = true`).
   - Acesso exclusivo para gerar relatórios financeiros e consultar métricas de vendas do período.
3. **Vendedor (`Vendedor`):**
   - Mantém um contador acumulativo de vendas.
   - Permite registrar vendas informando valores estritamente positivos.
4. **Atendente (`Atendente`):**
   - Gerencia o status e o saldo do caixa.
   - O recebimento de pagamentos só é permitido com o caixa **Aberto** e para valores positivos.
   - Ao fechar o caixa, exibe o valor total acumulado e zera o saldo em caixa.

---

## 🛠️ Tecnologias e Conceitos Utilizados

Abaixo estão os principais recursos da linguagem **Java** aplicados na solução deste exercício:

- **Orientação a Objetos (POO):**
  - **Herança (`extends`):** Reuso de estrutura, credenciais e métodos de autenticação da classe base `Funcionario`.
  - **Encapsulamento:** Proteção de atributos sensíveis (como `senha`, `caixa` e `login`) com controle de acesso via getters e métodos modificadores.
- **Entrada de Dados com `Scanner`:**
  - Leitura interativa via terminal com sanitização de texto utilizando `.strip()` e `.toLowerCase()`.
- **Estruturas de Repetição (`while`):**
  - Navegação fluida mantendo menus e submenus interativos rodando em loop até o comando de voltar ou encerrar.
- **Estruturas de Decisão (`switch-case`, `if / else` & Operador Ternário):**
  - `switch-case` para direcionamento das opções nos menus interativos.
  - Operador ternário (`? :`) para exibição dinâmica dos status de login e caixa no cabeçalho do console.
- **Tratamento de Exceções (`try-catch`):**
  - Captura de erros de entrada de dados (`try-catch`) nos menus do Vendedor e Atendente para evitar falhas ao ler valores numéricos com `Scanner`.
- **Saída Formatada (`System.out.printf`):**
  - Formatação de valores monetários e mensagens do sistema utilizando `%.2f`.

---
