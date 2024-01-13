package com.workintech.s18g2.services;

import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();
    List<Vegetable> findAllByPriceDesc();
    List<Vegetable> findAllByPriceAsc();
    List<Vegetable> searchByName(String name);
    Vegetable find(int id);
    Vegetable save(Vegetable vegetable);
    void delete(Vegetable vegetable);
}
