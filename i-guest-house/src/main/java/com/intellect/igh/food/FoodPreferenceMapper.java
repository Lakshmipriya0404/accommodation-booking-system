/**
 * 
 */
package com.intellect.igh.food;

import org.springframework.stereotype.Component;

import com.intellect.igh.user.User;

/**
 * @author lakshmipriya.ramesh
 *
 */

@Component
public class FoodPreferenceMapper {
	
	public FoodPreference mapToFoodPreference(FoodPreferenceDto request, User foodFor) {
		return FoodPreference.builder()
				.foodForUser(foodFor)
				.breakfast(request.getBreakfast())
				.lunch(request.getLunch())
				.dinner(request.getDinner())
				.mealDate(request.getMealDate())
				.preferences(request.getPreferences())
				.build();
	}
	
	public FoodPreferenceDto mapToFoodPreferenceDto(FoodPreference request) {
		return FoodPreferenceDto.builder()
				.breakfast(request.getBreakfast())
				.lunch(request.getLunch())
				.dinner(request.getDinner())
				.userName(request.getFoodForUser().fullName())
				.userId(request.getFoodForUser().getAssoId())
				.preferences(request.getPreferences())
				.mealDate(request.getMealDate())
				.build();
	}

}
