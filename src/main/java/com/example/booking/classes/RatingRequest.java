package com.example.booking.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingRequest {

	@SerializedName("id")
	@Expose
	private long id;

	@SerializedName("rating")
	@Expose
	private int rating;

	@SerializedName("critic")
	@Expose
	private String critic;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCritic() {
		return critic;
	}

	public void setCritic(String critic) {
		this.critic = critic;
	}
	
	
	

}
