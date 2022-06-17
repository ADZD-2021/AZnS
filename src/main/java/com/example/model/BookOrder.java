package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name = "order_state")
    private OrderState orderState;

    @Column(name = "time_ordered")
    private Timestamp timeOrdered;

    @Column(name = "time_in_progress")
    private Timestamp timeInProgress;

    @Column(name = "time_sent")
    private Timestamp timeSent;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "book_order_books",
            joinColumns = @JoinColumn(name = "book_order_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    @OrderBy("id DESC")
    private List<Book> books = new ArrayList<>();


    public BookOrder() {}

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Timestamp getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Timestamp timeSent) {
        this.timeSent = timeSent;
    }

    public Timestamp getTimeInProgress() {
        return timeInProgress;
    }

    public void setTimeInProgress(Timestamp timeInProgress) {
        this.timeInProgress = timeInProgress;
    }

    public Timestamp getTimeOrdered() {
        return timeOrdered;
    }

    public void setTimeOrdered(Timestamp timeOrdered) {
        this.timeOrdered = timeOrdered;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
