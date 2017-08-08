package org.tamil.kalanjiyam.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tamil.kalanjiyam.core.BeanMapper;
import org.tamil.kalanjiyam.dao.ItemDAO;
import org.tamil.kalanjiyam.dao.ItemRepository;
import org.tamil.kalanjiyam.dto.Item;
import org.tamil.kalanjiyam.dto.SearchRequest;
import org.tamil.kalanjiyam.entity.ItemData;
import org.tamil.kalanjiyam.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private BeanMapper beanMapper;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Item getItem(String itemName, Integer categoryId) {
		ItemData item = itemRepo.findByNameAndCategoryId(itemName, categoryId);
		return beanMapper.map(item, Item.class);
	}

	@Override
	public Long getItemCount(Integer categoryId) {
		return itemRepo.countByCategoryId(categoryId);
	}
	
	@Override
	public List<Item> searchItems(SearchRequest searchRequest) {
		List<ItemData> items = ItemDAO.searchItems(searchRequest,null, entityManager);
		return beanMapper.map(items, Item.class);
	}

	@Override
	public List<Item> searchItems(SearchRequest searchRequest, Integer categoryId) {
		List<ItemData> items = ItemDAO.searchItems(searchRequest, categoryId, entityManager);
		return beanMapper.map(items, Item.class);
	}

}
