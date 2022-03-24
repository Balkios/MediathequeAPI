package org.formation.mediatheque.service;

import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreService {
	
	@Autowired
	MembreRepository membreRepository;
	
	public Membre authentif(String email, String password) throws Exception{
		Membre m =membreRepository.findByEmailAndPassword(email,password);
		if (m.equals(null))
			throw new Exception("authentif échouée");
		return m;
	}

}
