# Redis Cache-Aside Implementation with Spring Boot

A **production-oriented Spring Boot project** demonstrating Redis integration using the **Cache-Aside pattern**.  
This repository focuses on **explicit cache management**, clarity of data flow, and step-by-step evolution toward resilience.

---

## 🔍 Why This Project?
Caching is often hidden behind annotations.  
This project is built to **understand and control caching behavior explicitly**, which is critical for backend and system design roles.

---

## 🧱 Architecture Overview

```
Client
  │
  ▼
Controller
  │
  ▼
Service Layer
  │
  ├── Redis (Cache)
  │
  └── Database (Source of Truth)
```

- Redis is treated as a **performance optimization**
- Database remains the **single source of truth**
- Cache access is **explicit and intentional**

---

## 🧠 Caching Strategy

### Cache-Aside Pattern
- Application controls cache reads and writes
- Cache is checked before hitting the database
- Cache is updated only when required

---

## 🔄 Current Data Flow

### Write Operation
1. Save entity to database
2. Store entity in Redis cache

### Read Operation
1. Attempt to read from Redis
2. If cache miss → read from database
3. Populate Redis for subsequent requests

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Data Redis (Lettuce)
- H2 Database
- Maven

---

## 🚧 Current Scope (Intentional)
- Redis integration implemented manually
- Cache-aside pattern without abstraction layers
- Focus on correctness and clarity over automation

---

## ⏳ Planned Enhancements
- Graceful fallback when Redis is unavailable
- Direct DB access during Redis outages
- Circuit breaker / retry strategies
- TTL, eviction policies, and monitoring
- Production-grade error handling

> Redis fallback is **intentionally deferred** to isolate and understand cache behavior first.

---

## ▶️ Running the Application

1. (Optional) Start Redis locally  
2. Run the Spring Boot application
3. Access APIs via Postman or browser

Application starts on:
```
http://localhost:8080
```

---

## 📌 Project Status

| Feature | Status |
|------|------|
| Redis Integration | ✅ Implemented |
| Cache-Aside Pattern | ✅ Implemented |
| Redis Fallback | 🔜 Planned |
| Production Hardening | 🔜 Planned |

---

## 🎯 Learning Outcomes
- Hands-on Redis integration
- Cache-aside pattern in real services
- Explicit control over caching logic
- Foundations for resilient backend systems

---

## 👤 Author
**Kiran Gantashetti**  
Backend Engineer | Java | Spring Boot | Redis | Distributed Systems
