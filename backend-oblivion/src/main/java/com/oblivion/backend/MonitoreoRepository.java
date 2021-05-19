																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Wed May 19 13:39:30 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.oblivion.backend;

import com.oblivion.backend.Monitoreo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MonitoreoRepository extends JpaRepository<Monitoreo, Long> {

	Optional <Monitoreo> findByIdMonitoreo(Long idMonitoreo);
	
	void deleteByIdMonitoreo(Long idMonitoreo);
	
}
