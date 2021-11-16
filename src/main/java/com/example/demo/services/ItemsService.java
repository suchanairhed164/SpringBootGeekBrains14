package com.example.demo.services;

import com.example.demo.entities.Item;
import com.example.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ItemsService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        System.out.println(itemRepository.findByTitle("Frostmourne"));
        System.out.println(itemRepository.findByCostBetween(30,70));
        return itemRepository.findAll();
    }
//    public Page<Item> getItemsWithPagingAndFiltering(Specification<Item> specifications, Pageable pageable){
//        return itemRepository.findAll(specifications, (org.springframework.data.domain.Pageable) pageable);
//    }
}
