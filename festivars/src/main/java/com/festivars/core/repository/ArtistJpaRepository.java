package com.festivars.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.festivars.core.model.Artist;

@Repository("artistJpaRepository")
public interface ArtistJpaRepository extends JpaRepository<Artist,Serializable> {
	
	public abstract Artist findById(int id);
	public abstract List<Artist> findByAlias(String alias);
	@Transactional
	public abstract void deleteById(int id);

}
