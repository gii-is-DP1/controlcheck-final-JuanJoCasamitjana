package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.owner.Owner;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    @Query("SELECT care FROM Care care")
	List<Care> findAllCares();
    @Query("SELECT DISTINCT care FROM Care care LEFT JOIN FETCH care.compatiblePetTypes as type WHERE type.name = :petTypeName ")
    List<Care> findCompatibleCares(String petTypeName);
    @Query("SELECT care.name FROM Care care")
    Care findCareByName(String name);
    @Query("SELECT careProvision FROM CareProvision careProvision LEFT JOIN FETCH  careProvision.visit as visit WHERE visit.id = :visitId")
    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
