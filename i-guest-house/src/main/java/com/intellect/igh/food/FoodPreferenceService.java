/**
 * 
 */
package com.intellect.igh.food;

import java.util.List;

/**
 * @author lakshmipriya.ramesh
 *
 */
public interface FoodPreferenceService {

	FoodPreferenceDto createFoodPreference(FoodPreferenceDto foodPreferenceRequest);

	List<FoodPreferenceDto> getAllFoodPreference();

}
