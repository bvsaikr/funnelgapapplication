package com.tataelxsi.fga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tataelxsi.fga.entity.FunnelProjectProbability;

@Repository
public interface FunnelProjectProbabilityRepository extends JpaRepository<FunnelProjectProbability,Long> {

	@Query(value ="select * from funnel_project_probability u where u.probability = ?1",nativeQuery = true)
	FunnelProjectProbability findByProbability(String probability);

	
	

}
