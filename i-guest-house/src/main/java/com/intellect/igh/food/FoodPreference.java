/**
 * 
 */
package com.intellect.igh.food;

import java.sql.Date;

import com.intellect.igh.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author lakshmipriya.ramesh
 *
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodPreference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long foodId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "foodForUser", referencedColumnName = "assoId")
	private User foodForUser;
	
	private Boolean breakfast;
	private Boolean lunch;
	private Boolean dinner;
	
	private String preferences;
	
	private Date mealDate;

}
