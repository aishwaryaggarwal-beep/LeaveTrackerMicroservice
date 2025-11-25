package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDTO;
import com.example.demo.Repository.UserRepository;
//import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.JwtService;
import com.example.demo.Service.MyUserDetailsService;
import com.example.demo.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
 
	
	@Autowired
	private UserRepository userRepo;;
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("health-check")
	public String hii() {
		return "hie";
	}
	
	@GetMapping("user")
	public List<User> getALL(){
		return service.getAllUser();
	}
//	@PreAuthorize("hasAuthority('ADMIN')") 
	@PostMapping("register")
	public String register(@RequestBody User user) {
		return service.saveUser(user);
	}
//	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authenticate.isAuthenticated()) {
			UserDetails userDetails = myUserDetailsService.loadUserByUsername(user.getUsername());
			return jwtService.generateToken(userDetails);
		}
		return "Failure";
	}

	 @GetMapping("user/{username}")
	    public UserDTO getUser(@PathVariable String username) {
	        User user = userRepo.findByUsername(username);
	        UserDTO dto = new UserDTO();
	        dto.setUsername(user.getUsername());
	        dto.setEmployeeId(user.getEmployeeId());
	        dto.setRole(user.getRole());
	        return dto;
	    }
	

}
