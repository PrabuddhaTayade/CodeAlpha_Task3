	package com.hotel.models;
public class Room {


	    private int roomId;
	    private String category;
	    private double pricePerNight;
	    private boolean isAvailable;

	    public Room(int roomId, String category, double pricePerNight, boolean isAvailable) {
	        this.roomId = roomId;
	        this.category = category;
	        this.pricePerNight = pricePerNight;
	        this.isAvailable = isAvailable;
	    }

	    // Getters and Setters
	    public int getRoomId() {
	        return roomId;
	    }

	    public void setRoomId(int roomId) {
	        this.roomId = roomId;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public double getPricePerNight() {
	        return pricePerNight;
	    }

	    public void setPricePerNight(double pricePerNight) {
	        this.pricePerNight = pricePerNight;
	    }

	    public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void setAvailable(boolean available) {
	        isAvailable = available;
	    }

	    @Override
	    public String toString() {
	        return "Room{" +
	                "roomId=" + roomId +
	                ", category='" + category + '\'' +
	                ", pricePerNight=" + pricePerNight +
	                ", isAvailable=" + isAvailable +
	                '}';
	    }
	}

