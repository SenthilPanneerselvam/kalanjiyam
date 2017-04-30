package org.tamil.kalanjiyam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamil.kalanjiyam.entity.CategoryData;

public interface CategoryRepository extends JpaRepository<CategoryData, Integer>{

	public CategoryData findByName(String name);
}
