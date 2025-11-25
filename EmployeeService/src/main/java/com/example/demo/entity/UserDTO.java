package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private String id;
	
   private String username;
   private String password;
   public String getId() {
	return id;
}
   public void setId(String id) {
	this.id = id;
   }
   private String role;
   private int employeeId;
   public String getUsername() {
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
   public String getRole() {
	return role;
   }
   public void setRole(String role) {
	   System.out.println("role set"+ role);
	this.role = role;
   }
   public int getEmployeeId() {
	return employeeId;
   }
   public void setEmployeeId(int i) {
	this.employeeId = i;
   }
}
