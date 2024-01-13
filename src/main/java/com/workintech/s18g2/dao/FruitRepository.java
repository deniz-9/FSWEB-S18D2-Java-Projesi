package com.workintech.s18g2.dao;

import com.workintech.s18g2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    //JPQL kodu
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> searchByName(String name);
}

