package org.tamil.kalanjiyam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.tamil.kalanjiyam.dto.SearchRequest;
import org.tamil.kalanjiyam.entity.ItemData;

public class ItemDAO {

	private static final String SELECT_ITEM = "Select i from ItemData i ";
	private static final String SELECT_TAGS = " ,IN(i.tags) t ";
	private static final String WHERE = " WHERE ";
	private static final String AND = " AND ";
	private static final String CATEGORY = " i.category.id = %s ";
	private static final String CONTENT = " i.content LIKE '%s' ";
	private static final String TEXT = " (i.content LIKE '%%%s%%' OR i.explanation LIKE '%%%s%%') ";
	private static final String TAG = " (t.tagName = '%s' AND t.tagValue ='%s') ";
	
	public static List<ItemData> searchItems(SearchRequest request, Integer categoryId, EntityManager manager) {
		List<ItemData> results = null;
		List<String> criteria = new ArrayList<String>();
		if (request != null) {
			StringBuilder queryBuilder = new StringBuilder(SELECT_ITEM);
			
			if (categoryId != null) {
				criteria.add(String.format(CATEGORY, categoryId));
			}
			if (request.getText() != null && request.getText().trim() != ""){
				criteria.add(String.format(TEXT, request.getText(), request.getText()));
			} else if (request.getContent() != null && request.getContent().trim() != "") {
				criteria.add(String.format(CONTENT, request.getContent()));
			}
			if (request.getTags() != null && request.getTags().size() > 0) {
				queryBuilder.append(SELECT_TAGS);
				for (Entry<String, String> tag : request.getTags().entrySet()) {
					criteria.add(String.format(TAG, tag.getKey(), tag.getValue()));
				}
			}			
			if(criteria.size() > 0) {
				queryBuilder.append(WHERE);
			}
			boolean firstItr = true;
			for (String cri : criteria) {
				if(!firstItr) {
					queryBuilder.append(AND);
				}
				queryBuilder.append(cri);
				if (firstItr) {
					firstItr = false;
				}				
			}
			
			Query query = manager.createQuery(queryBuilder.toString());
			query.setFirstResult(request.getStart());
			if (request.getLimit() != null) {
				query.setMaxResults(request.getLimit());
			}		
			
			results = query.getResultList();			
		}
			
		return results;
	}
	
}
