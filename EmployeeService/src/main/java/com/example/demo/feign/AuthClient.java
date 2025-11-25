package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.UserDTO;

@FeignClient("USERSERVICE")
public interface AuthClient {
	
//	@PreAuthorize("hasAuthority('ADMIN')") 
	@PostMapping("register")
	public String register(@RequestBody UserDTO user);

}
