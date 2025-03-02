Employee Management System (EMS) - Documentation
1. Project Overview
The Employee Management System (EMS) is a web-based application built with Spring Boot, JPA, Thymeleaf, and MySQL to manage employees efficiently. It supports CRUD operations (Create, Read, Update, Delete), authentication, and API-based interactions.

2. Project Setup & Configuration
2.1 Prerequisites
Ensure you have the following installed on your system:
Java 17 or later
Maven (Latest version)
MySQL Server
Postman or Swagger UI 
IDE (IntelliJ IDEA)
2.2 Clone the Repository
sh
CopyEdit
git clone https://github.com/your-repository/ems.git
cd ems

2.3 Database Configuration
Create a MySQL database:
sql
CopyEdit
CREATE DATABASE employee_db;

Update src/main/resources/application.properties:
properties
CopyEdit
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

2.4 Install Dependencies & Run the Application
sh
CopyEdit
mvn clean install
mvn spring-boot:run

The application should start on http://localhost:8080/

3. API Documentation
This section provides the API endpoints, request/response formats, and validation rules.
3.1 API Endpoints
HTTP Method
Endpoint
Description
GET
/api/employees
Get all employees
GET
/api/employees/{id}
Get employee by ID
POST
/api/employees
Create a new employee
PUT
/api/employees/{id}
Update an existing employee
DELETE
/api/employees/{id}
Delete an employee


3.2 API Request & Response Formats
3.2.1 Create Employee (POST /api/employees)
Request Body (JSON)
json
CopyEdit
{
  "name": "John Doe",
  "department": "IT",
  "email": "john.doe@example.com",
  "salary": 50000
}

Response (201 Created)
json
CopyEdit
{
  "id": 1,
  "name": "Karthik",
  "department": "IT",
  "email": "karthik@gmail.com",
  "salary": 50000
}

Validation Rules:
name: Required, min 3 characters
department: Required
email: Required, valid format
salary: Required, minimum 1000

3.2.2 Get Employee by ID (GET /api/employees/{id})
Response (200 OK)
json
CopyEdit
{
  "id": 1,
  "name": "Karthik",
  "department": "IT",
  "email": "karthik@gmail.com",
  "salary": 50000
}

Response (404 Not Found)
json
CopyEdit
{
  "error": "Employee not found"
}


3.2.3 Update Employee (PUT /api/employees/{id})
Request Body (JSON)
json
CopyEdit
{
  "name": "Karthik Updated",
  "department": "Finance",
  "email": "karthik@finance.com",
  "salary": 60000
}

Response (200 OK)
json
CopyEdit
{
  "id": 1,
  "name": "Karthik Updated",
  "department": "Finance",
  "email": "karthik@finance.com",
  "salary": 60000
}


3.2.4 Delete Employee (DELETE /api/employees/{id})
Response (204 No Content)
json
CopyEdit
{
  "message": "Employee deleted successfully"
}


4. Swagger Integration
To generate API documentation using Swagger, follow these steps:
4.1 Add Swagger Dependencies in pom.xml
xml
CopyEdit
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>

4.2 Configure Swagger in application.properties
properties
CopyEdit
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

4.3 Access Swagger UI
Once the application is running, access Swagger UI at:
 http://localhost:8080/swagger-ui.html

5. Running & Testing the Application
5.1 Run the Application
sh
CopyEdit
mvn spring-boot:run

or
sh
CopyEdit
java -jar target/employeemanagement-0.0.1-SNAPSHOT.jar

5.2 Testing APIs
Use Postman or Swagger UI (http://localhost:8080/swagger-ui.html) to test APIs.

6. Error Handling
Error Code
Message
Description
400
Validation failed
Invalid request data
404
Employee not found
Employee ID does not exist
500
Internal Server Error
Unexpected server error



