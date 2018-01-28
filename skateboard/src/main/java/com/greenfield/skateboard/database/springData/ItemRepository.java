package com.greenfield.skateboard.database.springData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenfield.skateboard.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
