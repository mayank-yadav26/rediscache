# 🚀 Redis Caching Project with Spring Boot

This project demonstrates how to integrate **Redis** into a Spring Boot application using:

- ✅ Spring Cache abstraction with `@Cacheable`

- ✅ RedisTemplate for direct Redis access

- ✅ Jackson-based Redis serialization

---

### 🧠 What is Redis Cache?

**Redis Cache** is a high-performance **in-memory key-value store** used to **temporarily store data** for fast retrieval.

Instead of repeatedly querying a **slow or expensive backend system** (like a relational database or external API), you cache data in Redis, which resides entirely in RAM — making read and write operations extremely fast.

---

## 🤔 Why Use Redis Cache?

Redis is a high-performance, in-memory key-value store. It is commonly used for:

- ⚡ **Speeding up response times** by avoiding repeated DB queries

- 💡 **Reducing load** on downstream services and databases

- ♻️ **Caching expensive computations** or frequently accessed data

- 📉 **Improving scalability** of high-traffic applications

- 🧠 **Storing session data**, tokens, or temporary state

Redis works especially well in **read-heavy** applications where performance and low-latency are critical.

---

## 🧩 Can Redis Be Used in Microservices?

✅ **Yes, Redis is widely used in microservice architectures**:

- **Shared Cache Layer**  
    Redis acts as a central cache between multiple services to avoid redundant DB calls.

- **Caching API Responses**  
    Services can cache third-party API responses and refresh them asynchronously.

- **Rate Limiting**  
    Redis is used to store request counters or timestamps for enforcing rate limits.

- **Token / Session Store**  
    Microservices often store JWTs or user sessions in Redis for fast access.

- **Pub/Sub Messaging**  
    Redis also provides Pub/Sub support for lightweight message broadcasting.

**Important Tip:**  
To avoid key collisions across microservices, prefix keys with the service name or namespace, e.g., `order-service:product:123`.

---

## 📦 Tech Stack

- Java 17+

- Spring Boot 3.x

- Spring Data Redis

- Redis (local or Docker)

- Lombok

---

## ⚙️ Setup Instructions

### 1\. Clone the Repository

```bash
git https://github.com/mayank-yadav26/rediscache
cd rediscache
```

### 2\. Start Redis Server

**Docker**

```bash
docker run -d --name redis -p 6379:6379 redis
```

## ▶️ Run the Project

```bash
./mvnw spring-boot:run
or use IDE to run springboot project
```

App runs at: [http://localhost:8080](<http://localhost:8080>)

## 🧪 API Endpoints

### 🎯 Product APIs with Caching

| Method                       | Endpoint                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- |
| GET                          | `/products/{id}`             | Get product (with cache)     |
| DELETE                       | `/products/{id}`             | Delete product + evict cache |

### 🛠️ RedisTemplate Manual APIs

| Method                  | Endpoint                | Description             |
| ----------------------- | ----------------------- | ----------------------- |
| POST                    | `/manual-products`      | Save manually to Redis  |
| GET                     | `/manual-products/{id}` | Get manually from Redis |
| DELETE                  | `/manual-products/{id}` | Delete from Redis       |

## 🧠 How It Works

### 🌀 Spring Cache (`@Cacheable`)

```java
@Cacheable(value = "products", key = "#id")
public Product getProduct(int id)
```

- First call hits DB and caches result.

- Subsequent calls return from Redis.

### 🔧 RedisTemplate

```java
redisTemplate.opsForValue().set("Product::1", product);
```

## 🔍 Redis Config

- Custom `CacheManager` with `Jackson2JsonRedisSerializer` for readable JSON

- Default TTL: 1 minutes

- Keys like: `products::1`

## 🧪 Testing

### ✅ Postman / curl

```bash
curl http://localhost:8080/products/1
curl http://localhost:8080/products/1  # Cached
```

### ✅ Redis CLI

```bash
redis-cli
# To got to redis terminal 
docker exec -it redis-cache redis-cli

# To get all keys
KEYS *

# To get value for particular key
GET products::1
```
