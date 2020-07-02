package com.calculator.repo;

import com.calculator.entity.DataBaseRequest;
import org.springframework.data.repository.CrudRepository;

public interface DataBaseRequestRepo extends CrudRepository<DataBaseRequest, Long> {
}
