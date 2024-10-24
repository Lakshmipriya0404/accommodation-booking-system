/**
 * 
 */
package com.intellect.igh.food;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.intellect.igh.booking.BookingService;
import com.intellect.igh.user.User;

import lombok.RequiredArgsConstructor;

/**
 * @author lakshmipriya.ramesh
 *
 */

@RequiredArgsConstructor
@Service
public class FoodPreferenceServiceImpl implements FoodPreferenceService{
	
	private final FoodPreferenceRepository foodPreferenceRepository;
	private final FoodPreferenceMapper foodPreferenceMapper;
	private final BookingService bookingService;
	
	
	@Override
	public FoodPreferenceDto createFoodPreference(FoodPreferenceDto foodPreferenceRequest) {
		
		User loggedUser = bookingService.getLoggedInUser();
		
		FoodPreference foodPreference = foodPreferenceMapper.mapToFoodPreference(foodPreferenceRequest, loggedUser);
		return foodPreferenceMapper.mapToFoodPreferenceDto(foodPreferenceRepository.save(foodPreference));
	}
	

	@Override
	public List<FoodPreferenceDto> getAllFoodPreference() {
		List<FoodPreference> foodPreferences = foodPreferenceRepository.findAll();
		return foodPreferences.stream()
			.map(foodPreferenceMapper::mapToFoodPreferenceDto)
			.collect(Collectors.toList());
	}

}
