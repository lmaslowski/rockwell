package com.kata.rockwell.divisor.adapter.mappers.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    private Integer number;

    private String name;

}
