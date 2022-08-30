Read me


1 - Iniciar os microserviços na ordem:

Eureka>Config>Gateway>Movie>Catalog

2 - Adicionar o filme usando:

a) o endpoint em http://localhost:8080/movie/ usando POST e body 


{
        "name": "Aventura do pneu bandido",
        "urlStream": "httplink",
        "genre": "aventura"
    } 

(obs: Por motivos desconhecidos as vezes é preciso tentar mandar o post para o '8080/movie' antes de mandar pro '8080/movie/')

b) o console h2 em http://localhost:8080/movie/h2-console rodando o seguinte comando:
INSERT INTO MOVIE VALUES(1,'acao','filmaoooo','http://oi')


3) Buscar pelo genero em http://localhost:8080/movie/{genero} ou http://localhost:8080/catalog/{genero}
ex: http://localhost:8080/catalog/acao
