package org.formation.mediatheque.service;

import java.util.HashSet;
import java.util.Set;

import org.formation.mediatheque.CustomUserDetails;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.MembreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	MembreRepository memberRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Membre member = memberRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("no such username"));
		Set<GrantedAuthority> granteAuth =new HashSet<>();
		granteAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new CustomUserDetails(member.getId(),member.getEmail(),"{noop}"+member.getPassword(),member.getNom(),member.getPrenom()) ;
	}

	

}
