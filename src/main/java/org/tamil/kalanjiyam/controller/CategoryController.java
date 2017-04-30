package org.tamil.kalanjiyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tamil.kalanjiyam.core.AppException;
import org.tamil.kalanjiyam.dto.Category;
import org.tamil.kalanjiyam.dto.Item;
import org.tamil.kalanjiyam.service.CategoryService;
import org.tamil.kalanjiyam.service.ItemService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(value="/public/item/{categoryName}/{itemName}", method=RequestMethod.GET)
	public Item getUser(@PathVariable String categoryName, @PathVariable String itemName) {
		// retrieve item for this particular category
		Category category = categoryService.getCategory(categoryName);
		if (category != null) {
			return itemService.getItem(itemName, category.getId());
		} else {
			throw new AppException("ERR_001", HttpStatus.BAD_REQUEST, "Invalid category name");
		}
	}
	
}
