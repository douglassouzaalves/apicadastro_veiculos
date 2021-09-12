<h1 align="center">Api de Cadastro de Veículos</h1>
<h1 align="center">Api para Calculo do Consumo de Combustível</h1>


Api que realiza cadastro de veículos e calcula o gasto de gasolina referente aos km's percorridos.

Primeiro passo:

Para cadastrar um veículo, você precisará utilizar a ferramenta <b>Postman</b>.<br>

Selecione o método POST, e indique o endereço: http://localhost:8080/veiculo

<b>Insira no body estes campos:</b>
<br>
 <br>
{<br>
  "nome": "AUDI Q4",<br>
	"marca": "AUDI",<br>
	"modelo": 2022,<br>
	"dataDeFabricacao": "2022-09-09",<br>
	"cidadeConsumo": 13,<br>
	"estradaConsumo": 15<br>
}<br>

Para realizar o cálculo de previsão de gastos de combustível, realize os seguintes passos no Postman:


Selecione o método <b>GET</b>, e indique o endereço: http://localhost:8080/veiculo/calcula?preco=50&cidade=13&estrada=15

Testes criados para as api's.

<b>Api's documentadas com Swagger:</b> http://localhost:8080/swagger-ui.html#/


