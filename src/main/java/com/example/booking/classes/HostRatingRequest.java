package com.example.booking.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HostRatingRequest {

	@SerializedName("username")
	@Expose
	String username;

	@SerializedName("base64photo")
	@Expose
	String base64photo;

	@SerializedName("rating")
	@Expose
	Double rating;

	@SerializedName("critics")
	@Expose
	List<String> critics;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<String> getCritics() {
		return critics;
	}

	public void setCritics(List<String> critics) {
		this.critics = critics;
	}

	public String getBase64photo() {
		return base64photo;
	}

	public void setBase64photo(String base64photo) {
		this.base64photo = base64photo;
	}
	
	
	

}
