### 3.3.5 Processo 5 – Peças e montagens

Informa o cliente sobre as peças e ajuda na compra de peças se preciso.

![Diagrama processo 5](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1381100-AUTOMECH/assets/125467584/9eede698-aade-4e33-9c9e-76a027a498b5)

#### Detalhamento das atividades

A oficina verifica se sera preciso peças para o veiculo.
O cliente se preciso compra as peças e envia para a oficina.
A oficina envia o veiculo realiza o reparo e a instalaçao e informa ao cliente.

**Verifica a Nescessidade de peças**
Aqui a oficina verifica a nescessidade de peças

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| peças | numeros  |                | peças pedidas   | null              |
| tipo de peça           | Caixa de Texto   | mínimo de 8 digitos |null    |


| **Comandos**       | **Destino**         | **tipo** |
| ---             | ---              | ---            |
| Next | Informa ao cliente e ajuda na aquisição ou envio de peças para a oficina   | Next            |


**Informa ao cliente e ajuda na aquisiçao de peças**
Caso seja preciso novas peças e enviado ao cliente um email com as peças o com o valor delas.
| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Peças e valor |  descrição | maximo de 500 caracteres |                 |

| **Comandos**       | **Destino**         | **tipo** |
| ---             | ---              | ---            |
| Confirmar | nenhum | Confirmação |

**Confirma o envio de peças para oficina**
Aqui envia uma notificação para a oficina que as peças foram compradas e podera ser dado seguimento na montagem.

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|Caixa de mensagem| mensagem | maximo de 100 caracteres|  |

| **Comandos**       | **Destino**         | **tipo** |
| ---             | ---              | ---            |
| confirmção | Realiza a montagem e instalação | envio |

**Realiza a montagem e instaçao**
| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Notificaçao | campo de texto | maximo de 500 caaracters| veiculo pronto|





