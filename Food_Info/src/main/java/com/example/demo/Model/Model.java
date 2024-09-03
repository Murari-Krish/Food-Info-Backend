package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "foodlistdata")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "area")
    private String area;
    
    @Column(name = "cost")
    private Long cost;
    
    @Column(name = "discount")
    private Integer discount;

    @Column(name = "hotel_name")
    private String hotelName;
    
    @Column(name = "item_name")
    private String itemName;

    
}
