# Online library project

## Overview
Repo created for a final project from the subject of "Architektury Zorientowane na Serwisy", which was lead in Java. 
Our system/service is designed for simplifying the book ordering process in any library. It introduces three main Entities - Book, Client and Order - with corresponding services, JPA repositories and controllers. Code was written in Java 17, also available in Docker containers.

## Description

### Example business use cases for our service
Book:
- possibility of extracting book data (by book ID) (GET)
  - `/books/{bookId}` 
- possibility of creating a new book and adding it to the books repository (POST)
  - `/books` 


Client:
- possibility of extracting, editing and deleting client data (based on client ID) (GET, PUT, DEL)
  - `/clients/{clientId}`
- possibility of creating a new client and adding it to the clients repository (POST)
  - `/clients`


Order:
- possibility of extracting order data (based on order ID) (GET)
  - `/orders/{orderId}`
- possibility of creating a new order and adding it to the orders repository (POST)
  - `/orders/`
- possibility to verify the orders current status (GET)
  - `/orders/{orderId}/inprogress`
- possibility to sent the order (GET)
  - `/orders/{orderId}/sent`
