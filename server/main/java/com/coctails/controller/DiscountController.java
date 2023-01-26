package com.coctails.controller;


import com.coctails.entity.Discounts;
import com.coctails.regex.StaticVariables;
import com.coctails.service.DiscountsService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "${api.client}")
@RestController
@RequestMapping("/admin")
@Log4j2
public class DiscountController {
    @Autowired
    private DiscountsService discountsService;

    @PostMapping(value = "/discounts")
    public ResponseEntity<?> discounts(@RequestBody Discounts discounts){
        if(discountsService.nameExists(discounts.getName()))
            return new ResponseEntity<>(StaticVariables.emailExists, HttpStatus.CONFLICT);
        discountsService.addDiscount(discounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/discounts")
    public ResponseEntity<List<Discounts>> getDiscounts(){
        ArrayList<Discounts> discounts = discountsService.getList();
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

    @DeleteMapping(value = "/discounts")
    public ResponseEntity<?> deleteDiscount(@PathVariable Integer id){
        discountsService.deleteDiscount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
