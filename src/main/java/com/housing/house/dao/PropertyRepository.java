package com.housing.house.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housing.house.entites.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Double calculateAverageSalePrice();
    Double calculateAverageSalePriceByLocation(String location);
    Double findMaxSalePrice();
    Double findMinSalePrice();
}