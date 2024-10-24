package com.intellect.igh.food;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class FoodPreferenceDto {
	
	private String userId;
	
	private String userName;
	
	private Boolean breakfast;
	private Boolean lunch;
	private Boolean dinner;
	
	private String preferences;
	
	private Date mealDate;

}
