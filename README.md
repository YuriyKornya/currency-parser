# Currency Parser
Spring Boot application for automatic collection of NBU exchange rates.
## Description
The application fetches current exchange rates from the National Bank of Ukraine API every day at 9:00 AM and saves them to a MySQL database.
## Tech Stack
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Docker
- RestClient
## Setup
1. Copy docker-compose.yml.example → docker-compose.yml and fill in your credentials
2. Copy application.properties.example → application.properties and fill in your credentials
3. Start the database in command line:
   docker-compose up -d
4. Run the application
## API
| Method | URL | Description |
|---|---|---|
| GET | /currencies | Get current exchange rates |
| POST | /currencies/save | Fetch and save rates to DB |