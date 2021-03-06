package org.formation.mediatheque.repository;

import java.util.Date;
import java.util.List;

import org.formation.mediatheque.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	// ReadALL dispo
	@Query("select d from Document d where d.nbreExemplaires >0")
	public List<Document> findDocumentDisponible();
	
	
	//ReadALL dispo et new 
	@Query("select d from Document d where d.nbreExemplaires >0 and d.dateParution > ?1")
	public List<Document> findDocumentDisponibleByDateParution(Date date);
	

	// restituer l'emprunte ==> le document est retournĂ©
	@Modifying // modification de base car on utilse update oe delete 
	@javax.transaction.Transactional
	@Query("update Document d set d.nbreExemplaires =d.nbreExemplaires +1 where d.id=?1")
	public void restituerDocumentById(long id);
}
