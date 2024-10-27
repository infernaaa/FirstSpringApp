package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "postavka")
public class Postavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postavka")
    private int idPostavka;

    @ManyToOne
    @JoinColumn(name = "id_postavchik")
    private Postavchik postavchik;

    @ManyToOne
    @JoinColumn(name = "destination")
    private Point point;

    @Column(name = "number_of_fura")
    private int numberOfFura;

    @Column(name = "date_of_from")
    private String dateOfFrom;

    @Column(name = "date_of_to")
    private String dateOfTo;

    @OneToMany(mappedBy = "postavka", cascade = CascadeType.ALL)
    private List<Postavleno> postavleno;

    // Геттеры и сеттеры
    public int getIdPostavka() {
        return idPostavka;
    }

    public void setIdPostavka(int idPostavka) {
        this.idPostavka = idPostavka;
    }

    public Postavchik getPostavchik() {
        return postavchik;
    }

    public void setPostavchik(Postavchik postavchik) {
        this.postavchik = postavchik;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getNumberOfFura() {
        return numberOfFura;
    }

    public void setNumberOfFura(int numberOfFura) {
        this.numberOfFura = numberOfFura;
    }

    public String getDateOfFrom() {
        return dateOfFrom;
    }

    public void setDateOfFrom(String dateOfFrom) {
        this.dateOfFrom = dateOfFrom;
    }

    public String getDateOfTo() {
        return dateOfTo;
    }

    public void setDateOfTo(String dateOfTo) {
        this.dateOfTo = dateOfTo;
    }

    public List<Postavleno> getPostavleno() {
        return postavleno;
    }

    public void setPostavleno(List<Postavleno> postavleno) {
        this.postavleno = postavleno;
    }
}
