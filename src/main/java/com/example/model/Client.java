package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long clientId;
    private String imie;
    private String nazwisko;
    private String adres;
    private String nrTel;


    @OneToMany(mappedBy = "client", orphanRemoval = true)
    @OrderBy("id DESC")
    private List<BookOrder> bookOrders = new ArrayList<>();

    public List<BookOrder> getOrders() {
        return bookOrders;
    }

    public void setOrders(List<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    public Client() {}

    public Client(String imie, String nazwisko, String adres, String nrTel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTel = nrTel;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }
}
