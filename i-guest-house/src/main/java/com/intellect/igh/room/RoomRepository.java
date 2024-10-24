/**
 * 
 */
package com.intellect.igh.room;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author lakshmipriya.ramesh
 *
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	//query
	Optional<Room> findById(Integer roomNumber);

}
