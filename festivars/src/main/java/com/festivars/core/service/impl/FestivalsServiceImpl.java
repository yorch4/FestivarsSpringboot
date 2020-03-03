package com.festivars.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.festivars.core.model.Festival;
import com.festivars.core.repository.FestivalJpaRepository;
import com.festivars.core.service.FestivalsService;


@Service("festivalsServiceImpl")
public class FestivalsServiceImpl implements FestivalsService {
	
	@Autowired
	@Qualifier("festivalJpaRepository")
	private FestivalJpaRepository fjr;
	
	@Override
	public List<Festival> getAll() {
		return fjr.findAll();
	}

	@Override
	public Festival addFestival(Festival c) {
		return fjr.save(c);
	}

	@Override
	public int removeFestival(int id) {
		fjr.deleteById(id);
		return 0;
	}

	@Override
	public Festival updateFestival(Festival c) {
		return fjr.save(c);
	}
	
	public Festival findById(int id) {
		return fjr.findById(id);
	}

}
