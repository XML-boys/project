package com.xmlboys.service;

import com.xmlboys.model.CodeItem;
import com.xmlboys.repository.CodeBook;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBookService {

    @Autowired
    CodeBook codeBook;

    public CodeItem save (CodeItem item) {return codeBook.save(item);}

    public List<CodeItem> findAll() {return Lists.newArrayList(codeBook.findAll());}

    public CodeItem update(CodeItem item) {return codeBook.save(item);}

    public void delete(Long id) {codeBook.deleteById(id);}

    public CodeItem findById(Long id) {return codeBook.findById(id).orElseGet(null);}
}
