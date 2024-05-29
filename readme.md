# Sample Spring Boot Learning Project

## Introduction

Welcome to the Sample Spring Boot Learning Project! This project is designed to help you learn and understand the fundamentals of Spring Boot. It covers the basics of creating a Spring Boot application, including setting up entities, repositories, services, and controllers. By working through this project, you will gain hands-on experience with key Spring Boot concepts and best practices.

## Table of Contents

- [Introduction](#introduction)
- [Table of Contents](#table-of-contents)
- [Project Setup](#project-setup)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Running the Application](#running-the-application)
- [Useful Resources](#useful-resources)
- [Contributing](#contributing)
- [License](#license)

## Project Setup

To set up the project, you will need to have the following installed on your machine:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6.3 or higher
- An IDE such as IntelliJ IDEA or Eclipse

### Cloning the Repository

First, clone the repository to your local machine:

```sh
git clone https://github.com/your-username/sample-spring-boot-learning-project.git
cd sample-spring-boot-learning-project
```

### Building the Project

Navigate to the project directory and build the project using Maven:

```sh
mvn clean install
```

## Project Structure

The project structure follows a typical Spring Boot layout:

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── demo
│   │               ├── student
│   │               │   ├── Student.java
│   │               │   ├── StudentDto.java
│   │               │   ├── StudentMapper.java
│   │               │   ├── StudentRepository.java
│   │               │   ├── StudentService.java
│   │               │   └── StudentController.java
│   │               ├── school
│   │               │   ├── School.java
│   │               │   ├── SchoolRepository.java
│   │               │   └── SchoolService.java
│   │               └── DemoApplication.java
│   └── resources
│       └── application.yml
└── test
    └── java
        └── com
            └── example
                └── demo
                    └── DemoApplicationTests.java
```

## Getting Started

1. **Create the `School` Entity**:
    - `School.java`: Defines the `School` entity with `UUID` as the primary key.
    - `SchoolRepository.java`: Handles database operations for `School` entities.

2. **Create the `Student` Entity**:
    - `Student.java`: Defines the `Student` entity with `UUID` as the primary key.
    - `StudentDto.java`: A Data Transfer Object for `Student`.
    - `StudentMapper.java`: Maps `StudentDto` to `Student`.
    - `StudentRepository.java`: Handles database operations for `Student` entities.
    - `StudentService.java`: Contains business logic for managing students.
    - `StudentController.java`: Maps HTTP requests to service methods.

3. **Configure the Application**:
    - `application.yml`: Contains configuration settings for the application.

## Endpoints

The application exposes the following REST endpoints:

- **Schools**:
    - `GET /api/schools`: Retrieve all schools.
    - `GET /api/schools/{id}`: Retrieve a school by its ID.
    - `POST /api/schools`: Create a new school.
    - `PUT /api/schools/{id}`: Update an existing school.
    - `DELETE /api/schools/{id}`: Delete a school.

- **Students**:
    - `GET /api/students`: Retrieve all students.
    - `GET /api/students/{id}`: Retrieve a student by its ID.
    - `POST /api/students`: Create a new student.
    - `PUT /api/students/{id}`: Update an existing student.
    - `DELETE /api/students/{id}`: Delete a student.

## Running the Application

To run the application, use the following command:

```sh
mvn spring-boot:run
```

The application will start and be accessible at `http://localhost:8080`.

## Useful Resources

- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Initializr](https://start.spring.io/)
- [Spring Guides](https://spring.io/guides)

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy learning! If you have any questions or feedback, feel free to open an issue in the repository.