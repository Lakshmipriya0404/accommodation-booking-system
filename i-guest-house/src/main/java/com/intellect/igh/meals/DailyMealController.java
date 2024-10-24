/**
 * 
 */
package com.intellect.igh.meals;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

/**
 * @author lakshmipriya.ramesh
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("dailyMeal")
public class DailyMealController {
	
	private final DailyMealService dailyMealService;
	
	@PostMapping
	public ResponseEntity<?> insertMeal(@RequestBody DailyMeal meal) {
		dailyMealService.insertMeal(meal);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<DailyMeal> getMeal() {
		DailyMeal meal = dailyMealService.getMeal();
		return new ResponseEntity<DailyMeal>(meal,HttpStatus.OK);
	}

}
