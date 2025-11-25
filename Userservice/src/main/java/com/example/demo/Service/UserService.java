package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	public String saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		 userRepo.save(user);
		 return "Success";
	}
	

	

}
