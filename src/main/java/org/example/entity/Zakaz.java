package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Zakaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column (name = "date_of_order")
    private String dateOfOrder;

    @Column (name = "date_of_to")
    private String dateOfTo;

    @OneToMany(mappedBy = "zakaz", cascade = CascadeType.ALL)
    private List<Zakazano> orderedItems;

    // Геттеры и сеттеры
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getDateOfTo() {
        return dateOfTo;
    }

    public void setDateOfTo(String dateOfTo) {
        this.dateOfTo = dateOfTo;
    }

    public List<Zakazano> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Zakazano> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
