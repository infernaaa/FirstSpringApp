package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "zakazano")
public class Zakazano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Zakaz zakaz;

    @ManyToOne
    @JoinColumn(name = "id_tovar")
    private Tovar tovar;

    @Column(name = "cost")
    private int cost;

    @Column(name = "skidka")
    private int skidka;

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zakaz getZakaz() {
        return zakaz;
    }

    public void setZakaz(Zakaz zakaz) {
        this.zakaz = zakaz;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
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
