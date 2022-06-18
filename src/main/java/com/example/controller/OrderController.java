package com.example.controller;

import com.example.dto.OrderDTO;
import com.example.model.BookOrder;
import com.example.model.OrderState;
import com.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    final OrderService orderService;

    public OrderController(OrderService orderService) {this.orderService = orderService; }

    @GetMapping("/orders/{orderId}")
    public BookOrder getOrderById(@PathVariable("orderId") long orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping("/orders/")
    public BookOrder createOrder(@RequestBody OrderDTO order){
        return orderService.createOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") long orderId){
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/orders/{orderId}/inprogress")
    public BookOrder setOrderStatusInProgress(@PathVariable("orderId") long orderId){
        return orderService.setStatus(orderId, OrderState.IN_PROGRESS);
    }

    @GetMapping("/orders/{orderId}/sent")
    public BookOrder setOrderStatusSent(@PathVariable("orderId") long orderId){
        return orderService.setStatus(orderId, OrderState.SENT);
    }
}
