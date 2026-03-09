# Student API

REST API для управления студентами. Проект в разработке.

## Технологии
- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- Spring MVC(ResponseEntity)
- PostgreSQL
- Validation
- DTO(Ручной маппер)
- Spring Security

## Архитектура

- **Controller** — принимает HTTP запросы
- **Service** — бизнес логика
- **Repository** — работа с базой данных
- **DTO** — объекты для передачи данных
- **Security** - регистрация и авторизация(без авторизации ты не можешь управлять студентами)

## Эндпоинты для Students

| Метод | URL | Описание | Статус |
|-------|-----|----------|-----|
| GET | /students | Все студенты | 200 |
| GET | /students/{id} | Студент по id | 200 |
| GET | /students/passed | Студенты с оценкой >= 60 | 200 |
| POST | /students/new | Добавить студента | 201 |
| PUT | /students/edit/{id} | Обновить студента | 200 |
| DELETE | /students/{id} | Удалить студента | 204 |


## Эндпоинты для Security (User)

| Метод | URL | Описание | Статус |
|-------|-----|------|----|
| POST  | /auth/register | Регистрация нового пользователя | 201|
| POST  | /auth/login | Вход | 200 |

## Запуск

1. Создай базу данных PostgreSQL: `student_db`
2. Укажи свои данные в `application.properties`
3. Запусти проект через IntelliJ или `mvn spring-boot:run`