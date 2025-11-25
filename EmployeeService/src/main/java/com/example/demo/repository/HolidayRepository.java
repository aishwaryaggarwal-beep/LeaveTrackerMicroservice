package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

	List<Holiday> findAll();
}
