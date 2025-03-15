# Secure Web Application with SQL Injection Protection and HTTPS Access

## Overview
This project is a secure web application built using **Spring Boot**, which implements key security features to mitigate common vulnerabilities, such as SQL Injection and unsecured communication. The web application is designed to protect against social engineering attacks like phishing, where an attacker may craft an email to steal user credentials. The application ensures encrypted communication via HTTPS and leverages secure database access techniques to prevent SQL injection attacks.

### Key Features
- **SQL Injection Protection**: Implements safe database access methods using **Spring Data JPA**, which automatically uses parameterized queries to avoid SQL injection vulnerabilities.
- **HTTPS Enforcement**: Enforces secure communication with SSL/TLS (HTTPS) for encrypted data transmission.
- **Spring Boot Application**: Built using Spring Boot for easy deployment and integration.
- **Secure Access**: Uses `BCryptPasswordEncoder` for password hashing and ensures that sensitive data is handled securely.
- **Mock Data**: Initially uses mock data to simulate database operations, avoiding the need for an actual database setup.

## Prerequisites

Before you start, ensure you have the following installed:

- **Java 8+**: Required to build and run the Spring Boot application.
- **Maven or Gradle**: Dependency management and build tools for the application.
- **Spring Boot**: Framework used for building the application.
- **SSL Certificate**: Either a self-signed certificate for local development or a valid SSL certificate for production.
- **MySQL (optional)**: If you want to use a real database instead of mock data.

## Getting Started

### Step 1: Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-repo/secure-web-app.git
cd secure-web-app

### Step 2: Generate SSL Certificate (For Local Development)
For local development, you can generate a self-signed SSL certificate using the keytool utility (comes with Java):

bash
Copy code
keytool -genkeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650

This command will generate a keystore file named keystore.p12. You need to move this file into the src/main/resources folder.

### Step 3: Configure SSL in application.properties
Edit the src/main/resources/application.properties file to include the SSL configurations for your application. Example:
# Application Properties
spring.application.name=secure-app

# Server Port
server.port=8443

# Enable HTTPS
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=changeit
server.ssl.key-store-type=PKCS12
server.ssl.key-alias=spring-boot
server.ssl.key-password=changeit

### Step 4: Run the Application
Use Maven to run the application:

bash
Copy code

mvn spring-boot:run

The application will start, and you can access it via https://localhost:8443.

### Step 5: Access the Application
Once the application is running, open a browser and navigate to https://localhost:8443. You should see the application, and the browser should show a padlock icon in the URL bar, indicating that the connection is secure.

### Step 6: Testing the Application
SQL Injection Testing: To test for SQL injection, try entering various inputs like admin' OR '1'='1 into the login form. The application should reject such inputs and not expose any database data.

HTTPS Testing: In the browser, verify that the URL starts with https:// and that the padlock icon appears next to the URL. This ensures the communication is encrypted.

### Step 7: Automated Tests
To run the automated tests for the application, use the following Maven command:

bash
Copy code
mvn test
This will run the test cases to ensure that the application works correctly and securely.

Security Features
SQL Injection Prevention: The application uses Spring Data JPA to interact with the database. This abstraction layer automatically uses parameterized queries, which prevent SQL injection attacks.

HTTPS Enforcement: The application is configured to run on HTTPS, ensuring encrypted communication between the client and server. This prevents man-in-the-middle attacks.

Password Hashing: The application uses BCryptPasswordEncoder for securely hashing user passwords. This ensures that even if the database is compromised, passwords remain safe.

Spring Security: Configures Spring Security for authentication and authorization, ensuring that sensitive operations are protected by proper role-based access control.

