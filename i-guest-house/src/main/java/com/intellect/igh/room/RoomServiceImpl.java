/**
 * 
 */
package com.intellect.igh.room;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * @author lakshmipriya.ramesh
 *
 */
@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService{
	
	private final RoomRepository roomRepository;

	@Override
	public Room createRoom(Room roomResponse) {
		checkAvailability(roomResponse);
		return roomRepository.save(roomResponse);
	}
	
	@Override
	//@Transactional(readOnly = true)
	public List<Room> getAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		return rooms;
	}

	@Override
	public Room updateRoom(Integer roomNumber, Room updatedRoom) {
		//need to implement exception
		Room room = roomRepository.findById(roomNumber).orElseThrow(()->
		new EntityNotFoundException("No room exist with the given id : " + roomNumber));
		room.setRoomType(updatedRoom.getRoomType());
		room.setRoomCapacity(updatedRoom.getRoomCapacity());
		room.setRoomCount(updatedRoom.getRoomCount());
		room.setFurnitures(updatedRoom.getFurnitures());
		checkAvailability(room);
		return roomRepository.save(room);
	}

	@Override
	public void deleteRoom(Integer roomNumber) {
		roomRepository.findById(roomNumber).orElseThrow(()->
		new EntityNotFoundException("No room exist with the given id : " + roomNumber));
		roomRepository.deleteById(roomNumber);
	}
	
	private void checkAvailability(Room room) {
		if(room.getRoomCapacity()==0) {
			room.setIsAvailable(false);
		} else {
			room.setIsAvailable(true);
		}
	}
	
}
