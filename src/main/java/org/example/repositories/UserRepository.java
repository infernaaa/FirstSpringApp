package org.example.repositories;

import org.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
    @Query("SELECT SUM(z.cost) " +
            "FROM Client c " +
            "JOIN c.orders o " +
            "JOIN o.orderedItems z " +
            "WHERE c.idClient = :clientId")
    Integer calculateTotalPurchasesByClientId(@Param("clientId") Long clientId);

}
