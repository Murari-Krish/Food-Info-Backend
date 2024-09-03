package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Model;

public interface FoodService {
    List<Object[]> getCostAndHotelNameByNameAndArea(String name, String area);
    List<Object[]> getNameAndAreaByCost(Integer cost);
    List<Object[]> getNearestCosts(Integer cost);
    List<Object[]> getCostAndHotelNameByItemName(String itemName);
    List<String> getAreasByItemName(String itemName);
    List<Long> getCostsByItemName(String itemName);
    List<Long> findCostByItemNameAreaNameAndHotelName(String itemName, String area, String hotelName);
    void saveModel(Model model);
}
