package web;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // @Query("select s from Product s where s.name = :name")
    Optional<Product> findByName(String name);

}
