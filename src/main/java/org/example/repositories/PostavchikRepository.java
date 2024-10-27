package org.example.repositories;

import org.example.entity.Client;
import org.example.entity.Postavchik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostavchikRepository extends JpaRepository<Postavchik, Long> {

}
