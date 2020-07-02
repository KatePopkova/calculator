package com.calculator.repo;

import com.calculator.entity.Operations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRequestRepo extends CrudRepository<Operations, Long> {
}
