package com.fpt.dsc.webapi.entitites;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ItemService {

    private List<Item> list;

    public ItemService() {
        this.list = new ArrayList<>();
        this.list.add(new Item("1L","Iron Sword", 25));
        this.list.add(new Item("2L","Poison", 9));
        this.list.add(new Item("3L","Brozen shield", 35));
    }

    private boolean isExisted(String id){
       return list.stream().anyMatch(item -> item.getId().equalsIgnoreCase(id));
    }

    public List<Item> getAllItems(){
        return list;
    }

    public boolean addNewItem(Item item){
        if(isExisted(item.getId())){
            throw new IllegalArgumentException("Item with this ID is already existed!");
        }
        return this.list.add(item);
    }

    public void updateItem(Item item){
        if(!isExisted(item.getId())){
            throw new IllegalArgumentException("Item with this ID does not exist!");
        }

        int index = IntStream.range(0, list.size())
                .filter(value -> list.get(value).getId().equalsIgnoreCase(item.getId()))
                .findFirst().orElse(-1);
        if (index != -1){
            list.set(index, item);
        }else {
            throw new RuntimeException("Can not find item with given ID");
        }
    }

    public boolean deleteItem(String id){
        if(!isExisted(id)){
            throw new IllegalArgumentException("Item with this ID does not exist!");
        }
        return list.removeIf(item -> item.getId().equalsIgnoreCase(id));
    }
}
