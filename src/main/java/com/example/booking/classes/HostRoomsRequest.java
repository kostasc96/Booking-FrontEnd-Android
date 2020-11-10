package com.example.booking.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HostRoomsRequest {

	@SerializedName("roomId")
	@Expose
	private long roomId;

	@SerializedName("photo")
	@Expose
	private byte[] photo;

	@SerializedName("price")
	@Expose
	private long price;

	@SerializedName("location")
	@Expose
	private String location;

	@SerializedName("rating")
	@Expose
	private Double rating;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	
	
}
