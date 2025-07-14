🛍️ E-Commerce Platform
A full-stack Spring Boot-based E-commerce application that enables users to browse products, add reviews, place orders, and make payments. It also includes admin functionality for managing products.

📄 Project Overview
This project is an end-to-end E-commerce backend system built with Spring Boot. It supports:
📦 Product management (Admin only)
👤 User management
🛒 Placing and viewing orders
💳 Processing payments
🌟 Adding and viewing product reviews
🔐 Role-based access using Spring Security

⚙️ Tech Stack
Framework: Spring Boot 3.5.3
Database: MySQL
ORM: Spring Data JPA
Security: Spring Security
Testing: JUnit 5, Mockito, MockMvc
Build Tool: Maven
Java Version: Java 21

🚀 Setup Instructions
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

🔐 Sample Credentials
| Role  | Username            | Password   |
| ----- | ------------------- | ---------- |
| Admin | `admin@example.com` | `admin123` |
| User  | `user@example.com`  | `user123`  |

🔁 API Endpoint Summary
| Method | Endpoint                       | Description               | Role        |
| ------ | ------------------------------ | ------------------------- | ----------- |
| GET    | `/products`                    | List all products         | USER, ADMIN |
| POST   | `/product`                     | Add new product           | ADMIN       |
| GET    | `/product/{id}`                | Get product by ID         | USER, ADMIN |
| PUT    | `/product/{id}`                | Update product            | ADMIN       |
| DELETE | `/product/{id}`                | Delete product            | ADMIN       |
| POST   | `/api/orders`                  | Place an order            | USER, ADMIN |
| GET    | `/api/orders`                  | View all orders           | USER, ADMIN |
| POST   | `/payment/{orderId}`           | Process payment for order | USER, ADMIN |
| POST   | `/reviews`                     | Add product review        | USER, ADMIN |
| GET    | `/reviews/product/{productId}` | Get reviews for a product | USER, ADMIN |

👨‍💻 Contributors
Dhanush Shetty – Developer
🎉 Open for contributions
