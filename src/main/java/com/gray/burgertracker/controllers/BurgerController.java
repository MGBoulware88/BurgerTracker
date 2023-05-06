package com.gray.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gray.burgertracker.models.Burger;
import com.gray.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/burgers")
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	//home route
	@GetMapping("")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> allBurgers = burgerService.findAllBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	//POST for adding a new Burger
	@PostMapping("/create")
	public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			List<Burger> allBurgers = burgerService.findAllBurgers();
			model.addAttribute("allBurgers", allBurgers);
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
	//DELETE a Burger
	@DeleteMapping("/delete/{id}")
	public String deleteBurger(@PathVariable("id") Long id) {
		burgerService.deleteBurger(id);
		return "redirect:/burgers";
	}
	// form to edit a Burger 
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
		}
	//PUT to update an existing Burger
	@PutMapping("/{id}")
	public String editBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		System.out.println(burger.getId());
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/burgers";
		}
		
	}
}
