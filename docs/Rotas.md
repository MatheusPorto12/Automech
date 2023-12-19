## Rotas definidas de cada processo

### Processo 1

* GET: URL/clientes
* POST: URL/clientes
* GET: URL/clientes/:id
* PUT: URL/clientes/alterar/:id
* POST: URL/veiculos
* GET: URL/veiculos/pesquisar?idCliente=0

### Processo 2

* GET: URL/oficinas/pesquisar?textoPesquisa=:textoPesquisa
* GET: URL/oficinas/:id

### Processo 3

* URL/orcamento
* URL/orcamento/alterar/0213
* URL/orcamento/0213
* URL/cliente/meusOrcamentos?id=001 -> irá precisar do back para definir o usuario logado

### Processo 4

* POST: URL/veiculo/pesquisar?idReparo=0
* GET: URL/reparos/pesquisar?idVeiculo=0

### Processo 2

* POST: URL/reparos/FinalizarReparos?codigoReparo=:id -> Fazer pelo controller no BackEnd
* GET: URL/reparo
  
### Processo 6 
* GET: URL/oficina/peças
* POST: URL/cliente/peças/adicionar
* PUT: URL/oficina/peças---->alterar a quantidade de peças pelo controller
* POST: URL/oficina/peças---> adcionar peças pelo controler

### Processo 7

* URL/servicos
* URL/servicos/0003
* URL/servicos/alterar/0003
* URL/servicos/concluir?codServico=0003 -> Fazer pelo controller no BackEnd
* URL/cliente/meusServicos/001 -> Fazer pelo controller no BackEnd
* URL/feedback/oficina?codOficina=0111 -> Fazer pelo controller no BackEnd
