package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StocksRepository extends JpaRepository<Stock, String> {


	public List<Stock> findByDateBetween(Date start, Date end);
	public List<Stock> findByOpenGreaterThan(Double open);
	
	//limit 3 not working
	@Query(value = "select s from Stock s order by s.volume desc")
	public List<Stock> findDateOrderByVolumeDesc();
	
	@Query(value = "select s from Stock s order by s.close asc")
	public List<Stock> findDateOrderByCloseAsc();
}
