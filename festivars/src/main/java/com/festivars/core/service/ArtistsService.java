package com.festivars.core.service;

import java.util.List;

import com.festivars.core.model.Artist;

public interface ArtistsService {

	public abstract List<Artist>getAll ();
	public abstract Artist addArtist(Artist c);
	public abstract int removeArtist(int id);
	public abstract Artist updateArtist(Artist c);
}
