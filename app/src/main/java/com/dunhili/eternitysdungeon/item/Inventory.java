package com.dunhili.eternitysdungeon.item;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a list of items that can be used by the characters.
 * Created by Dunhili on 5/23/2015.
 */
public class Inventory {
    private List<Item> items;
    private int money = 0;

    /**
     * Default constructor, creates an inventory of default size.
     */
    public Inventory() {
        this(10);
    }

    /**
     * Comprehensive constructor, creates an inventory of the give size.
     */
    public Inventory(int initialCapacity) {
        items = new ArrayList<>(initialCapacity);
    }

    /**
     * Creates an inventory with the given list of items.
     * @param items list of items to add to the inventory
     */
    public Inventory(List<Item> items) {
        addItems(items);
    }

    /**
     * Adds the given item to the inventory. If the item is in the inventory, adds the item's count
     * to the count of the item in the inventory.
     * @param item item to add
     */
    public void addItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            items.get(index).addCount(item.getItemCount());
        } else {
            items.add(item);
        }
    }

    /**
     * Removes the given item from the inventory.
     * @param item item to remove
     */
    public boolean removeItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Uses the given item. If it's a consumable item, then also decrements its count.
     * @param item item to use
     */
    public boolean useItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            Item itemToUse = items.get(index);
            itemToUse.use();
            if (itemToUse.isConsumable()) {
                itemToUse.decreaseCount();
                if (itemToUse.getItemCount() == 0) {
                    items.remove(index);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the item at the given index if it's found, otherwise returns null.
     * @param index index to return the item at
     * @return item if it's found, or null if not found
     */
    public Item getItemByIndex(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.get(index);
    }

    /**
     * Returns the item that matches the given ID if it's in the inventory, otherwise returns null.
     * @param id ID to search for
     * @return item that matches the ID if it's in the inventory, otherwise null
     */
    public Item getItemByID(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    /**
     * Returns the amount of money in the inventory.
     * @return amount of money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money to the given value.
     * @param money money to set
     */
    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    /**
     * Returns the item in the inventory that equals the given item if it's found, otherwise
     * returns null.
     * @param itemToFind item to search for in the list
     * @return item if it's found, otherwise null
     */
    public Item getItem(Item itemToFind) {
        return getItemByID(itemToFind.getId());
    }

    /**
     * Returns a cloned list of items.
     * @return list of items
     */
    public List<Item> getItems() {
        List<Item> clonedItems = new ArrayList<>();
        for (Item item : items) {
            clonedItems.add(item.clone());
        }
        return clonedItems;
    }

    /**
     * Adds the list of items to the inventory.
     * @param itemsToAdd items to add to the inventory
     */
    public void addItems(List<Item> itemsToAdd) {
        for (Item item : itemsToAdd) {
            addItem(item.clone());
        }
    }

    /**
     * Adds the inventory to this inventory.
     * @param inventory inventory to add
     */
    public void addInventory(Inventory inventory) {
        addItems(inventory.getItems());
    }

    /**
     * Clears the inventory.
     */
    public void clear() {
        items.clear();
    }
}
