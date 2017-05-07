package org.tamil.kalanjiyam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamil.kalanjiyam.entity.ItemData;

public interface ItemRepository extends JpaRepository<ItemData, Integer>{

	public ItemData findByNameAndCategoryId(String name, Integer categoryId);
	
	public Long countByCategoryId(Integer categoryId);
	
}
