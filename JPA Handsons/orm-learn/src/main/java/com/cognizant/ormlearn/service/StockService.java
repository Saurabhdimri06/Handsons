package com.cognizant.ormlearn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.repository.StocksRepository;

@Service
public class StockService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	@Autowired
	private StocksRepository repo;
	
	@Transactional
	public List<Stock> findStocks(Date start, Date end){
		List<Stock> st = repo.findByDateBetween(start, end);
		return st;
	}
	
	@Transactional
	public List<Stock> checkStockValue(Double open){
		List<Stock> st = repo.findByOpenGreaterThan(open);
		return st;
	}
	
	@Transactional
	public List<Stock> topThreeStocksDate(){
		List<Stock> st = repo.findDateOrderByVolumeDesc();
		List<Stock> res = new ArrayList<Stock>();
		for(int i = 0; i < 3; i++) {
			res.add(st.get(i));	
		}
		return res;
		
	}
	
	@Transactional
	public List<Stock> botThreeStocksClose(){
		List<Stock> st = repo.findDateOrderByCloseAsc();
		List<Stock> res = new ArrayList<Stock>();
		for(int i = 0; i < 3; i++) {
			res.add(st.get(i));	
		}
		return res;
		
	}
}
