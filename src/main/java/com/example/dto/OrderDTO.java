package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private List<Long> booksIds = new ArrayList<>();

    private Long clientId;

    public List<Long> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(List<Long> booksIds) {
        this.booksIds = booksIds;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
