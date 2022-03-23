package org.formation.mediatheque.repository;

import java.util.List;

import org.formation.mediatheque.model.Emprunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprunteRepository extends JpaRepository<Emprunte, Long> {
	
	
	//ReadALL empruntes
	//public List<Emprunte> findByMembreId(long idMembre);

}
