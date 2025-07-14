🛍️ E-Commerce Platform
A full-stack Spring Boot-based E-commerce application that enables users to browse products, add reviews, place orders, and make payments. It also includes admin functionality for managing products.

## 📄 Project Overview
This project is an end-to-end E-commerce backend system built with Spring Boot. It supports:
📦 Product management (Admin only)
👤 User management
🛒 Placing and viewing orders
💳 Processing payments
🌟 Adding and viewing product reviews
🔐 Role-based access using Spring Security

## ⚙️ Tech Stack

| Layer              | Technology                   |
|-------------------|------------------------------|
| Framework         | Spring Boot 3.5.3            |
| ORM               | Spring Data JPA              |
| Database          | MySQL                        |
| Security          | Spring Security              |
| Testing           | JUnit 5, Mockito, MockMvc    |
| Logging           | SLF4J + Logback              |
| Build Tool        | Maven                        |
| Java Version      | Java 21                      |

---
## 🚀 Setup Instructions
  🔁 1. Clone the Repository
    git clone https://github.com/dhanushshetty1/E-commerce-Platform-Project.git
    cd ecommerce-platform
    
  🔧 2. Configure MySQL Database
    Update application.properties:
      properties
        spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
        spring.datasource.username=root
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
    Then create the database:
      CREATE DATABASE ecommerce;
      
  ⚙️ 3. Build the Project
    mvn clean install
    
  ▶️ 4. Run the Application
    Using Maven

## 🔐 Sample Credentials
| Role  | Username            | Password   |
| ----- | ------------------- | ---------- |
| Admin | `admin@example.com` | `admin123` |
| User  | `user@example.com`  | `user123`  |

## 🔁 API Endpoint Summary
🧍 Users
| Method | Endpoint    | Role   | Description       |
| ------ | ----------- | ------ | ----------------- |
| POST   | `/register` | Public | Register new user |
| POST   | `/login`    | Public | Authenticate user |

📦 Products
| Method | Endpoint        | Role       | Description        |
| ------ | --------------- | ---------- | ------------------ |
| GET    | `/products`     | USER/ADMIN | View all products  |
| GET    | `/product/{id}` | USER/ADMIN | View product by ID |
| POST   | `/product`      | ADMIN      | Add new product    |
| PUT    | `/product/{id}` | ADMIN      | Update product     |
| DELETE | `/product/{id}` | ADMIN      | Delete product     |

🧾 Orders
| Method | Endpoint      | Role       | Description     |
| ------ | ------------- | ---------- | --------------- |
| GET    | `/api/orders` | USER/ADMIN | View all orders |
| POST   | `/api/orders` | USER/ADMIN | Place new order |

💳 Payments
| Method | Endpoint        | Role       | Description         |
| ------ | --------------- | ---------- | ------------------- |
| POST   | `/payment/{id}` | USER/ADMIN | Pay for order by ID |

✍️ Reviews
| Method | Endpoint                       | Role       | Description               |
| ------ | ------------------------------ | ---------- | ------------------------- |
| POST   | `/reviews`                     | USER/ADMIN | Submit a product review   |
| GET    | `/reviews/product/{productId}` | USER/ADMIN | Get reviews for a product |


## 🧪 Running Tests
mvn test
Unit and integration tests cover:
Controllers (MockMvc + Spring Security)
Services (Mockito)
Edge cases like invalid input, 403 access, etc.

## 🌐 Port Info
Default port: 8080
To change: edit application.properties
server.port=8081

## 👨‍💻 Contributors
Dhanush Shetty – Developer
🎉 Open for contributions
