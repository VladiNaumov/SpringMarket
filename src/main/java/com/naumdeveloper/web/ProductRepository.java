package com.naumdeveloper.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // @Query("select s from Product s where s.Price between ?1 and ?2")
    List<Product> findAllByPriceBetween(Double min, Double max);

    // @Query("select s from Product s where s.id = :id")
    Optional<Product> findById(Long id);


    /* действие пример выполнения нативных запросов  */
    @Query("select s from Product s where s.score < 20")
    List<Product> findLowRatingProducs();

    @Query("select s.price from Product s where s.name = ?1")
    Integer hqlGetScoreByName(String name);

    @Query(value = "select score from product where name = :name", nativeQuery = true)
    Integer nativeSqlGetScoreByName(String name);

}
