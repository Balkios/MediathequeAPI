package org.formation.mediatheque.repository;

import java.util.Date;
import java.util.List;

import org.formation.mediatheque.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	// ReadALL dispo
	@Query("select d from Document d where d.disponible =?1")
	public List<Document> findDocumentByDisponible(boolean disponible);
	
	
	//ReadALL dispo et new 
	@Query("select d from Document d where d.disponible =?2 and d.dateParution > ?1")
	public List<Document> findDocumentByDateParutionAndDisponible(Date date,boolean disponible);
	
	// modfier dispo en non dispo ==> ça sera une emprunte
//	@Query("update Document d set d.disponible=?1 where d.id=?2")
//	public void modificationDisponibleById(boolean disponible, long idDocument);

}
