package com.festivars.core.service;

import java.util.List;

import com.festivars.core.model.Festival;

public interface FestivalsService {

	public abstract List<Festival>getAll ();
	public abstract Festival addFestival(Festival c);
	public abstract int removeFestival(int id);
	public abstract Festival updateFestival(Festival c);
}
