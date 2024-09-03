package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Model;
import com.example.demo.service.FoodService;

@RestController
@CrossOrigin
public class FoodRestController {

    @Autowired
    private FoodService foodServiceImpl;  

    @GetMapping("/response/cost-and-hotel/{name}/{area}")
    public ResponseEntity<List<Object[]>> getCostAndHotelNameByNameAndArea(@PathVariable String name, @PathVariable String area) {
        List<Object[]> status = foodServiceImpl.getCostAndHotelNameByNameAndArea(name, area);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
     
    @GetMapping("/response/name-and-area/{cost}")
    public ResponseEntity<List<Object[]>> getNameAndAreaByCost(@PathVariable Integer cost){
        List<Object[]> status = foodServiceImpl.getNameAndAreaByCost(cost);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/response/nearest/{cost}")
    public ResponseEntity<List<Object[]>> getNearestCosts(@PathVariable Integer cost){
        List<Object[]> status = foodServiceImpl.getNearestCosts(cost);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/response/itemname/{itemName}")
    public ResponseEntity<List<Object[]>> getCostAndHotelNameByItemName(@PathVariable String itemName) {
        List<Object[]> status = foodServiceImpl.getCostAndHotelNameByItemName(itemName);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/response/areas/{itemName}")
    public ResponseEntity<List<String>> getAreasByItemName(@PathVariable String itemName) {
        List<String> areas = foodServiceImpl.getAreasByItemName(itemName);
        return new ResponseEntity<>(areas, HttpStatus.OK);
    }

    @GetMapping("/response/costs/{itemName}")
    public ResponseEntity<List<Long>> getCostsByItemName(@PathVariable String itemName) {
        List<Long> costs = foodServiceImpl.getCostsByItemName(itemName);
        return new ResponseEntity<>(costs, HttpStatus.OK);
    }

    @PostMapping("/response/save")
    public ResponseEntity<Void> saveModel(@RequestBody Model model) {
        foodServiceImpl.saveModel(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/response/cost/{itemName}/{area}/{hotelName}")
    public ResponseEntity<List<Long>> findCostByItemNameAreaNameAndHotelName(@PathVariable String itemName,@PathVariable  String area, @PathVariable String hotelName) {
    	List<Long> costs =  foodServiceImpl.findCostByItemNameAreaNameAndHotelName(itemName, area, hotelName);
    	  return new ResponseEntity<>(costs, HttpStatus.OK);
      }
   }

