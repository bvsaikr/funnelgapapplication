package com.tataelxsi.fga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tataelxsi.fga.entity.FunnelCustomer;

@Repository
public interface FunnelCustomerRepository extends JpaRepository<FunnelCustomer,Long> {

	@Query(value ="select * from funnel_customer u where u.customer_name = ?1",nativeQuery = true)
	FunnelCustomer findByCustomerName(String customer);

	



}
