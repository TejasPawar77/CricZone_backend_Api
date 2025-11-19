🚀 Spring Boot REST API with JWT Authentication

A secure and modular Spring Boot REST API that uses JSON Web Tokens (JWT) for authentication and authorization.
This project demonstrates best practices for building backend services, securing endpoints, structuring code, and handling user management.

📌 Features

✔️ User Registration & Login

✔️ JWT-based Authentication & Authorization

✔️ Role-based Access Control (Admin/User)

✔️ Secure API endpoints using Spring Security

✔️ Token validation, expiration & refresh

✔️ Global Exception Handling

✔️ Modular project structure (Controller → Service → Repository → Entity)

✔️ H2/MySQL/PostgreSQL compatible

✔️ Swagger/OpenAPI documentation (optional)

🛠️ Tech Stack

Java 17+

Spring Boot 3+

Spring Web

Spring Security

Spring Data JPA

JWT (jjwt / java-jwt)

Database: H2 / MySQL / PostgreSQL

Maven

📂 Project Structure
src/main/java/com/example/demo
│
├── config
│   ├── JwtAuthenticationFilter.java
│   ├── JwtService.java
│   ├── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── UserController.java
│
├── entity
│   ├── User.java
│   ├── Role.java
│
├── repository
│   ├── UserRepository.java
│
├── service
│   ├── AuthService.java
│   ├── UserService.java
│
└── util
    ├── JwtUtil.java

🔑 Authentication Flow

Register a new user → Credentials stored securely (BCrypt)

Login → API returns a JWT token

Client stores token → Usually in local storage or memory

Client sends token with each request → Using Authorization: Bearer <token>

Spring Security validates token → Grants or denies access
