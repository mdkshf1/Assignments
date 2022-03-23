package com.mappinginjpa.repos;

import com.mappinginjpa.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Author,Integer> {
}
