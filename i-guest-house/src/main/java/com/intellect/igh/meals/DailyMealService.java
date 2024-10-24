/**
 * 
 */
package com.intellect.igh.meals;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

/**
 * @author lakshmipriya.ramesh
 *
 */
@RequiredArgsConstructor
@Service
public class DailyMealService {
	
	private final DailyMealRepository dailyMealRepository;
	
	public void insertMeal(DailyMeal meal) {
		dailyMealRepository.deleteAll();
		meal.setId(1);
		dailyMealRepository.save(meal);
	}

	public DailyMeal getMeal() {
		return dailyMealRepository.findAll().get(0);
	}

}
