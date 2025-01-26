# Go-Cinema Rest Server
## Запуск
```shell
./run.sh
```
## Urls
- http://localhost:8080/docs
- http://localhost:8080/h2-console


## Таблицы
- [Movie.java (Фильм)](src/main/java/ru/gocinema/rest/repositories/model/Movie.java)
- [Ticket.java (Выкупленный билет)](src/main/java/ru/gocinema/rest/repositories/model/Ticket.java)
- [User.java (Пользователь: покупатель или админ)](src/main/java/ru/gocinema/rest/repositories/model/User.java)
- [Hall.java (Кинозал)](src/main/java/ru/gocinema/rest/repositories/model/Hall.java)
- [HallPlace.java (Место в кинозале)](src/main/java/ru/gocinema/rest/repositories/model/HallPlace.java)
- [MovieShow.java (Киносеанс)](src/main/java/ru/gocinema/rest/repositories/model/MovieShow.java)
- [MovieShowPlace.java (Место на киносеанс)](src/main/java/ru/gocinema/rest/repositories/model/MovieShowPlace.java)

![postgres - gocinema.png](postgres%20-%20gocinema.png)
## Rest API Swagger
[petstore.yml](src/main/resources/specs/petstore.yml)