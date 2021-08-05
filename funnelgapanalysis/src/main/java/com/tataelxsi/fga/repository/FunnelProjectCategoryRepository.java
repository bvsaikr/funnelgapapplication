package com.tataelxsi.fga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tataelxsi.fga.entity.FunnelProjectCategory;

@Repository
public interface FunnelProjectCategoryRepository extends JpaRepository<FunnelProjectCategory,Long> {

	@Query(value ="select * from funnel_project_category u where u.category = ?1",nativeQuery = true)
	FunnelProjectCategory findByCategory(String category);

	
	

	
	
	
	
	
}
