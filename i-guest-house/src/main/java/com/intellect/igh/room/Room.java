/**
 * 
 */
package com.intellect.igh.room;

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
public class Room{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
	private Integer roomNumber;
	private String roomType;
	private Integer roomCapacity;
	private Integer roomCount;
	private Boolean isAvailable;
	private Integer floorNumber;
	private Integer towerNumber;
	private String furnitures;
}
