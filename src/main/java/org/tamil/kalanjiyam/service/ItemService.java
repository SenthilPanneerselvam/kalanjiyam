package org.tamil.kalanjiyam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tamil.kalanjiyam.dto.Item;
import org.tamil.kalanjiyam.dto.SearchRequest;

@Service
public interface ItemService {

	public Item getItem(String itemName, Integer categoryId);
	
	public Long getItemCount(Integer categoryId);

	public List<Item> searchItems(SearchRequest searchRequest);
	
	public List<Item> searchItems(SearchRequest searchRequest, Integer categoryId);
	
}
