package com.gray.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gray.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
	//grab all
	List<Burger> findAll();
	//all other methods needed from from Crud for free

}
