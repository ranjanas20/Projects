package com.greenfield.skateboard.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.greenfield.skateboard.entity.Item;


/**
 * Test Order Service, runs the test in Spring container
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml") 
@Transactional
public class ItemServiceTest {

	@Autowired
	ItemService itemService;
	
	@Before
	public void setUp() throws Exception {
		//item1
		Item item= new Item();
		item.setDescription("Powder");
		item.setChecked(false);
		Item itemAdded = itemService.addItem(item);
		System.out.println(itemAdded + " Saved Successfuly");
		
		//item2
		Item item1= new Item();
		item1.setDescription("Pen");
		item1.setChecked(false);
		Item itemAdded1 = itemService.addItem(item1);
		System.out.println(itemAdded1 + " Saved Successfuly");
		//item3
		Item item2= new Item();
		item2.setDescription("Orange");
		item2.setChecked(false);
		Item itemAdded2 = itemService.addItem(item2);
		System.out.println(itemAdded2 + " Saved Successfuly");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddItem() {
		//item1
		Item item= new Item();
		item.setDescription("Soap");
		item.setChecked(false);
		Item itemAdded = itemService.addItem(item);
		System.out.println(itemAdded + " Added Successfuly");
		
		List<Item> listOfItems;
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			System.out.println(entry + " Fetched after UpdatedItems.");
		}
				
	}
	
	@Test
	public void testListItems() {
		List<Item> listOfItems;
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			System.out.println(entry + " Fetched ListOfItems.");
		}
		
	}
	
	@Test
	public void testUpdateItems() {
		Item item= new Item();
		item.setDescription("Pencil");
		item.setChecked(true);
		
		List<Item> listOfItems;
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			if (entry.getDescription().equals("Powder")) {
				item.setId(entry.getId());
				break;
			}
		}
		
		
		Item itemUpdated = itemService.updateItem(item);
		System.out.println(itemUpdated + " Updated Successfuly");
		
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			System.out.println(entry + " Fetched after UpdatedItems.");
		}
	}
	
	@Test
	public void testDeleteItems() {
		
		List<Item> listOfItems;
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			if (entry.getDescription().equals("Pen")) {
				itemService.deleteItem(entry.getId());
				System.out.println("Item Deleted Successfuly");
				break;
			}
		}
		
		listOfItems = itemService.findItems();
		for(Item entry: listOfItems ){
			System.out.println(entry + " Fetched after DeletedItems.");
		}
		
		
		
	}

}
