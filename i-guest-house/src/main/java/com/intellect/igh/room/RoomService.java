/**
 * 
 */
package com.intellect.igh.room;

import java.util.List;


/**
 * @author lakshmipriya.ramesh
 *
 */
public interface RoomService {
	
	public Room createRoom(Room roomResponse);
	public List<Room> getAllRooms();
	public Room updateRoom(Integer id, Room updatedRoom);
	public void deleteRoom(Integer id);

}
