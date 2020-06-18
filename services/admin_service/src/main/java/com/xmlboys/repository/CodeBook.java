package com.xmlboys.repository;

import com.xmlboys.model.CodeItem;
import org.springframework.data.repository.CrudRepository;

public interface CodeBook extends CrudRepository<CodeItem, Long> {


}
