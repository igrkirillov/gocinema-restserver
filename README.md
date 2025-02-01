# Go-Cinema Server
## Запуск
```shell
./run.sh
```
## Urls
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/h2-console


## Таблицы
- [Movie.java (Фильм)](src/main/java/ru/gocinema/server/model/Movie.java)
- [Ticket.java (Выкупленный билет)](src/main/java/ru/gocinema/server/model/Ticket.java)
- [User.java (Пользователь: покупатель или админ)](src/main/java/ru/gocinema/server/model/User.java)
- [Hall.java (Кинозал)](src/main/java/ru/gocinema/server/model/Hall.java)
- [HallPlace.java (Место в кинозале)](src/main/java/ru/gocinema/server/model/HallPlace.java)
- [MovieShow.java (Киносеанс)](src/main/java/ru/gocinema/server/model/MovieShow.java)
- [MovieShowPlace.java (Место на киносеанс)](src/main/java/ru/gocinema/server/model/MovieShowPlace.java)

![postgres - gocinema.png](postgres%20-%20gocinema.png)
## Rest API Swagger
[gocinema.yaml](src/main/resources/specs/gocinema.yaml)