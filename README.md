# Student API

REST API для управления студентами. Проект в разработке.

## Технологии
- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Validation

## Эндпоинты

| Метод | URL | Описание |
|-------|-----|----------|
| GET | /students | Все студенты |
| GET | /students/{id} | Студент по id |
| GET | /students/passed | Студенты с оценкой >= 60 |
| POST | /students/new | Добавить студента |
| PUT | /students/edit/{id} | Обновить студента |
| DELETE | /students/{id} | Удалить студента |

## Запуск

1. Создай базу данных PostgreSQL: `student_db`
2. Укажи свои данные в `application.properties`
3. Запусти проект через IntelliJ или `mvn spring-boot:run`