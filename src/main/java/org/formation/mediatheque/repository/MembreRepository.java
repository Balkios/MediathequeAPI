package org.formation.mediatheque.repository;

import org.formation.mediatheque.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {
	
	//authentif 
	public Membre findByEmailAndPassword(String email, String password);

}
