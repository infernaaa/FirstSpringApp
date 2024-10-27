package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "postavchik")
public class Postavchik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postavchik")
    private int idPostavchik;

    @Column (name = "town")
    private String town;

    @Column (name = "adress")
    private String adress;

    @Column (name = "number_of_phone")
    private String numberOfPhone;

    @Column (name = "raiting")
    private int raiting;

    @OneToMany(mappedBy = "postavchik", cascade = CascadeType.ALL)
    private List<Postavka> deliveries;

    // Геттеры и сеттеры
    public int getIdPostavchik() {
        return idPostavchik;
    }

    public void setIdPostavchik(int idPostavchik) {
        this.idPostavchik = idPostavchik;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public List<Postavka> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Postavka> deliveries) {
        this.deliveries = deliveries;
    }
}
