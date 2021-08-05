package com.tataelxsi.fga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tataelxsi.fga.entity.FunnelBuc;

@Repository
public interface FunnelBucRepository extends JpaRepository<FunnelBuc,Long> {

	@Query(value ="select * from funnel_buc u where u.buname = ?1 and u.competency = ?2",nativeQuery = true)
	FunnelBuc findByBUNameCompetency(String buname, String competency);

	

	
	

	
	
}
