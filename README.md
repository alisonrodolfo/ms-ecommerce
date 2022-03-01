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
          uri: https://gitlab.com/alisonbarreiro/pizzanow-config-server.git
```

## Service Registration and Discovery
Primeiro precisa de um registro Eureka Service. 
Pode usar o Spring Cloud @EnableEureka Server para criar um registro com o qual outros aplicativos podem se comunicar.

Instances currently registered with Eureka   |  Application	AMIs	Availability Zones	Status<br>
CUSTOMER-SERVICE	n/a (1)	(1)	UP (1) - host.docker.internal:customer-service:8181<br>
DELIVERY-SERVICE	n/a (1)	(1)	UP (1) - host.docker.internal:delivery-service:8383<br>
ORDER-SERVICE	n/a (1)	(1)	UP (1) - host.docker.internal:order-service:8282<br>
SPRING-BOOT-ADMIN	n/a (1)	(1)	UP (1) - host.docker.internal:spring-boot-admin:9393<br>

## Spring Cloud Gateway
 O Spring Cloud Gateway visa fornecer uma maneira simples, mas eficaz, de rotear para APIs e fornecer preocupações transversais a elas, como: segurança, monitoramento/métricas e resiliência.

http://127.0.0.1:8080/api/v1/customer/ ==> http://127.0.0.1:8181/api/v1/customer/ ( CUSTOMER-SERVICE )<br>
http://127.0.0.1:8080/api/v1/order/  ==> http://127.0.0.1:8282/api/v1/order/ ( ORDER-SERVICE ) <br>
http://127.0.0.1:8080/api/v1/delivery/  ==> http://127.0.0.1:8383/api/v1/delivery/ ( DELIVERY-SERVICE ) <br>
http://127.0.0.1:8080/wallboard  ==> http://127.0.0.1:9393/wallboard/ ( SPRING-BOOT-ADMIN ) <br>


# collection do postman

```sh
ms-pizzanow.postman_collection.json
```


### Conclusão
Vimos uma implementação simples de uma arquitetura de miscroserviços. Um padrão bem difundido e muito utilizado.
Em um ambiente de produção, é preciso também criar novos nós para o Load balance e utilizar pattern circuit breaker.



