# EmployeeManagement

Employment Application is used to create Employees, update employee, list employees by using paging and manage them:
Spring Boot exports REST Apis using Spring Web MVC & interacts with embedded H2 Database using Spring Data JPA.
Angular 13 Client sends HTTP Requests and retrieve HTTP Responses using HttpClient Module, shows data on the components. Also use Angular Router for navigating to pages and ngx-pagination for pagination.
# Technology
- Java 8
- Spring Boot 2.0.5.RELEASE (with Spring Web MVC, Spring Data JPA)
- H2 Database
- Maven 3.6.1
- Angular 12
- Angular HttpClient
- Angular Router
- Bootstrap 4
- ngx-pagination
# Start
- Build All Containers
: docker-compose build

- Build Specific Container
: docker-compose build service_name

- Build Specific Container without Cache
: docker-compose build --no-cache service_name
# Overall Architecture 
![image](https://user-images.githubusercontent.com/24566432/144722451-5da5ce3e-416e-452f-8cf1-a16bd182cd3b.png)

# Backend Architecture
![image](https://user-images.githubusercontent.com/24566432/144722405-f7d78d5d-1885-44ce-95cf-6e5cf40ba4ac.png)
# Frontend Architecture
![image](https://user-images.githubusercontent.com/24566432/144722508-7e615b9c-b538-4267-bf7e-eafc0bb44f23.png)

# Available APIs
Swagger: http://localhost:8080/swagger-ui.html 
API Docs: http://localhost:8080/v2/api-docs
Also the API Documentation file is called employees.json
![image](https://user-images.githubusercontent.com/24566432/144722358-df5081ca-ed47-400c-b104-3acffa1cb7e9.png)

# Application screenshots
![image](https://user-images.githubusercontent.com/24566432/144722383-7d22d6fc-ab39-4eed-8832-7ea1149d14ee.png)
![image](https://user-images.githubusercontent.com/24566432/144722386-a5d57bdb-d5cc-4237-ba3c-8e78f3930a41.png)
![image](https://user-images.githubusercontent.com/24566432/144722389-424e7438-4f27-4707-922a-367b760e3e2f.png)



