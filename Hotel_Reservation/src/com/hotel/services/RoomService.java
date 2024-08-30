package com.hotel.services;

import com.hotel.models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService {
    private List<Room> rooms = new ArrayList<>();

    public RoomService() {
        // Initial data (You can add more rooms as needed)
        rooms.add(new Room(1, "Standard", 100.0, true));
        rooms.add(new Room(2, "Deluxe", 150.0, true));
        rooms.add(new Room(3, "Suite", 200.0, true));
    }

    public List<Room> searchAvailableRooms(String category) {
        return rooms.stream()
                .filter(room -> room.isAvailable() && room.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Room findRoomById(int roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId() == roomId)
                .findFirst()
                .orElse(null);
    }

    public void updateRoomAvailability(int roomId, boolean isAvailable) {
        Room room = findRoomById(roomId);
        if (room != null) {
            room.setAvailable(isAvailable);
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}