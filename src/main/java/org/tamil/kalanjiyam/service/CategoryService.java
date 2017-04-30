package org.tamil.kalanjiyam.service;

import org.springframework.stereotype.Service;
import org.tamil.kalanjiyam.dto.Category;

@Service
public interface CategoryService {

	public Category getCategory(String categoryName); 
	
}
