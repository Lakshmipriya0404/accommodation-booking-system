/**
 * 
 */
package com.intellect.igh.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lakshmipriya.ramesh
 *
 */
@Repository
public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Long>{

}
