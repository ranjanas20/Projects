package com.greenfield.skateboard.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.greenfield.skateboard.entity.Item;
import com.greenfield.skateboard.service.ItemService;


@RestController
@RequestMapping("/items")
public class ItemController {
  @Autowired
  private ItemService service;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Item> findItems() {
	System.out.println("Find All items function");
    return service.findItems();
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Item addItem(@RequestBody Item item) {
	item.setId(null);
    return service.addItem(item);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
	//System.out.println("inside Update Item");
    updatedItem.setId(id);
    return service.updateItem(updatedItem);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
	//System.out.println("inside delete Item");
    service.deleteItem(id);
  }
}
