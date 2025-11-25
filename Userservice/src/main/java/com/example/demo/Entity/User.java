package com.example.demo.Entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String username;
   private String password;
   private String role;
   private int employeeId;
   private boolean active = true;
   private LocalDateTime createdAt= LocalDateTime.now();;
   public int getId() {
	return id;
}
   public String getRole() {
	return role;
}
   public void setRole(String role) {
	this.role = role;
   }
   public int getEmployeeId() {
	return employeeId;
   }
   public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
   }
   public boolean isActive() {
	return active;
   }
   public void setActive(boolean active) {
	this.active = active;
   }
   public LocalDateTime getCreatedAt() {
	return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
   }
   public void setId(int id) {
	this.id = id;
   }
   public String getUsername() {
	   System.out.print(username);
	return username;
   }
   public void setUsername(String username) {
	this.username = username;
   }
   public String getPassword() {
	return password;
   }
   public void setPassword(String password) {
	this.password = password;
   }
}
