package com.example.service;

import com.example.dto.OrderDTO;
import com.example.model.Book;
import com.example.model.BookOrder;
import com.example.model.OrderState;
import com.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    final OrderRepository orderRepository;
    final BookService bookService;
    final ClientService clientService;

    public OrderService(OrderRepository orderRepository,
                        BookService bookService,
                        ClientService clientService)
    {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    public BookOrder getOrder(long OrderId){
        return orderRepository.findById(OrderId).get();
    }

    public BookOrder createOrder(OrderDTO orderDTO){
        BookOrder bookOrder = new BookOrder();
        bookOrder.setOrderState(OrderState.ORDERED);
        bookOrder.setTimeOrdered(Timestamp.from(ZonedDateTime.now().toInstant()));
        bookOrder.setClient(clientService.getClientById(orderDTO.getClientId()));
        List<Book> books = new ArrayList<>();
        for (long id:
                orderDTO.getBooksIds()) {
            Book book = bookService.getBook(id);
            books.add(book);
        }
        bookOrder.setBooks(books);
        return orderRepository.save(bookOrder);
    }

    public void deleteOrder(long orderId){
        orderRepository.deleteById(orderId);
    }

    public BookOrder setStatus(long orderId, OrderState state){
        BookOrder bookOrder = orderRepository.findById(orderId).get();
        bookOrder.setOrderState(state);
        if(state == OrderState.IN_PROGRESS) {
            bookOrder.setTimeInProgress(Timestamp.from(ZonedDateTime.now().toInstant()));
        }
        if(state == OrderState.SENT){
            bookOrder.setTimeSent(Timestamp.from(ZonedDateTime.now().toInstant()));

        }
        return orderRepository.save(bookOrder);
    }
}
