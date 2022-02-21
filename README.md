# Uma arquitetura de miscroserviços com Spring Boot

No comércio eletrônico, a criação de microsserviços confiáveis ​​e escaláveis ​​é fundamental para fornecer aos clientes uma experiência de compra consistentemente ideal e simplificar a complexidade envolvida no envio de novos recursos.


## O Spring Cloud Config
O Spring Cloud Config fornece suporte do lado do servidor e do lado do cliente para configuração externa em um sistema distribuído.
A estratégia padrão para localizar fontes de propriedade é clonar um repositório git
```yml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://gitlab.com/alisonbarreiro/config-server-yml.git
```

## Service Registration and Discovery
Primeiro precisa de um registro Eureka Service. 
Pode usar o Spring Cloud @EnableEureka Server para criar um registro com o qual outros aplicativos podem se comunicar.

Instances currently registered with Eureka   |  Application	AMIs	Availability Zones	Status<br>
PRODUCT-CATALOG	n/a (1)	(1)	UP (1) - host.docker.internal:product-catalog:8181<br>
SERVICE-DISCOVERY	n/a (1)	(1)	UP (1) - host.docker.internal:service-discovery:9000<br>
SHOPPING-CART	n/a (1)	(1)	UP (1) - host.docker.internal:shopping-cart:8282<br>

## Spring Cloud Gateway
 O Spring Cloud Gateway visa fornecer uma maneira simples, mas eficaz, de rotear para APIs e fornecer preocupações transversais a elas, como: segurança, monitoramento/métricas e resiliência.

 http://127.0.0.1:8080/product/1  ==> http://127.0.0.1:8181/product/1 ( RODUCT-CATALOG )<br>
 http://127.0.0.1:8080/cart/1  ==> http://127.0.0.1:8282/cart/1 ( SHOPPING-CART ) <br>

## Product Catalog com ElasticSearch
O Product Catalog é uma API Rest que fornece um catalogo de produtos salvos no ElasticSearch
Uma das principais vantagens do Elasticsearch é a velocidade, principalmente quando se depara com grandes conjuntos de dados, como um grande número de produtos em uma loja de comércio eletrônico. Tempos de resposta lentos proporcionam uma experiência de usuário ruim e causam taxas de rejeição mais altas, mas o Elasticsearch pode obter respostas de pesquisa rápidas porque pesquisa um índice em vez do texto diretamente. 

## Shopping Cart com Redis
O Shopping Cart é uma API Rest  que utiliza o Redis
Normalmente, os dados do carrinho de compras são armazenados no lado do cliente como um cookie. Cookies são pequenos arquivos de texto armazenados no diretório do navegador ou na pasta de dados de um usuário da web. A vantagem de fazer isso é que você não precisa armazenar esses dados temporários em seu banco de dados. No entanto, isso exigirá que você envie os cookies com cada solicitação da Web, o que pode retardar a solicitação no caso de cookies grandes. Armazenar dados do carrinho de compras no Redis é uma boa ideia, pois você pode recuperar os itens muito rapidamente a qualquer momento e manter esses dados, se necessário.

# collection do postman

```sh
Microserviços com ElasticSearch.postman_collection.json
```

## Docker

```sh
docker-compose -f docker-compose-elasticsearch-redis.yml up -d
```

### Conclusão
Vimos uma implementação simples de uma arquitetura de miscroserviços. Um padrão bem difundido e muito utilizado.
Em um ambiente de produção, é preciso também criar novos nós para o Load balance e utilizar pattern circuit breaker.



