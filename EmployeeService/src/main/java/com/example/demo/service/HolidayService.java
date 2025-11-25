package com.example.demo.service;

import com.example.demo.entity.Holiday;
import com.example.demo.repository.HolidayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

	@Autowired
    private  HolidayRepository repo;


    public List<Holiday> getAll() {
        return repo.findAll();
    }

    public Holiday addHoliday(Holiday h) {
        return repo.save(h);
    }

    public Holiday updateHoliday(Long id, Holiday h) {
        Holiday old = repo.findById(id).orElseThrow();
        old.setDate(h.getDate());
        old.setName(h.getName());
        return repo.save(old);
    }

    public void deleteHoliday(Long id) {
        repo.deleteById(id);
    }
}
