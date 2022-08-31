package com.naumdeveloper.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // @Query("select s from Product s where s.score between ?1 and ?2")
    List<Product> findAllByDiscountBetween(Integer min, Integer max);

    // @Query("select s from Product s where s.id = :id")
    Optional<Product> findById(Long id);

}
