package com.housing.house.entites;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@NamedQuery(name = "Property.calculateAverageSalePrice", query = "SELECT AVG(he.salePrice) FROM Property he")
@NamedQuery(name = "Property.calculateAverageSalePriceByLocation", query = "SELECT AVG(he.salePrice) FROM Property he WHERE he.location = :location")
@NamedQuery(name = "Property.findMaxSalePrice", query = "SELECT MAX(he.salePrice) FROM Property he")
@NamedQuery(name = "Property.findMinSalePrice", query = "SELECT MIN(he.salePrice) FROM Property he")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bedrooms;
    private int bathrooms;
    private int squareFootage;
    private String location;
    private Double  salePrice;
    

}
