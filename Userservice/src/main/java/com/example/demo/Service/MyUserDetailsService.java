package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserPrincipal;
import com.example.demo.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("❌ User not found in DB for username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        System.out.println(user.getUsername());
		
		return new UserPrincipal(user);
	}

}
