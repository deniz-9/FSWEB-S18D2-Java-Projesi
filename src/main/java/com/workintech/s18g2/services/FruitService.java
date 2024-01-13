package com.workintech.s18g2.services;

import com.workintech.s18g2.entity.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> findAll();

    List<Fruit> findAllByPriceDesc();

    List<Fruit> findAllByPriceAsc();

    List<Fruit> searchByName(String name);

    Fruit find(int id);

    Fruit save(Fruit fruit);

    void delete(Fruit fruit);

}
