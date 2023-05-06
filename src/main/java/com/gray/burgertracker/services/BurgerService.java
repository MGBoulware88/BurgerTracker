package com.gray.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gray.burgertracker.models.Burger;
import com.gray.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	/*
	 ********************************
	 **************DATA**************
	 ********************************
	 */
	//get all
	public List<Burger> findAllBurgers() {
		return burgerRepository.findAll();
	}
	//get one by ID
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else return null;
	}
	//create one
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	//update one by ID
	public Burger updateBurger(Burger burger) {	
		return burgerRepository.save(burger);
	}
	//delete one by ID
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
}
