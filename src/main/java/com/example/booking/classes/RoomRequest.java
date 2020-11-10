package com.example.booking.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class RoomRequest {

	@SerializedName("id")
	@Expose
	private Long id;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("country")
	@Expose
	private String country;

	@SerializedName("city")
	@Expose
	private String city;

	@SerializedName("address")
	@Expose
	private String address;

	@SerializedName("beginDate")
	@Expose
	private Date beginDate;

	@SerializedName("endDate")
	@Expose
	private Date endDate;

	@SerializedName("peopleNumber")
	@Expose
	private Integer peopleNumber;

	@SerializedName("price")
	@Expose
	private Double price;

	@SerializedName("extraCostPerPerson")
	@Expose
	private Double extraCostPerPerson;

	@SerializedName("roomType")
	@Expose
	private String roomType;

	@SerializedName("rules")
	@Expose
	private String rules;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("numberOfBeds")
	@Expose
	private Integer numberOfBeds;

	@SerializedName("numberOfBathrooms")
	@Expose
	private Integer numberOfBathrooms;

	@SerializedName("numberOfBedrooms")
	@Expose
	private Integer numberOfBedrooms;

	@SerializedName("diningRoom")
	@Expose
	private Boolean diningRoom;

	@SerializedName("squaredMeters")
	@Expose
	private Double squaredMeters;

	@SerializedName("base64photos")
	@Expose
	private List<String> base64photos;

	@SerializedName("userId")
	@Expose
	private Long userId;

	@SerializedName("aircondition")
	@Expose
	private Boolean aircondition;

	@SerializedName("balcony")
	@Expose
	private Boolean balcony;

	@SerializedName("pool")
	@Expose
	private Boolean pool;

	@SerializedName("smoking")
	@Expose
	private Boolean smoking;

	@SerializedName("tv")
	@Expose
	private Boolean tv;

	@SerializedName("wifi")
	@Expose
	private Boolean wifi;
	

	public RoomRequest() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getExtraCostPerPerson() {
		return extraCostPerPerson;
	}

	public void setExtraCostPerPerson(Double extraCostPerPerson) {
		this.extraCostPerPerson = extraCostPerPerson;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Integer getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(Integer numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public Integer getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(Integer numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public Boolean getDiningRoom() {
		return diningRoom;
	}

	public void setDiningRoom(Boolean diningRoom) {
		this.diningRoom = diningRoom;
	}

	public Double getSquaredMeters() {
		return squaredMeters;
	}

	public void setSquaredMeters(Double squaredMeters) {
		this.squaredMeters = squaredMeters;
	}

	
	
	public List<String> getBase64photos() {
		return base64photos;
	}

	public void setBase64photos(List<String> base64photos) {
		this.base64photos = base64photos;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getAircondition() {
		return aircondition;
	}

	public void setAircondition(Boolean aircondition) {
		this.aircondition = aircondition;
	}

	public Boolean getBalcony() {
		return balcony;
	}

	public void setBalcony(Boolean balcony) {
		this.balcony = balcony;
	}

	public Boolean getPool() {
		return pool;
	}

	public void setPool(Boolean pool) {
		this.pool = pool;
	}

	public Boolean getSmoking() {
		return smoking;
	}

	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}

	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	
	

}
