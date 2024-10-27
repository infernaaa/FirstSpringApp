package org.example.repositories;

import org.example.entity.Client;
import org.example.entity.Tovar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TovarRepository extends JpaRepository<Tovar, Long> {

}
