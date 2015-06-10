package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.utils.Logging;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a list of items that can be used by the characters.
 * Created by Dunhili on 5/23/2015.
 */
public class Inventory {
    //////////////////////////////////////////////////////////////
    // FIELDS
    //////////////////////////////////////////////////////////////
    private static final String TAG = "Inventory";

    private List<Item> items;
    private int money = 0;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////

    /**
     * Adds the given item to the inventory. If the item is in the inventory, adds the item's count
     * to the count of the item in the inventory.
     * @param item item to add
     */
    public void addItem(Item item) {
        Logging.debug(TAG, "addItem(" + item.getName() + ")");
        int index = items.indexOf(item);
        if (index != -1) {
            items.get(index).addCount(item.getItemCount());
        } else {
            items.add(item);
        }
    }

    /**
     * Removes the given item from the inventory. Returns true if the item was successfully
     * removed, otherwise returns false.
     * @param item item to remove
     * @return true if the item was removed, otherwise false
     */
    public boolean removeItem(Item item) {
        Logging.debug(TAG, "removeItem(" + item.getName() + ")");
        return removeItem(item, item.getItemCount());
    }

    /**
     * Removes the given number from the item's count. If the amount to remove is greater than or
     * equal to the item count, then removes the item altogether from the list. Returns true if
     * the item was successfully removed, otherwise returns false.
     * @param item item to remove
     * @param amountToRemove amount of the item to remove from the inventory
     * @return true if the item was removed, otherwise false
     */
    public boolean removeItem(Item item, int amountToRemove) {
        Logging.debug(TAG, "removeItem(" + item.getName() + ", " + amountToRemove + ")");
        int index = items.indexOf(item);
        if (index != -1) {
            Item itemToRemove = items.get(index);
            if (amountToRemove >= itemToRemove.getItemCount()) {
                items.remove(index);
            } else {
                itemToRemove.addCount(-amountToRemove);
            }
            return true;
        }
        return false;
    }

    /**
     * Uses the given item. If it's a consumable item, then also decrements its count.
     * @param item item to use
     */
    public boolean useItem(Item item) {
        Logging.debug(TAG, "useItem(" + item.getName() + ")");
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
        Logging.debug(TAG, "getItemByIndex(" + index + ")");
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
        Logging.debug(TAG, "getItemByID(" + id + ")");
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
        Logging.debug(TAG, "getMoney()");
        return money;
    }

    /**
     * Sets the amount of money to the given value.
     * @param money money to set
     */
    public void setMoney(int money) {
        Logging.debug(TAG, "setMoney(" + money + ")");
        if (money >= 0) {
            this.money = money;
        }
    }

    public void addMoney(int moneyToAdd) {
        Logging.debug(TAG, "addMoney(" + moneyToAdd + ")");
        money += moneyToAdd;
        if (money < 0) {
            money = 0;
        }
    }

    public boolean canAffordItem(Item item) {
        return canAffordItem(item, 1);
    }

    public boolean canAffordItem(Item item, int amount) {
        return (item.getValue() * amount) <= money;
    }

    public boolean buyItem(Item item) {
        return buyItem(item, 1);
    }

    public boolean buyItem(Item item, int amount) {
        if (canAffordItem(item, amount)) {
            item.setItemCount(amount);
            addItem(item);
            money -= item.getValue() * amount;
            return true;
        }
        return false;
    }

    public boolean sellItem(Item item) {
        return sellItem(item, 1);
    }

    public boolean sellItem(Item item, int amount) {
        if (items.contains(item)) {
            int numItems = items.get(items.indexOf(item)).getItemCount();
            if (numItems < amount) {
                amount = numItems;
            }
            removeItem(item, amount);
            money += item.getValue() * amount;
            return true;
        }
        return false;
    }

    /**
     * Returns the item in the inventory that equals the given item if it's found, otherwise
     * returns null.
     * @param itemToFind item to search for in the list
     * @return item if it's found, otherwise null
     */
    public Item getItem(Item itemToFind) {
        Logging.debug(TAG, "getItem(" + itemToFind.getName() + ")");
        return getItemByID(itemToFind.getId());
    }

    /**
     * Returns a cloned list of items.
     * @return list of items
     */
    public List<Item> getItems() {
        Logging.debug(TAG, "getItems()");
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
        Logging.debug(TAG, "addItems(Num items : " + itemsToAdd.size() + ")");
        for (Item item : itemsToAdd) {
            addItem(item.clone());
        }
    }

    /**
     * Sorts the list of items by ID and returns the sorted inventory.
     * @return sorted inventory
     */
    public Inventory sortInventory() {
        Logging.debug(TAG, "sortInventory()");
        Arrays.sort(items.toArray());
        return this;
    }

    /**
     * Adds the inventory to this inventory.
     * @param inventory inventory to add
     */
    public void addInventory(Inventory inventory) {
        Logging.debug(TAG, "addInventory(Num items : " + inventory.getItems().size() + ")");
        addItems(inventory.getItems());
        addMoney(inventory.getMoney());
    }

    /**
     * Clears the inventory.
     */
    public void clear() {
        Logging.debug(TAG, "clear()");
        items.clear();
    }
}
