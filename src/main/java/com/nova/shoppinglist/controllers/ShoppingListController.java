package com.nova.shoppinglist.controllers;

import com.nova.shoppinglist.dao.ShoppingItemRepository;
import com.nova.shoppinglist.domain.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingListController {

    @Autowired
    private ShoppingItemRepository repository;

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShoppingItem shoppingItem){
        repository.save(shoppingItem);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteItem(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:/";
    }



}
