package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;




@Entity
@Table(name="holiday")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private LocalDate date;   // yyyy-MM-dd
    private String name;   // Holiday Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
