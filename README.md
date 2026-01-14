🎫 Ticketing System – Backend

This is the backend service for the Ticketing System assignment.
It is built using Spring Boot and provides REST APIs to manage users, tickets, comments, ticket status, and ticket ratings, simulating a real-world IT support system.

🛠 Tech Stack

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Hibernate

Maven

✅ Features Implemented
🔐 Authentication & Roles (Basic)

User roles:

USER

SUPPORT

ADMIN

Role-based behavior implemented at controller/service level

Can be extended to Spring Security (JWT) if required

🎫 Ticket Management

Create support tickets

View tickets created by a user

View ticket details by ID

Ticket lifecycle:

OPEN

IN_PROGRESS

RESOLVED

CLOSED

Assign tickets to support/admin users

Update ticket status

💬 Ticket Comments

Add comments to tickets

View full comment history

Each comment includes:

User details

Timestamp

⭐ Ticket Rating

Users can rate a resolved ticket

Rating scale: 1 to 5

Optional feedback text

Server-side validation included

🛡 Validations

Subject and description are required

Rating must be between 1 and 5

User and ticket existence validation

Proper error handling for invalid requests

📂 Project Structure
src/main/java/com/ticketing/backend
├── controller
│   ├── TicketController.java
│   └── AuthController.java
├── service
│   └── TicketService.java
├── repository
│   ├── TicketRepository.java
│   └── UserRepository.java
├── entity
│   ├── Ticket.java
│   ├── User.java
│   └── Comment.java
├── enums
│   ├── Priority.java
│   ├── TicketStatus.java
│   └── Role.java
