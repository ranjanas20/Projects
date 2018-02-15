package com.greenfield.skateboard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.skateboard.database.springData.ItemRepository;
import com.greenfield.skateboard.entity.Item;

@Service
public class ItemService {

	@Autowired
	ItemRepository repo;

	public List<Item> findItems() {
		return repo.findAll();
	}
	
	public Item addItem(Item item) {
		return repo.saveAndFlush(item);
	}

	public Item updateItem(Item updatedItem) {
		return repo.saveAndFlush(updatedItem);
	}

	public void deleteItem(Integer id) {
		repo.delete(id);
	}

	public void setRepo(ItemRepository repo) {
		this.repo = repo;
	}
}