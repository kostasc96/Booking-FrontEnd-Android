package com.example.booking.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRequest {

	@SerializedName("id")
	@Expose
    private Long id;

	@SerializedName("name")
	@Expose
    private String name;

	@SerializedName("surname")
	@Expose
    private String surname;

	@SerializedName("username")
	@Expose
    private String username;

	@SerializedName("email")
	@Expose
    private String email;

	@SerializedName("mobileNumber")
	@Expose
    private String mobileNumber;

	@SerializedName("role")
	@Expose
    private String role;

	@SerializedName("photo")
	@Expose
    private byte[] photo;


	public UserRequest() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}
