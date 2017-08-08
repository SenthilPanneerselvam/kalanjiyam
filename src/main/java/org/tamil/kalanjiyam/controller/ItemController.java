package org.tamil.kalanjiyam.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tamil.kalanjiyam.core.AppException;
import org.tamil.kalanjiyam.dto.Category;
import org.tamil.kalanjiyam.dto.Item;
import org.tamil.kalanjiyam.dto.SearchRequest;
import org.tamil.kalanjiyam.service.CategoryService;
import org.tamil.kalanjiyam.service.ItemService;
import org.tamil.kalanjiyam.utils.KalanjiyamUtils;

@CrossOrigin
@RestController
public class ItemController {
	
	private static final String RANDOM = "Random";
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(value="/public/item/{categoryName}/{itemName}", method=RequestMethod.GET)
	public Item getItem(@PathVariable String categoryName, @PathVariable String itemName) {
		// retrieve item for this particular category
		Category category = categoryService.getCategory(categoryName);
		
		if (category != null) {
			if (RANDOM.equalsIgnoreCase(itemName)) {
				Long count = itemService.getItemCount(category.getId());
				if(count != null && count > 0) {
					itemName = String.valueOf(Math.ceil(count * Math.random()));
				}
			}
			return itemService.getItem(itemName, category.getId());
		} else {
			throw new AppException("ERR_001", HttpStatus.BAD_REQUEST, "Invalid category name");
		}
	}
	
	@RequestMapping(value="/public/item/{categoryName}", method=RequestMethod.GET)
	public List<Item> searchitems(@PathVariable String categoryName, @RequestParam Map<String,String> requestParams) {
		// retrieve item for this particular category
		Category category = categoryService.getCategory(categoryName);
		if (category != null) {
			SearchRequest request = KalanjiyamUtils.getSearchRequest(requestParams);
			return itemService.searchItems(request, category.getId());
		} else {
			throw new AppException("ERR_001", HttpStatus.BAD_REQUEST, "Invalid category name");
		}
	}
	
}
