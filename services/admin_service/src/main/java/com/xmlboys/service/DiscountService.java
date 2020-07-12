package com.xmlboys.service;

import com.xmlboys.model.Discount;
import com.xmlboys.repository.DiscountRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    DiscountRepository rep;

    public Discount save(Discount discount) {return rep.save(discount);}
    public void delete(Long id) {rep.deleteById(id);}
    public List<Discount> findAll(){return Lists.newArrayList(rep.findAll());}

}
