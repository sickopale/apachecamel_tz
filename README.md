# Apache Camel Application

При разработке использовались Java 17 и система сборки Maven

Для удобства работы и запуска приложения можно использовать Docker Compose.

## Запуск через Docker Compose

Для запуска приложения с использованием Docker Compose выполните следующие шаги:

Клонируйте репозиторий с кодом и выполните команду терминале:

```
docker-compose up --build

Если нужно пересобрать приложения 
```
mvn clean install

## Просмотр содержимого папки input

Если вам нужно просмотреть содержимое папки input внутри контейнера, выполните следующие шаги:

Сначала узнайте ID или имя контейнера c apache camel, в котором находится папка input. Для этого выполните команду:
```
docker ps
```
docker exec -it <CONTAINER_ID> ls /path/to/input

Я использую Docker Desktop, чтобы удобно следить за логами и процессом перемещения файлов между папками в контейнере с apache camel.

## Запуск с IDE
Так же можно запустить приложение напрямую из IDE.

Запустите Spring-приложение первым, так как оно должно быть запущено до основной логики Apache Camel.
После этого вы можете запустить приложение с apache camel, и Camel будет заниматься обработкой и маршрутизацией данных.
Отследить, пришли ли данные в наше REST API, можно так же в консоли со spring приложением.

## Логи и мониторинг
Вы можете отслеживать логи и перемещение файлов внутри контейнера с помощью Docker Desktop, или выполнив команду docker logs <CONTAINER_ID>. 
Или же отслеживать логи в консоли при запуске из IDE.
