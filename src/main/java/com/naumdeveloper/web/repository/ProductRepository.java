package com.naumdeveloper.web.repository;

import com.naumdeveloper.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

/*
    // @Query("select s from Product s where s.Price between ?1 and ?2")
    List<Product> findAllByPriceBetween(Double min, Double max);

    // @Query("select s from Product s where s.name = :name")
    Optional<Product> findByName(String name);


    // пример выполнения нативных запросов  //
    @Query("select s from Product s where s.price < 20")
    List<Product> findLowRatingProduct();

    @Query("select s.price from Product s where s.name = ?1")
    Integer hqlGetScoreByName(String name);

    @Query(value = "select price from product where name = :name", nativeQuery = true)
    Integer nativeSqlGetScoreByName(String name);

*/

}
