package com.nova.shoppinglist.controllers;

import com.nova.shoppinglist.dao.ShoppingItemRepository;
import com.nova.shoppinglist.dao.UserRepository;
import com.nova.shoppinglist.domain.ShoppingItem;
import com.nova.shoppinglist.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ShoppingListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingListController.class);

    @Autowired
    private ShoppingItemRepository repository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String indexPage(Model model, Principal principal){
        LOGGER.info("User name - {}", principal.getName());
        model.addAttribute("items", repository.findByUserUserName(principal.getName()));
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShoppingItem shoppingItem, Principal principal){
        User user = userRepository.findByUserName(principal.getName()).orElseThrow();
        shoppingItem.setUser(user);
        repository.save(shoppingItem);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteItem(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:/";
    }



}
