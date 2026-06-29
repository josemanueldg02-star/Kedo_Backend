# Kedo — Backend API

REST API built with Spring Boot powering the [Kedo Android app](https://github.com/josemanueldg02-star/Kedo_Android). 
Manages user authentication, role-based access control, and geolocation-based 
community event discovery.

Built as the capstone project for a Higher Degree in Multiplatform Application 
Development (DAM).

[![Java](https://img.shields.io/badge/Java-21-orange)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-green)](https://spring.io/projects/spring-security)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-336791)](https://www.postgresql.org/)

---

## Features

- **JWT authentication** — stateless token-based auth with role support 
(admin / standard user)
- **Role-based access control** — endpoints enforce permissions depending 
on the authenticated user's role
- **Community event management** — create, list, and filter events by 
geographic location
- **User management** — registration, login, and profile handling

---

## Tech Stack

- **Java 21**, Spring Boot 3
- **Security:** Spring Security + JWT
- **Persistence:** Spring Data JPA / Hibernate + PostgreSQL
- **Architecture:** Controller → Service → Repository → Model

---

## API Highlights

**Authentication**

| Method | Route | Description | Auth |
|--------|-------|-------------|------|
| `POST` | `/api/auth/register` | Register a new user | Public |
| `POST` | `/api/auth/login` | Returns JWT token | Public |

**Events**

| Method | Route | Description | Auth |
|--------|-------|-------------|------|
| `GET` | `/api/eventos` | List community events | JWT |
| `POST` | `/api/eventos` | Create a new event | JWT (admin) |

All protected routes require: `Authorization: Bearer <token>`

---

## Technical Highlights

- **Stateless JWT filter.** A `OncePerRequestFilter` validates the token 
on every request, keeping authentication decoupled from business logic.
- **Role-aware endpoints.** Admin and standard user roles are enforced at 
the service layer, with the Android client adapting its UI dynamically 
based on the role returned in the JWT payload.
- **Layered architecture.** Clear separation between Controller, Service, 
and Repository layers, keeping business logic testable and independent of 
the persistence layer.

---

## Running Locally

**Prerequisites:** Java 21, Maven, PostgreSQL

```bash
git clone https://github.com/josemanueldg02-star/Kedo_Backend.git
cd Kedo_Backend
./mvnw spring-boot:run
```

Configure your database credentials in `src/main/resources/application.properties` 
before running.

API available at `http://localhost:8080`.

To use with the Android client, run [Kedo_Android](https://github.com/josemanueldg02-star/Kedo_Android) 
in Android Studio pointing to your local IP.

---

## Author

**José Manuel Domínguez García** · [@josemanueldg02-star](https://github.com/josemanueldg02-star)
