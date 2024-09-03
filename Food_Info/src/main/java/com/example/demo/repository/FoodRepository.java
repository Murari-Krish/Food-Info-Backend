package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Model;

@Repository
public interface FoodRepository extends JpaRepository<Model, Integer> {

    @Query("SELECT m.cost, m.hotelName FROM Model m WHERE m.itemName = :name AND m.area = :area")
    List<Object[]> getCostAndHotelNameByNameAndArea(String name, String area);

    @Query("SELECT m.itemName, m.area FROM Model m WHERE m.cost = :cost")
    List<Object[]> getNameAndAreaByCost(Integer cost);

    @Query("SELECT m FROM Model m WHERE m.cost < :cost ORDER BY m.cost DESC")
    List<Model> findNearestBelowCost(Integer cost);

    @Query("SELECT m FROM Model m WHERE m.cost > :cost ORDER BY m.cost ASC")
    List<Model> findNearestAboveCost(Integer cost);
    
    @Query("SELECT m.cost, m.hotelName FROM Model m WHERE m.itemName = :name")
    List<Object[]> findCostAndHotelNameByItemName(String name);

    @Query("SELECT DISTINCT m.area FROM Model m WHERE m.itemName = :name")
    List<String> findAreasByItemName(String name);

    @Query("SELECT DISTINCT m.cost FROM Model m WHERE m.itemName = :name")
    List<Long> findCostsByItemName(String name);
    
    @Query("SELECT m.cost FROM Model m WHERE m.itemName = :itemName AND m.area = :area AND m.hotelName = :hotelName")
    List<Long> findCostByItemNameAreaNameAndHotelName(String itemName, String area, String hotelName);

}
