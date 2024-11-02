package org.example.repositories;

import org.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
    @Query("SELECT SUM(z.cost * (1 - (z.skidka / 100))) " +
            "FROM Client c " +
            "JOIN c.orders o " +
            "JOIN o.orderedItems z " +
            "WHERE c.idClient = :clientId")
    Integer calculateTotalPurchasesByClientId(@Param("clientId") Long clientId);

    @Query("SELECT z.dateOfOrder, z.dateOfTo, SUM(za.cost * (1 - (za.skidka / 100))) AS sumaZakaza " +
            "FROM Client c " +
            "JOIN c.orders z " +
            "JOIN z.orderedItems za " +
            "WHERE c.idClient = :clientId " +
            "GROUP BY z.dateOfOrder, z.dateOfTo")
    List<Object[]> findOrderSumsByClientId(@Param("clientId") Long clientId);

}
