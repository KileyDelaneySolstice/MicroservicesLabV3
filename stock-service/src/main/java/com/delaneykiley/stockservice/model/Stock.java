package com.delaneykiley.stockservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    private Integer id;

    private String name;

    public Stock() {}

    public Stock(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setId() { this.id = id; }

    public void setName() { this.name = name; }

    public String toString() {
        return "Stock [id: " + id + ", name: " + name + "]";
    }

}
