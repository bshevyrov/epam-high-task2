
# Social Media Platform

## Description

The Social Media Platform is a RESTful API built with Spring Boot that allows users to create profiles, post updates, follow other users, and send messages. The system integrates with Amazon S3 to store user-generated content such as images and files.

## Features

- User registration and profile management.
- Post updates, including text and media content.
- Follow and unfollow other users.
- Send and receive messages between users.
- Store and retrieve user-generated content using Amazon S3.

## Technologies Used

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA (Hibernate)
- MySQL
- Amazon S3 (AWS SDK)
- Maven
- JUnit 5
- Mockito
- Lombok

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.x](https://maven.apache.org/download.cgi)
- [MySQL](https://www.mysql.com/downloads/)
- [AWS CLI](https://aws.amazon.com/cli/) (for configuring your AWS credentials)

## Getting Started

### 1. Clone the Repository

```bash
git clone hhttps://github.com/bshevyrov/epam-high-task2.git
cd epam-high-task2
```

### 2. Configure Environment Variables

Create a `.env` file in the root directory and configure the following environment variables:

```bash
AWS_ACCESS_KEY_ID=your_aws_access_key
AWS_SECRET_ACCESS_KEY=your_aws_secret_key
AWS_REGION=your_aws_region
SPRING_DATASOURCE_USERNAME=your_mysql_username
SPRING_DATASOURCE_PASSWORD=your_mysql_password
SPRING_DATASOURCE_URL=your_db_adresses
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.MySQLDialect
S3_BUCKET_NAME=your_s3_bucket_name
```

### 3. Build the Application

```bash
./gradlew clean build
```


### 4. Run the Application

```bash
 ./gradlew bootRun
 ```
 

## Testing

Run the unit tests using the following command:

```bash
./gradlew test
```


## Chat GPT Log

[chat.html](chat.html)

## Feedback
- The task was essentially simple.
- 3 hour
- The code was almost usable, I just tweaked it a bit and added a configuration
- I struggled with Amazon because I don't have an account there
- Use example
