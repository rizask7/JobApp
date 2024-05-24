## Online Job Portal

## Description

An online job portal built using Java and Spring Boot that facilitates seamless job searching and recruitment processes. The project is designed with a clear separation of concerns, structured into multiple layers to enhance maintainability and scalability. 

## Key Features

- **Spring Boot Framework:** Leverages the powerful Spring Boot framework for rapid development and easy configuration.
- **Spring Data JPA:** Utilizes Spring Data JPA for efficient and simplified data access.
- **Layered Architecture:** Implements a well-structured layered architecture to promote a clean separation of concerns.
- **Dockerized Environment:** Fully containerized using Docker, ensuring consistency across different environments and simplifying deployment.
- **PostgreSQL Database:** Employs PostgreSQL for robust and reliable data storage, managed within Docker containers.
- **PGAdmin Integration:** Includes PGAdmin for easy database management and administration within the Docker setup.

## Services

The project currently contains three main services:

- **Company Service:** Manages backend operations of the company.
- **Job Service:** Manages and posts jobs within a company.
- **Review Service:** Allows users to post reviews for a company.

## Technologies Used

- **Java:** Core programming language.
- **Spring Boot:** Framework for building the backend application.
- **Spring Data JPA:** For database operations.
- **Docker:** For containerization and environment consistency.
- **PostgreSQL:** Primary database for data persistence.
- **PGAdmin:** Tool for managing PostgreSQL databases.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Docker and Docker Compose

### Installation

1. **Clone the repository:**
   ```
   bash
   [git clone https://github.com/yourusername/online-job-portal.git](https://github.com/rizask7/JobApp.git)
   
   ```

2. **Build the project:**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application using Docker Compose:**
   ```bash
   docker-compose up
   ```

### Accessing the Application

- The job portal can be accessed at `http://localhost:8080`.
- PGAdmin can be accessed at `http://localhost:5050` for database management.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

---

Feel free to customize the description further to fit your specific project details and organizational guidelines.
