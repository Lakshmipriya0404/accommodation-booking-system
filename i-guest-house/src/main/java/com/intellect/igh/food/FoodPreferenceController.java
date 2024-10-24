/**
 * 
 */
package com.intellect.igh.food;

import java.util.List;

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
@RequestMapping("food/preference")
public class FoodPreferenceController {
	
	private final FoodPreferenceService foodPreferenceService;
	
	@PostMapping
	public ResponseEntity<?> createFoodPreference(@RequestBody FoodPreferenceDto foodPreferenceRequest) {
		foodPreferenceService.createFoodPreference(foodPreferenceRequest);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<FoodPreferenceDto>> getAllFoodPreference() {
		List<FoodPreferenceDto> foodPreferenceDtos = foodPreferenceService.getAllFoodPreference();
		return new ResponseEntity<List<FoodPreferenceDto>>(foodPreferenceDtos,HttpStatus.OK);
	}
}
