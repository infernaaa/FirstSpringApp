package org.example.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column (name ="fio")
    private String fio;

    @Column (name = "b_day")
    private String bDay;

    @Column (name = "credit_card")
    private String creditCard;

    @Column(name = "family_account")
    private String familyAccount;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Zakaz> orders;

    // Геттеры и сеттеры
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getFamilyAccount() {
        return familyAccount;
    }

    public void setFamilyAccount(String familyAccount) {
        this.familyAccount = familyAccount;
    }

    public List<Zakaz> getOrders() {
        return orders;
    }

    public void setOrders(List<Zakaz> orders) {
        this.orders = orders;
    }
}
