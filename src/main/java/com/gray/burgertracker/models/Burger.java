package com.gray.burgertracker.models;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="burgers")
public class Burger {
	/*
	 ********************************
	 *************FIELDS*************
	 ********************************
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@NotBlank(message="Burger Name is required!")
	private String name;
	@NotNull
	@NotBlank(message="Restaurant Name is required!")
	private String restaurantName;
	@NotNull
	@Min(value=1, message="Rating must be between 1 and 5!")
	@Max(value=5, message="Rating must be between 1 and 5!")
	private int rating;
	@NotNull
	@NotBlank(message="Notes are required!")
	private String notes;
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	/*
	 ********************************
	 **********CONSTRUCTORS**********
	 ********************************
	 */
	//Java Bean! --don't use please!!
	public Burger() {}
	//Use this one instead :)
	public Burger(String name, String restaurant, int rating, String notes) {
		this.name = name;
		this.restaurantName = restaurant;
		this.rating = rating;
		this.notes = notes;
	}
	/*
	 ********************************
	 ********GETTERS & SETTERS*******
	 ********************************
	 */
	@PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
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
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
