/**
 * 
 */
package com.intellect.igh.room;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("rooms")
public class RoomController {
	
	private final RoomService roomService;
	
	@PostMapping
	public ResponseEntity<Room> createRoom(@RequestBody Room roomResponse){
		Room savedRoomResponse = roomService.createRoom(roomResponse);
		return new ResponseEntity<Room>(savedRoomResponse, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Room>> getAllRooms() {
		List<Room> rooms = roomService.getAllRooms();
		return ResponseEntity.ok(rooms);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable Integer id, @RequestBody Room updatedRoom) {
		Room roomResponse = roomService.updateRoom(id, updatedRoom);
		return ResponseEntity.ok(roomResponse);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable Integer id) {
		roomService.deleteRoom(id);
		return ResponseEntity.ok("Room deleted successfully");
	}
}
