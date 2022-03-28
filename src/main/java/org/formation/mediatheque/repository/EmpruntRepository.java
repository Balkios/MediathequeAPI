package org.formation.mediatheque.repository;

import java.util.List;

import org.formation.mediatheque.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
	
	
	//ReadALL empruntes
	public List<Emprunt> findByMembreId(long idMembre);
	
	@javax.transaction.Transactional
	@Modifying
	@Query("delete from Emprunt e where e.document.id =?2 and e.membre.id=?1")
	public void deleteEmprunteByIdMembreAndIdDocument(long idMembre, long idDocument);

}
