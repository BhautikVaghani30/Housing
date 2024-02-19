package com.housing.house.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.housing.house.constant.House;
import com.housing.house.entites.Property;
import com.housing.house.service.PropertyService;
import com.housing.house.utilites.HouseUtils;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProperties(@RequestBody List<Property> properties) {
        try {
            propertyService.saveProperties(properties);
            return HouseUtils.getResponseEntity("Properties saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HouseUtils.getResponseEntity(House.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ○ Average sale price of the house overall
    @GetMapping("/avrageSalePrice")
    public ResponseEntity<String> getAverage() {
        try {
            double avgSallPrice = propertyService.calAvg();
            return HouseUtils.getResponseEntity(
                    "○	Average sale price of the house overall : " + Double.toString(avgSallPrice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HouseUtils.getResponseEntity(House.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ○ ○ Average sale price of the house per location
    @GetMapping("/AverageSalePricePerLocation/{location}")
    public ResponseEntity<String> getAverageLocation(@PathVariable("location") String location) {

        try {

            double avrage = propertyService.calAvglocation(location);
            return HouseUtils.getResponseEntity(
                    "Average sale price of the house per location is : " + Double.toString(avrage), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return HouseUtils.getResponseEntity(House.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ○ Max sale price
    @GetMapping("/MaxSalePrice")
    public ResponseEntity<String> maxsale() {
        try {
            double MaxSalePrice = propertyService.calMaxPrice();
            return HouseUtils.getResponseEntity("Max sale price is : " + Double.toString(MaxSalePrice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return HouseUtils.getResponseEntity(House.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ○ Min sale price
    @GetMapping("/MinSalePrice")
    public ResponseEntity<String> minsale() {

        try {

            double MinSalePrice = propertyService.calMinPrice();

            return HouseUtils.getResponseEntity("Min sale price is : " + Double.toString(MinSalePrice), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return HouseUtils.getResponseEntity(House.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
