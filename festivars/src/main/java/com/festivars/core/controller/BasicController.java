package com.festivars.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.festivars.core.model.Artist;
import com.festivars.core.model.Festival;
import com.festivars.core.service.impl.ArtistsServiceImpl;
import com.festivars.core.service.impl.FestivalsServiceImpl;

@Controller
@RequestMapping("/catalog")
public class BasicController {
	
	@Autowired
	@Qualifier("festivalsServiceImpl")
	FestivalsServiceImpl fjr;
	
	@Autowired
	@Qualifier("artistsServiceImpl")
	ArtistsServiceImpl ajr;
	
	//	artists.add(new Artist(1, "Alesso", "Progressive House", 29, "Suecia", "https://direct.rhapsody.com/imageserver/images/Art.44837525/356x237.jpg"));
	//	artists.add(new Artist(2,"Steve Angello", "House", 37, "Suecia / Grecia", "https://allmusicspain.com/wp-content/uploads/2018/04/Steve-Angello.png"));
	//	artists.add(new Artist(3,"Sebastian Ingrosso", "House", 36 , "Suecia", "http://streamkat.com/wp-content/uploads/2013/04/sebastian_ingrosso.jpg"));
	
	@GetMapping("")
	public String allFestivals(Model model) {
		List<Festival> festivalsList;
		festivalsList = fjr.getAll();
		model.addAttribute("festivalsList", festivalsList);
		return "index";
	}
	
	@GetMapping("artists")
	public String allArtists(Model model) {
		List<Artist> artistsList;
		artistsList = ajr.getAll();
		model.addAttribute("artists", artistsList);
		return "artists";
	}
	
	@GetMapping("addFestival")
	public String addFestival(Model model) {
		List<Artist> artistsList;
		artistsList = ajr.getAll();
		model.addAttribute("artists", artistsList);
		return "addFestival";
	}
	
	@GetMapping("addArtist")
	public String addArtist() {
		return "addArtist";
	}
	
	@GetMapping("updateFestival")
	public String updateFestival() {
		return "redirect:/catalog";
	}
	
	@GetMapping("details")
	public String details(Model model, @RequestParam("id") int id) {
		Festival festival = fjr.findById(id);
		model.addAttribute("festival", festival);
		return "details";
	}
}
