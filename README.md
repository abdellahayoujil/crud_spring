# CRUD Spring MVC Web Application

A lightweight, responsive, and modular **Spring Boot MVC web application** for managing basic CRUD operations using **Beans**, **Dependency Injection**, **Thymeleaf templates**, and **Java Validation API**. Data is stored **in memory** using a custom repository class, without external databases.

## 🚀 Features

- Full Create, Read, Update functionality
- Form validation using `@Valid` and `@NotBlank`
- Clean, styled user interface with Thymeleaf
- Custom in-memory data management via repository class
- MVC architecture using Spring Boot
- Context-aware data submission (add or update)

## 🛠️ Technologies

- **Java 17+**
- **Spring Boot 3+**
- **Spring MVC**
- **Thymeleaf**
- **Jakarta Validation**
- **Beans & Dependency Injection**
- **Maven**

---

## 📁 Project Structure

crud_spring/
├── controller/ # Spring MVC controller
├── service/ # Business logic layer
├── repository/ # In-memory data store
├── templates/ # Thymeleaf views (HTML)
├── Crud.java # Data model with validation
├── Constant.java # Constant for NO_Find
├── CrudSpringApplication.java
└── application.properties # App config



---

## ⚙️ Configuration

### `application.properties`

properties
spring.application.name=crud_spring
server.port=8081


## 💻 How to Run
1. Prerequisites
Java 17+

Maven

2. Run the Application

git clone https://github.com/abdellahayoujil/crud_spring.git
cd crud_spring
mvn spring-boot:run
Visit: http://localhost:8081


## 🔄 Available Routes
| Method | Endpoint          | Description                   |
| ------ | ----------------- | ----------------------------- |
| GET    | `/`               | Show form to add/update data  |
| POST   | `/dataSubmitFrom` | Submit form (with validation) |
| GET    | `/getalldata`     | View all submitted records    |


## 📂 Data Model
Crud.java

public class Crud {
    private String id;

    @NotBlank(message = "can not be empty")
    private String name;

    @NotBlank(message = "can not be empty")
    private String title;

    private double number;
}


## 💡 Features Explained

Validation: Uses @NotBlank to ensure form fields are not empty.

UUID: Generates a unique id using UUID when creating new data.

Update Mode: If the form includes an existing id, the record is updated.

Service Layer: Business logic is handled by CrudService.

Repository: Stores records in memory (List<Crud>) without database usage.


## 🎨 UI Styling

Custom CSS styling for:

Form (addnewdata.html)

Table view (getalldata.html)

Navigation links

Button hover effects

Mobile-friendly layout


## 🧑‍💻 Author

Abdellah Ayoujil

🔗 [GitHub Profile](https://github.com/abdellahayoujil)


