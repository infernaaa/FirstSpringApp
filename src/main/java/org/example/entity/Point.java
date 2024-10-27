package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_point")
    private int idPoint;

    @Column (name = "city")
    private String city;

    @Column (name = "adress")
    private String adress;

    @Column (name = "number_of_phone")
    private String numberOfPhone;

    // Геттеры и сеттеры
    public int getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(int idPoint) {
        this.idPoint = idPoint;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }
}
