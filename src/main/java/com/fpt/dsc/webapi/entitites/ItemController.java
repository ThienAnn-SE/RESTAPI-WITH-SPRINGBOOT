package com.fpt.dsc.webapi.entitites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @PostMapping
    public boolean addNewItem(@RequestBody Item item){
        return  itemService.addNewItem(item);
    }

    @PutMapping
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteItem(@PathVariable("id") String id){
        return itemService.deleteItem(id);
    }

}
