package org.example;

import jakarta.persistence.* ;

@Entity
@Table(name = "client") // Укажите имя таблицы

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "fio")
    private String fio;

    @Column(name = "b_day")
    private String bDay; // Предпочтительно использовать LocalDate

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "family_account")
    private String familyAccount;



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
}
