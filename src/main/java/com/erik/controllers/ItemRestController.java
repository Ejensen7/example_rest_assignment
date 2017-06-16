package com.erik.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.erik.models.Item;
import com.erik.repositories.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemRestController {

	@Autowired
	private ItemRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Item>> getAllItems(){
		return new ResponseEntity<>((Collection<Item>) repo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id){
		return new ResponseEntity<>(repo.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"name"})
	public ResponseEntity<Collection<Item>> getItemByName(@RequestParam(value="name") String name){
		return new ResponseEntity<>(repo.findByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewItem(@RequestBody Item newItem){
		return new ResponseEntity<>(repo.save(newItem), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
	public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody Item updatedItem){
		Item update = repo.findOne(id);
		update.setName(updatedItem.getName());
		update.setPrice(updatedItem.getPrice());
		update.setType(updatedItem.getType());
		update.setBin(updatedItem.getBin());
		return new ResponseEntity<>(repo.save(update), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
	public @ResponseBody void deleteItem(@PathVariable Long id){
		repo.delete(id);
	}
}
