## Тестовое задание Java Developer
Результатом работы должно быть работающее веб-приложение,
удовлетворяющее требованиям ниже, ссылка на публичный репозиторий с исходным
кодом и инструкцией по запуску.

### Описание задачи
Разработать веб-приложения «Проектный менеджер», включая следующий функционал:
* Авторизация: admin -&gt; {admin, password}; user -&gt; {user, password}.
* Иерархическая структура проектов и подпроектов. Создавать, редактировать, удалять
  может админ. Получить структуру может любой пользователь.
* Задачи для любого уровня проекта\подпроекта. Задачи делятся на два типа: для
  менеджера, для технического специалиста должны содержать название, статус (new,
  progress, done), дату создания, дату изменения статуса, стандартную информацию для
  конкретного типа.
* Любой пользователь может создать задачу для любого уровня проекта\подпроекта,
  изменить статус, удалить свою задачу, посмотреть все задачи. Любой администратор
  может редактировать, удалить задачу.
### Интерфейс пользователя
* Или реализация простейшего фронтенда.
* Или к проекту должна быть приложена postman коллекция со всеми доступными
  операциями для user и admin.
### Требования к реализации
* Java 11 +
* Безопасность с использованием Spring Security
* Доступ к базе данных через JDBС или JPA
* База данных: H2
* SQL-скрипт создания таблиц в базе данных и наполнения ее тестовыми данными
(приложить в проект)
* сборка проекта должна быть реализована с использованием maven

## Результат
### Запуск проекта
java -jar project_manager-0.0.1-SNAPSHOT.jar

### Приложена postman коллекция со всеми доступными операциями для user и admin
ProjectManager.postman_collection.json

### Сервер
http://localhost:8084

### БД H2
http://localhost:8084/h2-console  
пользователь: sa  
пароль: -  
## Реализованные запросы

### Авторизация (Spring Security)
POST http://localhost:8084/api/auth/signup добавление администратора  
{  
"username":"admin",  
"password":"password",  
"role":["admin"]  
}  

POST http://localhost:8084/api/auth/signup добавление пользователя  
{  
"username":"user",  
"password":"password",  
"role":["user"]  
}  

POST http://localhost:8084/api/auth/signin авторизация администратора  
{  
"username":"admin",  
"password":"password"  
}  

POST http://localhost:8084/api/auth/signin авторизация пользователя  
{  
"username":"user",  
"password":"password"  
}  

POST http://localhost:8084/api/auth/signout выход из учетной записи

### Менеджер проекта
GET http://localhost:8084/api/getAll запрос списка проектов (admin, user)

GET http://localhost:8084/api/getHierarchy запрос иерархической структуры проектов (admin, user)

POST http://localhost:8084/api/projects добавление проекта (admin)  
{  
"parentProjectId":"4",  
"rootProjectId":"2",  
"title":"Проект 2.2.3"  
}  

PUT http://localhost:8084/api/projects редактирование проекта (admin)  
{  
"id":"4",  
"parent_project_id":"1",  
"root_project_id":"1",  
"title":"Заголовок"  
}  

GET http://localhost:8084/api/projects/4 запрос проекта по id(admin)  

DELETE http://localhost:8084/api/projects/3 удаление проекта по id (admin)  

POST http://localhost:8084/api/tasks добавление задачи (admin, user)  
{  
"taskName":"Задача 1",  
"taskType":"для менеджера",  
"taskInfo":"Описание задачи",  
"projectId":1  
}  

GET http://localhost:8084/api/tasks/1 запрос задачи по id (admin)  

GET http://localhost:8084/api/taskUpdateStatus/1 обновление статуса задачи по id (admin, user)  

DELETE http://localhost:8084/api/tasks/1 удаление задачи пользователем по id (user)  

DELETE http://localhost:8084/api/tasksAdmin/1 удаление задачи администратором по id (admin)

PUT http://localhost:8084/api/tasks редактирование задачи  (admin)  
{  
"id": 1,  
"taskName": "Задача 1",  
"taskType": "для технического специалиста",  
"taskStatus": "new",  
"taskDateOfCreate": "2023-03-09T02:59:54.600256",  
"taskDateOfStatusChange": null,  
"taskInfo": "Опмсание задачи",  
"taskOwner": "admin",  
"taskEditor": null  
}  

GET http://localhost:8084/getAllTasks запрос всех задач (admin, user)
