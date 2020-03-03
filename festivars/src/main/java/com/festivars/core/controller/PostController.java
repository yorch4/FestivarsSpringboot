package com.festivars.core.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.festivars.core.model.Artist;
import com.festivars.core.model.Festival;
import com.festivars.core.service.impl.ArtistsServiceImpl;
import com.festivars.core.service.impl.FestivalsServiceImpl;

@Controller
@RequestMapping("/catalog")
public class PostController {
	
	@Autowired
	@Qualifier("festivalsServiceImpl")
	FestivalsServiceImpl fjr;
	
	@Autowired
	@Qualifier("artistsServiceImpl")
	ArtistsServiceImpl ajr;
	

	@PostMapping("addFestival")
	public String addFestival(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("allowed_age") int allowed_age, @RequestParam("capacity") int capacity, @RequestParam("date") Date date, @RequestParam("photo") String photo) {
		Festival f = new Festival(name, description, capacity, allowed_age, date, photo);
		fjr.addFestival(f);
		return "redirect:/catalog";
	}
	
	@PostMapping("addArtist")
	public String addArtist(@RequestParam("alias") String alias, @RequestParam("description") String description, @RequestParam("gender") String gender, @RequestParam("age") int age, @RequestParam("nacionality") String nacionality, @RequestParam("photo") String photo) {
		Artist a = new Artist(alias, description, gender, age, nacionality, photo);
		ajr.addArtist(a);
		return "redirect:/catalog/artists";
	}
	
	@PostMapping("")
	public String removeFestival(@RequestParam("idOculto") int id) {
		fjr.removeFestival(id);
		return "redirect:/catalog";
	}
	
	@PostMapping("artists")
	public String removeArtist(@RequestParam("idOculto") int id) {
		ajr.removeArtist(id);
		return "redirect:/catalog/artists";
	}
	
	@PostMapping("updateFestival")
	public String updateFestival(Model model, @RequestParam("idOculto") int id) {
		Festival f = fjr.findById(id);
		model.addAttribute("festival", f);
		return "updateFestival";
	}
	
	@PostMapping("updateArtist")
	public String updateArtist(Model model, @RequestParam("idOculto") int id) {
		Artist a = ajr.findById(id);
		model.addAttribute("artist", a);
		return "updateArtist";
	}
	
	@PostMapping("updateFestival/confirm")
	public String updateFestival(@RequestParam("idOculto") int id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("allowed_age") int allowed_age, @RequestParam("capacity") int capacity, @RequestParam("date") Date date, @RequestParam("photo") String photo) {
		Festival f = new Festival(id, name, description, capacity, allowed_age, date, photo);
		fjr.updateFestival(f);
		return "redirect:/catalog";
	}
	
	@PostMapping("updateArtist/confirm")
	public String updateArtist(@RequestParam("idOculto") int id, @RequestParam("alias") String alias, @RequestParam("description") String description, @RequestParam("gender") String gender, @RequestParam("age") int age, @RequestParam("nacionality") String nacionality, @RequestParam("photo") String photo) {
		Artist a = new Artist(id, alias, description, gender, age, nacionality, photo);
		ajr.updateArtist(a);
		return "redirect:/catalog/artists";
	}
}
