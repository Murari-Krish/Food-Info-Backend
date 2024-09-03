package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Model;
import com.example.demo.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository repo;

   
    public List<Object[]> getCostAndHotelNameByNameAndArea(String name, String area) {
    	String lowerCaseName=name.toLowerCase();
    	String lowerCaseReplace=lowerCaseName.replace(" ", "");
    	String lowerArea=area.toLowerCase();
    	if(name.equals(lowerCaseReplace) || name.equals(lowerCaseName) || area.equals(lowerArea)) {
    		return repo.getCostAndHotelNameByNameAndArea(lowerCaseName, area);
    	}
		return null;
     }

   
    public List<Object[]> getNameAndAreaByCost(Integer cost) {
        return repo.getNameAndAreaByCost(cost);
    }

   
    public List<Object[]> getNearestCosts(Integer cost) {
        List<Object[]> result = new ArrayList<>();
        List<Model> below = repo.findNearestBelowCost(cost);
        List<Model> above = repo.findNearestAboveCost(cost);

        if (!below.isEmpty()) {
            result.add(new Object[] { below.get(0).getItemName(), below.get(0).getArea(), below.get(0).getCost() });
        }
        if (!above.isEmpty()) {
            result.add(new Object[] { above.get(0).getItemName(), above.get(0).getArea(), above.get(0).getCost() });
        }
        return result;
    }

    public List<Object[]> getCostAndHotelNameByItemName(String itemName) {
    	String lowercaseItemName=itemName.toLowerCase();
        return repo.findCostAndHotelNameByItemName(lowercaseItemName);
    }

    
    public List<String> getAreasByItemName(String itemName) {
    	String lowercaseItemName=itemName.toLowerCase();
        return repo.findAreasByItemName(lowercaseItemName);
    }

   
    public List<Long> getCostsByItemName(String itemName) {
    	String lowercaseItemName=itemName.toLowerCase();
        return repo.findCostsByItemName(lowercaseItemName);
    }

   
    public void saveModel(Model model) {
        repo.save(model);
    }


	@Override
	public List<Long> findCostByItemNameAreaNameAndHotelName(String itemName, String area, String hotelName) {
		return repo.findCostByItemNameAreaNameAndHotelName(itemName,area,hotelName);
	}
}
