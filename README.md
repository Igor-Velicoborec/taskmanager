### Application
This app is for tasks (CRUD, priority task management)

### Technologies
- Java 11
- Spring  (Boot, MVC, Data)
- PostgreSQL

### REST API

CRUD API + */v1/tasks/*  endpoint:

| URI                             | Method     | Description                            |
| ---------------------           | ----       | ------------------------               |
|*/tasks/{taskId}*                | **GET**    | Get  task by id                        | 
|*/tasks/*                        | **POST**   | Add new task                           | 
|*/tasks/{taskId}*                | **PUT**    | Modify task by id                      | 
|*/tasks/{taskId}*                | **DELETE** | Delete task by id                      | 
|                                 |            |                                        |  
