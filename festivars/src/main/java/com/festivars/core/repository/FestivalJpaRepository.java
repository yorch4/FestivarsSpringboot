package com.festivars.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.festivars.core.model.Festival;

@Repository("festivalJpaRepository")
public interface FestivalJpaRepository extends JpaRepository<Festival,Serializable> {
	
	public abstract Festival findById(int id);
	public abstract List<Festival> findByName(String name);
	@Transactional
	public abstract void deleteById(int id);

}
