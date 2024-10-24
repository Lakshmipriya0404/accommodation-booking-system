/**
 * 
 */
package com.intellect.igh.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.intellect.igh.exception.ResourceNotFoundException;
import com.intellect.igh.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * @author lakshmipriya.ramesh
 *
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository repository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userEmail) {
		return repository.findByEmail(userEmail)
				.orElseThrow(()->
				new ResourceNotFoundException("No user exist with the mail : " + userEmail));
	}
	
}
