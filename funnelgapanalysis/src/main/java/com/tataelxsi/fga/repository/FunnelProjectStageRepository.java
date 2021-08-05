package com.tataelxsi.fga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tataelxsi.fga.entity.FunnelProjectStage;

@Repository
public interface FunnelProjectStageRepository extends JpaRepository<FunnelProjectStage,Long> {

	@Query(value ="select * from funnel_project_stage u where u.stage = ?1",nativeQuery = true)
	FunnelProjectStage findByStage(String Stage);

	
	
	

}
