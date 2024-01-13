package com.workintech.s18g2.controller;


import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.exceptions.FruitException;
import com.workintech.s18g2.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> getAll(){
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id){
        Fruit fruit = fruitService.find(id);
        if(fruit == null){
            throw new FruitException("Fruit with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.findAllByPriceDesc();
    }


    //hem update hem save işlemi yapar
    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> save(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id){
        Fruit fruit=fruitService.find(id);
        fruitService.delete(fruit);
        return fruit;
    }


}
