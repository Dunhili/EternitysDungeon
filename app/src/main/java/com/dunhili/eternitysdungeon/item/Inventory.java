package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.map.Tile;
import com.dunhili.eternitysdungeon.utils.Logging;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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

    private HashMap<Item, Integer> items;
    private int money = 0;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

    /**
     * Default constructor, creates an inventory of default size.
     */
    public Inventory() {
        items = new HashMap<>();
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
     * Adds 1 count of the given item to the inventory.
     * @param item item to add
     * @return true if the item was successfully added, otherwise false
     */
    public boolean addItem(Item item) {
        return addItem(item, 1);
    }

    /**
     * Adds the count of given item to the inventory.
     * @param item item to add
     * @return true if the item was successfully added, otherwise false
     */
    public boolean addItem(Item item, int amount) {
        Logging.debug(TAG, "addItem(" + item.getName() + ", " + amount + ")");
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + amount);
        } else {
            items.put(item, amount);
        }
        return true;
    }

    /**
     * Removes the given item from the inventory. Returns true if the item was successfully
     * removed, otherwise returns false.
     * @param item item to remove
     * @return true if the item was removed, otherwise false
     */
    public boolean removeItem(Item item) {
        Logging.debug(TAG, "removeItem(" + item.getName() + ")");
        if (items.containsKey(item)) {
            items.remove(item);
            return true;
        }
        return false;
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
        if (items.containsKey(item)) {
            int itemCount = items.get(item);
            if (amountToRemove >= itemCount) {
                items.remove(item);
            } else {
                items.put(item, items.get(item) - amountToRemove);
            }
            return true;
        }
        return false;
    }

    /**
     * Uses the given item. If it's a consumable item, then also decrements its count. Returns
     * true if the item was successfully used, otherwise returns false.
     * @param item item to use
     * @return true if the item was used, otherwise false
     */
    public boolean useItem(Item item) {
        Logging.debug(TAG, "useItem(" + item.getName() + ")");
        if (items.containsKey(item)) {
            item.use();
            if (item.isConsumable()) {
                removeItem(item, 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Uses the given item on the target character. If it's a consumable item, then also decrements
     * its count. Returns true if the item was successfully used, otherwise returns false.
     * @param item item to use
     * @param target target character to use the item on
     * @return true if the item was used, otherwise false
     */
    public boolean useItem(Item item, com.dunhili.eternitysdungeon.character.Character target) {
        Logging.debug(TAG, "useItem(" + item.getName() + ", " + target + ")");
        if (items.containsKey(item)) {
            item.use(target);
            if (item.isConsumable()) {
                removeItem(item, 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Uses the given item on the target area. If it's a consumable item, then also decrements its
     * count. Returns true if the item was successfully used, otherwise returns false.
     * @param item item to use
     * @param targetArea target area to use the item on
     * @return true if the item was used, otherwise false
     */
    public boolean useItem(Item item, Tile targetArea) {
        Logging.debug(TAG, "useItem(" + item.getName() + ", " + targetArea + ")");
        if (items.containsKey(item)) {
            item.use(targetArea);
            if (item.isConsumable()) {
                removeItem(item, 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the number of a given item if it's in the inventory, otherwise returns 0.
     * @param item item to get the count of
     * @return number of a given item or 0
     */
    public int getItemCount(Item item) {
        Logging.debug(TAG, "getItemCount(" + item.getName() + ")");
        return items.containsKey(item) ? items.get(item) : 0;
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
            addItem(item, amount);
            money -= item.getValue() * amount;
            return true;
        }
        return false;
    }

    public boolean sellItem(Item item) {
        return sellItem(item, 1);
    }

    public boolean sellItem(Item item, int amount) {
        if (items.containsKey(item) && items.get(item) >= amount) {
            removeItem(item, amount);
            money += item.getValue() * amount;
            return true;
        }
        return false;
    }


    /**
     * Returns a cloned list of items.
     * @return list of items
     */
    public List<Item> getItems() {
        Logging.debug(TAG, "getItems()");
        return new ArrayList<>(items.keySet());
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
    public List<Item> getSortedInventory() {
        Logging.debug(TAG, "sortInventory()");
        List<Item> itemsToSort = getItems();
        Collections.sort(itemsToSort);
        return itemsToSort;
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
