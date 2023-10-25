# Setup and Test Guide for Web and Web-Flux Projects

## Overview
This guide will help you install and run two projects: one using Spring Web and one using Spring WebFlux. Additionally, the guide includes how to install MongoDB via Docker.

## Prerequisites
- Docker installed
- Java and Maven installed
- IDE (e.g., IntelliJ, Eclipse)

## Steps

### Step 1: Install Docker
- Install Docker from the [official website](https://www.docker.com/products/docker-desktop).

### Step 2: Install MongoDB via Docker
```bash
docker run --name mongo-container -p 27017:27017 -d mongo:latest
```

### Step 3: Clone and Setup Web Project
Clone the repository from GitHub or any other source.
Open the project in your IDE and install the necessary dependencies.

### Step 4: Clone and Setup Web-Flux Project
Similar to Step 3, but for the WebFlux project.

### Step 5: Run Projects
Run both projects via your IDE or use the following command:
```bash
mvn spring-boot:run
```

### Step 6: Performance Testing
Use a tool like JMeter to test the performance of both web applications.
Example: Testing with JMeter
Download and install JMeter.
Open JMeter and create a new Test Plan.
Add a Thread Group and configure the number of threads and iterations.
Add an HTTP Request and configure the URL for the web and web-flux applications.
Run the Test Plan and observe the results.


