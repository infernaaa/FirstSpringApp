package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tovar")
public class Tovar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tovar")
    private int idTovar;

    @Column(name = "cost")
    private int cost;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @OneToMany(mappedBy = "tovar", cascade = CascadeType.ALL)
    private List<Zakazano> orderedItems;

    // Геттеры и сеттеры
    public int getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(int idTovar) {
        this.idTovar = idTovar;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Zakazano> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Zakazano> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
