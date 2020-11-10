package com.example.booking.classes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomsRequest {

	@SerializedName("id")
	@Expose
	private Long id;

	@SerializedName("base64photo")
	@Expose
	private String base64photo;

	@SerializedName("price")
	@Expose
	private Double price;

	@SerializedName("location")
	@Expose
	private String location;

	@SerializedName("rating")
	@Expose
	private Double rating;

	public String getBase64photo() {
		return base64photo;
	}

	public void setBase64photo(String base64photo) {
		this.base64photo = base64photo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
