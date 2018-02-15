package com.greenfield.skateboard.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.greenfield.skateboard.database.springData.ItemRepository;
import com.greenfield.skateboard.entity.Item;
import static org.mockito.Mockito.*;

public class ItemServiceTest2 {
	private ItemService service;
	
    private ItemRepository repo=mock(ItemRepository.class);
	
	private String name="sanjay";
	@Before
	public void setup(){
		service = new ItemService();
		service.setRepo(repo);
		Item item = new Item(1,true,name);
		
		 Mockito.when(repo.findAll())
	      .thenReturn(Arrays.asList(item));
		 
		
	}
	@Test
	public void testFindItems() {
		List<Item> items = service.findItems();
		assertTrue(items.size()==1);
		assertTrue(items.get(0).getDescription().equals(name));
	}


}
