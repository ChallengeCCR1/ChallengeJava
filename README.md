# 🚇 Challenge Java - Previsão de Pico nas Estações da CCR

Este projeto foi desenvolvido com o objetivo de prever horários de pico nas estações da CCR, oferecendo funcionalidades adicionais como mapa de linhas, status em tempo real, simulação de viagens e geração de relatórios. A aplicação é integrada a um banco de dados **Oracle** e utiliza APIs Python (Flask) em conjunto com Java (Quarkus) para entregar um sistema robusto e interativo.

---

## 📌 Funcionalidades

- 🔍 **Previsão de Pico** nas estações
- 🗺️ **Mapa** das linhas da CCR (Linha 9 Esmeralda, entre outras)
- 🚦 **Status das Linhas** em tempo real
- 🚉 **Início de Viagens** entre estações
- 📄 **Relatórios personalizados** por usuário
- 🔄 Integração entre backend Java e microserviços Python

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java** | Lógica principal e controle das viagens/relatórios |
| **Maven** | Gerenciador de dependências Java |
| **Quarkus** | Framework Java para microsserviços e APIs |
| **Python + Flask** | APIs para previsão de pico, mapa e status |
| **Oracle DB** | Banco de dados relacional |
| **POO** | Projeto estruturado com Programação Orientada a Objetos |

---

## 🚀 Como Rodar o Projeto Localmente

### Pré-requisitos

- Java 17 ou superior
- Maven
- Python 3.10+
- Oracle DB (com as tabelas e dados configurados)
- Git

### Passos

1. **Clone o repositório:**

bash
git clone https://github.com/ChallengeCCR1/ChallengeJava.git
cd ChallengeJava

Configure o banco de dados Oracle:

Certifique-se de que o Oracle DB está ativo.

Atualize as credenciais e strings de conexão no projeto Java.

Execute a API Python (Flask):

cd api-python  # ajuste se o nome da pasta for diferente
pip install -r requirements.txt
python app.py

Execute a aplicação Java (Quarkus):

cd challenge-java
./mvnw quarkus:dev

## 🔗 Endpoints Disponíveis

### API Java (consome a API de Python | Link: https://api-previsao-pico.onrender.com

| Método | Endpoint                                                       | Descrição                                    |
|--------|----------------------------------------------------------------|----------------------------------------------|
| GET    | `/api/mapa/linha9`                                             | Retorna dados da Linha 9                     |
| GET    | `/api/previsao?estacao=Pinheiros&horario=08:00`               | Previsão de pico por estação e horário       |
| GET    | `/api/previsao/grafico?estacao=NomeDaEstacao`                 | Dados para gerar gráfico da estação          |
| GET    | `/status-linhas/diamante`                                     | Status da Linha 8 (Diamante)                 |

### ☕ API Java (não consome nenhuma API externa)

| Método | Endpoint                                                        | Descrição                                    |
|--------|------------------------------------------------------------------|----------------------------------------------|
| POST   | `/api/viagem/iniciar`                                           | Inicia uma nova viagem                       |
| GET    | `/relatorio/usuario/162?usuario=Fulano`                         | Retorna relatório de viagens do usuário      |

---

📊 Exemplo de Requisição
POST /api/viagem/iniciar
Content-Type: application/json

{<br>
  "usuarioId": 221, <br>
  "estacaoOrigemId": 102, <br>
  "estacaoDestinoId": 110, <br>
  "hPartida": "2025-05-04T15:00:00" <br>
}<br>

## 👥 Autores

| Nome             | Função                        |
|------------------|-------------------------------|
| Pedro Sena       | Desenvolvedor Backend         |
| Matteus Viegas   | Desenvolvedor FrontEnd        |
| Sulamita Viegas  | Gestora de Negócios           |
| CCR              | Apoio e idealização           |

