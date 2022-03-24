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
	@Query("select d from Document d where d.nbreExemplaires >0")
	public List<Document> findDocumentDisponible();
	
	
	//ReadALL dispo et new 
	@Query("select d from Document d where d.nbreExemplaires >0 and d.dateParution > ?1")
	public List<Document> findDocumentByDateDisponibleParution(Date date);
	
	// modfier dispo en non dispo ==> ça sera une emprunte
//	@Query("update Document d set d.disponible=?1 where d.id=?2")
//	public void modificationDisponibleById(boolean disponible, long idDocument);

	// modfier dispo en non dispo ==> ça sera une emprunte
		@Query("update Document d set d.nbreExemplaires=breExemplaires-1 ")
		public void modificationNbreExemplaires();
}
