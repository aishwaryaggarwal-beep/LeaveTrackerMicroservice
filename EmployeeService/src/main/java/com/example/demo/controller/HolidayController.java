package com.example.demo.controller;

import com.example.demo.entity.Holiday;
import com.example.demo.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/holidays")
//@CrossOrigin(origins = "*")
public class HolidayController {

	@Autowired
    private  HolidayService service;

 

    @GetMapping
    public List<Holiday> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Holiday add(@RequestBody Holiday holiday) {
        return service.addHoliday(holiday);
    }

    @PutMapping("/{id}")
    public Holiday update(@PathVariable Long id, @RequestBody Holiday holiday) {
        return service.updateHoliday(id, holiday);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteHoliday(id);
    }
}
