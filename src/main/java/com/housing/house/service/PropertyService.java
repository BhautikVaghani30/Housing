package com.housing.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housing.house.dao.PropertyRepository;
import com.housing.house.entites.Property;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @SuppressWarnings("null")
    public void saveProperties(List<Property> properties) {
        try {
            propertyRepository.saveAll(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double calAvg() {
        return propertyRepository.calculateAverageSalePrice();
    }
    public double calAvglocation(String Location) {
        return propertyRepository.calculateAverageSalePriceByLocation(Location);
    }
    public double calMaxPrice() {
        return propertyRepository.findMaxSalePrice();
    }
    public double calMinPrice() {
        return propertyRepository.findMinSalePrice();
    }
}
