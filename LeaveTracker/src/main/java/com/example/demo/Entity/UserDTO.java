package com.example.demo.Entity;

public class UserDTO {

    private String username;
    private String role;
    private int employeeId;

    // Default constructor (needed for Feign)
    public UserDTO() {}

    public UserDTO(String username, String role, int employeeId) {
        this.username = username;
        this.role = role;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
}
