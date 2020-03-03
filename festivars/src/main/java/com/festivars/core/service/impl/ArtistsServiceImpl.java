package com.festivars.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.festivars.core.model.Artist;
import com.festivars.core.repository.ArtistJpaRepository;
import com.festivars.core.service.ArtistsService;


@Service("artistsServiceImpl")
public class ArtistsServiceImpl implements ArtistsService {
	
	@Autowired
	@Qualifier("artistJpaRepository")
	private ArtistJpaRepository ajr;
	
	@Override
	public List<Artist> getAll() {
		return ajr.findAll();
	}

	@Override
	public Artist addArtist(Artist c) {
		return ajr.save(c);
	}

	@Override
	public int removeArtist(int id) {
		ajr.deleteById(id);
		return 0;
	}

	@Override
	public Artist updateArtist(Artist c) {
		return ajr.save(c);
	}
	
	public Artist findById(int id) {
		return ajr.findById(id);
	}

}
