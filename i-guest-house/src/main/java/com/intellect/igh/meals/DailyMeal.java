/**
 * 
 */
package com.intellect.igh.meals;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class DailyMeal {	

    @Id
    private Integer id;

    private String breakfast;

    private String lunch;

    private String dinner;

    private Date mealDate;

}
