package com.coctails.service;

import com.coctails.entity.Discounts;
import com.coctails.repository.DiscountsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Log4j2
public class DiscountsService {
    @Autowired
    private DiscountsRepository discountsRepository;

    @Transactional
    public void save(Discounts discounts){
        discountsRepository.save(discounts);
    }

    @Transactional
    public void delete(Integer id){
        discountsRepository.delete(discountsRepository.findById(id).get());
    }

    public boolean nameExists(String name){
        return discountsRepository.findByName(name).isPresent();
    }

    public void addDiscount(Discounts discounts){
        discounts.setName(discounts.getName().toUpperCase());
        save(discounts);
    }

    public ArrayList<Discounts> getList(){
        return (ArrayList<Discounts>) discountsRepository.findAll();
    }

    public void deleteDiscount(Integer id){
        delete(id);
    }
}
