package com.xmlboys.repository;

import com.xmlboys.model.CodeItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeBook extends CrudRepository<CodeItem, Long> {

    CodeItem findByVendor(String vendor);
}
