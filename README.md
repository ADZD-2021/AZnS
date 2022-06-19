# Online library project

## Overview
Repo created for a final project from the subject of "Architektury Zorientowane na Serwisy", which was lead in Java. 
Our system/service is designed for simplifying the book ordering process in any library. It introduces three main Entities - Book, Client and Order - with corresponding services, repositories and controllers. Code was written in Java 17, also available in Docker containers.

## Description

### Requirements
Technical requirements of the project:
- possibility to configure connection to the database from xml / json file
- activity to the database realized by plan java jdbc or spring jdbc template or spring jpa data
- all 'business' guidelines are to be available through REST api

---

### Example business use cases for our service
Book:
- possibility of extracting book data (by book ID)
 - `/books/{bookId}`
- possibility of creating a new book and adding it to the books repository
 - `/books`


Client:
- possibility of extracting, editing and deleting client data (based on client ID)
  - `/clients/{clientId}`
- possibility of creating a new client and adding it to the clients repository
 - `/clients`


Order:
- possibility of extracting order data (based on order ID)
  - `/orders/{orderId}`
- possibility of creating a new order and adding it to the orders repository
  - `/orders/`
- possibility to verify the orders current status
  - `/orders/{orderId}/inprogress`
- possibility to sent the order
  - `/orders/{orderId}/sent`

---

## Docker usage

This project is meant to be run in a Docker container. Therefore, we created a Dockerfile for creating image based on Ubuntu 20.04.
There are 2 images created for 2 processor architectures that we are working on: ARM and x64. Images can be pulled from [Docker Hub](https://hub.docker.com/r/mrkf1/azns2021).

How to manually create Docker image:

- build project's jar file via `mvn clean package` command (this can be done in IntelliJ)
- run Docker Desktop and in terminal/command line type `docker build -t tag -f Dockerfile .`
- run image via `docker run -d -p 8080:8080 tag` - it's important to map 8080 Docker container's port to 8080 port on local machine, otherwise it won't be possible to connect to the service

---

## Testing using Postman

After starting Docker container you can test different use cases using Postman - we included Postman collection file in `postman/` directory which can be imported into the program.
