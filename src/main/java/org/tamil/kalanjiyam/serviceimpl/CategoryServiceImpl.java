package org.tamil.kalanjiyam.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tamil.kalanjiyam.core.BeanMapper;
import org.tamil.kalanjiyam.dao.CategoryRepository;
import org.tamil.kalanjiyam.dto.Category;
import org.tamil.kalanjiyam.entity.CategoryData;
import org.tamil.kalanjiyam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private BeanMapper beanMapper;
	
	@Override
	public Category getCategory(String categoryName) {
		CategoryData category = categoryRepo.findByName(categoryName);
		return beanMapper.map(category, Category.class);
	}

}
