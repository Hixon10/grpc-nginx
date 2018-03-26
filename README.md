# gRPC Сервер и клиент, работающие друг с другом через Nginx.

1) Сервер реализован на Java с использованием Spring Boot, а также стартера [grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter).

2) Клиент реализован на Java с использованием Spring Boot, а также стартера [grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter).

3) Версия Nginx должна быть [1.13.10](https://www.nginx.com/blog/nginx-1-13-10-grpc/), или выше. 

## Запуск:
```
git clone https://github.com/Hixon10/grpc-nginx.git ./grpc-nginx

cd grpc-nginx
docker-compose up -d

curl http://localhost:81/top
```
