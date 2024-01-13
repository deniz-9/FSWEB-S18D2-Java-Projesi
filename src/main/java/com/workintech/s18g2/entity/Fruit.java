package com.workintech.s18g2.entity;

import com.workintech.s18g2.enums.FruitType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit",schema = "fsweb")
public class Fruit extends Plant{

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType fruitType;


}


