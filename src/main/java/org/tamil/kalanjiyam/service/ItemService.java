package org.tamil.kalanjiyam.service;

import org.springframework.stereotype.Service;
import org.tamil.kalanjiyam.dto.Item;

@Service
public interface ItemService {

	public Item getItem(String itemName, Integer categoryId);
	
}
