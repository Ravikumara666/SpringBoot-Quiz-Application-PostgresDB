# Spring Boot Quiz Application with PostgreSQL

This project is a quiz application built using **Spring Boot** and **PostgreSQL**. It provides a backend service to manage questions, quizzes, and user answers while calculating scores. The application uses Spring Web, Spring Data JPA, and PostgreSQL to deliver robust and efficient functionality.

## Features

- **Questions Management**:
  - Add new questions to the database.
  - Retrieve all questions.
  - Delete a question by its ID.

- **Quiz Management**:
  - Create a quiz by selecting multiple questions.
  - Post answers to a quiz.
  - Calculate and return scores based on submitted answers.

- **Database**:
  - Persistent storage using PostgreSQL.

## Tech Stack

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Dependencies**:
  - Spring Web
  - Spring Data JPA
  - PostgreSQL Driver

## Prerequisites

To run this application, you need:

- **Java Development Kit (JDK)**: Version 11 or above.
- **PostgreSQL**: Installed and running.
- **Maven**: To build and run the application.

## Installation and Usage

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YourUsername/SpringBoot-Quiz-Application-PostgresDB.git
   cd SpringBoot-Quiz-Application-PostgresDB

2.	Configure the Database:
Update the application.properties file in src/main/resources:

  spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update

3.	Build the Project:
      mvn clean install
4.	Run the Application:
      mvn spring-boot:run

6.	Test the APIs:
  Use tools like Postman or cURL to test the following endpoints:
	•	GET /question/allquestions: Retrieve all questions. (http://localhost:8080/quetion/allquetions)
	•	POST /questions: Add a new question.
	•	DELETE /questions/{id}: Delete a question by ID. (http://localhost:8080/quetion/delet/1)
	•	POST /quiz/create: Create a quiz.  (http://localhost:8080/quiz/create?category=java&numQ=5&title=jQuiz)
	•	POST /quiz/submit: Submit answers and calculate the score.
