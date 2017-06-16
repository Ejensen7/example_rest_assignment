package com.erik.repositories;

import java.util.List;

import org.springframework.data.repository.*;

import com.erik.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findByName(String name);
}
