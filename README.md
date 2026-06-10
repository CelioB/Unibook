# Unibook
 <div align="center">

# 📚 UNIBOOK

### Plataforma Bibliográfica Inteligente para a Unifor

*Uma biblioteca que pensa com você.*

---

[![Android](https://img.shields.io/badge/Android-8.0%2B-brightgreen?logo=android)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blueviolet?logo=kotlin)](https://kotlinlang.org)
[![Android Studio](https://img.shields.io/badge/Android%20Studio-Hedgehog-blue?logo=androidstudio)](https://developer.android.com/studio)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)]()
[![Licença](https://img.shields.io/badge/Licença-Acadêmica-lightgrey)]()

</div>

---

## 📌 Sobre o Projeto

O **UNIBOOK** é um aplicativo mobile desenvolvido para modernizar a experiência dos estudantes da **Universidade de Fortaleza (Unifor)** com a biblioteca física do campus.

O sistema atual da biblioteca apresenta plataformas fragmentadas, instáveis e sem integração com a vida acadêmica do aluno — o que leva muitos estudantes a abandonar o acervo físico em favor de arquivos digitais informais. O UNIBOOK resolve isso unificando toda a gestão bibliográfica em um único aplicativo intuitivo, e vai além: incorpora uma **camada social colaborativa** e um **módulo de IA** para recomendações personalizadas por curso, semestre e professor.

### O que o app oferece

- **Gestão completa de empréstimos e reservas** com notificações push de devolução
- **Mapa interativo da biblioteca** com localização física de livros por estante e corredor
- **Sistema de avaliações e notas** da comunidade (alunos, professores e monitores)
- **Recomendações inteligentes** filtradas por curso, semestre e docente
- **Azure Scholar** — IA que gera planos de estudo personalizados com cronograma de leitura
- **QR Code de entrada** para controle de acesso e registro na biblioteca
- **Gestão de armários** compartilhados com chat integrado entre usuários
- **Painel administrativo** completo para o bibliotecário gerenciar acervo e empréstimos

---

## 👥 Equipe

| Papel | Nome |
|---|---|
| 👨‍💻 Developer | Davi Noronha Lima |
| 👨‍💻 Developer | Francisco Marinho |
| 👨‍💻 Developer | Gabriel Rya Vieira Viena |
| 👨‍💻 Developer | Célio Roberto Araújo Barguil |
| 👨‍💻 Developer | João Pedro Nunes |

> **Disciplina:** Desenvolvimento de Plataformas Móveis  
> **Curso:** Ciência da Computação — Turma T197  
> **Professor:** Pedro Pinheiro  
> **Instituição:** Universidade de Fortaleza — Unifor  
> **Período:** 3 · Turno M35AB · 2026

---

## Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| **Kotlin** | Linguagem principal de desenvolvimento Android |
| **Android Studio** | IDE de desenvolvimento |
| **Android 8.0+ (API 26)** | Versão mínima de compatibilidade |
| **SUAP API** | Autenticação e validação de matrícula dos alunos |
| **Firebase / Push Notifications** | Notificações de devolução e alertas de reserva |
| **QR Code Scanner** | Controle de entrada de alunos na biblioteca |
| **HTTPS / Criptografia** | Comunicação segura com o backend |
| **LGPD (Lei 13.709/2018)** | Conformidade no tratamento de dados pessoais |
| **Figma** | Estruturação Inicial |

---

## Como Executar o Projeto

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- [Android Studio](https://developer.android.com/studio) (versão Hedgehog ou superior)
- JDK 17+
- Android SDK com API Level 26 ou superior
- Dispositivo físico ou emulador Android configurado
-  - Mais detalhes: Android Studio Panda 4 | 2025.3.4
Build #AI-253.32098.37.2534.15232325, built on April 17, 2026
Runtime version: 21.0.10+-14961533-b1163.108 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.awt.windows.WToolkit
Windows 11.0
 | ide.instant.shutdown=false
 | ide.experimental.ui=true


### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/unibook.git
cd unibook
```

**2. Abra no Android Studio**

Vá em `File → Open` e selecione a pasta raiz do projeto.

**3. Sincronize as dependências**

Aguarde o Android Studio sincronizar automaticamente o Gradle. Se necessário, clique em **"Sync Project with Gradle Files"**.

**4. Execute o aplicativo**

Selecione o dispositivo/emulador no menu superior e clique em **Run ▶** ou pressione `Shift + F10`.

---

## Telas no Figma (estruturação da ideia)

O protótipo das interfaces do aluno e do administrador está disponível no Figma:

🔗 **[Acessar Protótipo no Figma](https://www.figma.com/board/kCUgvED7S5FGqebCgUqTbg/Prot%C3%B3tipo-de-Alta-Fidelidade---Narak)**

O protótipo cobre as telas protótipo de:
- Onboarding e autenticação
- Tela inicial e navegação geral
- Busca, filtros e detalhes de livros
- Reserva e acompanhamento de empréstimos
---

## Atores do Sistema

| Ator | Descrição |
|---|---|
| **Aluno** | Pesquisa, reserva e acompanha livros; avalia obras; usa o plano de estudos por IA |
| **Administrador** | Gerencia empréstimos, acervo, alunos bloqueados e controle de entrada via QR Code |
| **Professor** | Recomenda livros por disciplina; consulta disponibilidade do acervo |

---

##  Principais Requisitos Implementados

### Funcionais
| Código | Descrição | Prioridade |
|---|---|---|
| RF01 / RF02 | Cadastro e login com validação de matrícula e e-mail institucional | Alta |
| RF07 | Tela inicial com empréstimos, reservas, alertas e QR Code | Alta |
| RF09 | Busca de livros por título, autor, curso ou professor | Alta |
| RF17 | Detalhes do livro com status de exemplares e localização física | Alta |
| RF21 | Plano de estudos gerado por IA com cronograma de leitura | Alta |
| RF36 | Painel administrativo de gestão de empréstimos | Alta |

### Não Funcionais
| Código | Descrição | Prioridade |
|---|---|---|
| RNF01 | Desenvolvido em Kotlin com Android Studio | Alta |
| RNF02 | Compatível com Android 8.0 (API 26) ou superior | Alta |
| RNF03 | Tempo de resposta inferior a 2 segundos em 90% das consultas | Alta |
| RNF04 | Armazenamento de dados em conformidade com a LGPD | Alta |
| RNF05 | Integração com o sistema acadêmico SUAP para autenticação | Alta |

---

## Metodologia de Desenvolvimento

O projeto foi desenvolvido com a metodologia **Scrum**, seguindo ciclos iterativos de Sprints:

```
Product Backlog → Sprint Planning → Desenvolvimento → Testes → Revisão → Entrega
```

Referência: SCHWABER, Ken; SUTHERLAND, Jeff. *The Scrum Guide*. Scrum.org, 2020.

---

## Licença

Este projeto foi desenvolvido para fins acadêmicos na Universidade de Fortaleza (Unifor) como parte da disciplina de **Desenvolvimento de Plataformas Móveis**. Todos os direitos reservados aos autores.

---

<div align="center">

Feito com 📚 — Unifor 2026

</div>
