package org.tamil.kalanjiyam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tamil.kalanjiyam.entity.RequestResponse;

public interface RequestRepository extends MongoRepository<RequestResponse, String> {

}
