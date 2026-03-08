# Task Management API

REST API для управления задачами, разработанный на Spring Boot.

## Возможности

- создание задачи
- получение списка задач
- получение задачи по id
- обновление задачи
- удаление задачи
- фильтрация по статусу и приоритету
- пагинация
- валидация входных данных
- обработка ошибок
- Swagger UI

## Стек

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI

```markdown
## Запуск проекта

### 1. Клонировать репозиторий
```bash
git clone git@github.com:ArseniBirka/task_management_api.git
```

### 2. Перейти в папку проекта
```bash
cd task_management_api
```

### 3. Настроить PostgreSQL

Создать базу данных:
```sql
CREATE DATABASE task_management_db;
```

### 4. Настройки в application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/task_management_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

### 5. Запустить проект

```bash
./mvnw spring-boot:run
```


## Swagger
```bash
После запуска документация доступна по адресу:http://localhost:8080/swagger-ui.html
```

## Основные endpoints
```bash
POST   /tasks
GET    /tasks
GET    /tasks/{id}
PUT    /tasks/{id}
DELETE /tasks/{id}
```
```markdown
## Пример JSON для создания задачи
```json
{
"title": "Первая задача",
"description": "Проверка Swagger",
"status": "NEW",
"priority": "HIGH"
}
```
```