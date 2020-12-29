package me.tereshko.web7.repositories;

import me.tereshko.web7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //List<Product> findAllByMinPrice(float min);
    //List<Product> findAllByPriceMaxPrice(float max);
    //List<Product> findAllByPriceBetweenMinAndMax(float min, float max);
}
