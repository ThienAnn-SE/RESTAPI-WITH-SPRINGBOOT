package com.fpt.dsc.webapi.services;

import com.fpt.dsc.webapi.entitites.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    /**
     * Get all the available items in the list.
     * @return List of items.
     */
    List<Item> getAllItems();

    /**
     * Add new item to the list.
     * @param item Item to be inserted.
     * @return True if the item is inserted to the list successfully.
     *         Otherwise, return false if the item is existed.
     */
    boolean addNewItem(Item item);

    /**
     * Update the existed item in the list.
     * @param item Item to be updated.
     */
    void updateItem(Item item);

    /**
     * Delete the existed item in the list.
     * @param id ID of the delete item.
     * @return True if item is delete successfully.
     *          Otherwise, return false if the item does not exist.
     */
    boolean deleteItem(String id);
}
