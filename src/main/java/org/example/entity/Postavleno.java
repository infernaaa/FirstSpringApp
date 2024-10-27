package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postavleno")
public class Postavleno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postavka")
    private int idPostavka;

    @ManyToOne
    @JoinColumn(name = "id_postavka", insertable = false, updatable = false)
    private Postavka postavka;

    @ManyToOne
    @JoinColumn(name = "id_tovar")
    private Tovar tovar;

    @Column(name = "amount_tovar")
    private int amountTovar;

    @Column(name = "cost")
    private int cost;

    @Column(name = "skidka")
    private int skidka;

    // Геттеры и сеттеры
    public int getIdPostavka() {
        return idPostavka;
    }

    public void setIdPostavka(int idPostavka) {
        this.idPostavka = idPostavka;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }

    public Postavka getPostavka() {
        return postavka;
    }

    public void setPostavka(Postavka postavka) {
        this.postavka = postavka;
    }

    public int getAmountTovar() {
        return amountTovar;
    }

    public void setAmountTovar(int amountTovar) {
        this.amountTovar = amountTovar;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSkidka() {
        return skidka;
    }

    public void setSkidka(int skidka) {
        this.skidka = skidka;
    }
}
