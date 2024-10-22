package org.example;

import jakarta.persistence.* ;

@Entity
@Table(name = "client") // Укажите имя таблицы
public class User {

    @Id
    @Column(name = "idClient")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "B-Day")
    private String bDay; // Предпочтительно использовать LocalDate

    @Column(name = "CreditCard")
    private String creditCard;

    @Column(name = "FamilyAccount")
    private String familyAccount;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
