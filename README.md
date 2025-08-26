# Expense Tracker Application

A simple and efficient Expense Tracker built with Spring Boot and MySQL. This application helps you track your daily expenses with a clean REST API.

## Features

- Create, read, update, and delete expenses
- RESTful API endpoints for all operations
- MySQL database integration
- Built with Spring Boot for easy deployment
- Maven for dependency management

## Tech Stack

- **Backend**: Spring Boot 3.x
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Java Version**: 17

## Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6.0 or higher
- Git (for version control)

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/Expense-Tracker.git
cd Expense-Tracker
```

### 2. Database Setup

1. Create a new MySQL database:
   ```sql
   CREATE DATABASE expense_tracker;
   ```

2. Update the database configuration in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker?createDatabaseIfNotExist=true
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### 3. Build and Run

```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8081`

## API Endpoints

| Method | Endpoint                | Description                     |
|--------|-------------------------|---------------------------------|
| GET    | /api/expenses          | Get all expenses                |
| GET    | /api/expenses/{id}     | Get expense by ID               |
| POST   | /api/expenses          | Add a new expense              |
| PUT    | /api/expenses/{id}     | Update an existing expense      |
| DELETE | /api/expenses/{id}     | Delete an expense              |

### Example Requests

**Add a new expense:**
```http
POST /api/expenses
Content-Type: application/json

{
    "description": "Dinner at Restaurant",
    "amount": 45.75,
    "date": "2025-08-26"
}
```

**Get all expenses:**
```http
GET /api/expenses
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── controller/    # REST controllers
│   │       ├── entity/        # JPA entities
│   │       ├── repository/    # Data access layer
│   │       ├── service/       # Business logic
│   │       └── ExpenseTrackerApplication.java  # Main application class
│   └── resources/
│       └── application.properties  # Configuration
└── test/                      # Test files
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built with ❤️ using Spring Boot
- Thanks to all contributors who helped improve this project!
