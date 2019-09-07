package br.com.alura.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forum.model.User;
import br.com.alura.forum.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> possibleUser = userRepository.findByEmail(email);
		
		return possibleUser.orElseThrow(
				() -> new UsernameNotFoundException("Could not find user with email:" + email));
	}

	public UserDetails loadUserById(Long userId) {
		Optional<User> possibleUser = userRepository.findById(userId);
		return possibleUser.orElseThrow(
				() -> new UsernameNotFoundException("Could not find user with id: " + userId));
	}
	
}
