package com.java.basics.lowleveldesign;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 *  Requirements:
 *  -   We put money in the machine and select items to dispense.
 *
 *  Operations with states:
 *  1.  IdleState :
 *      -   Press Insert Cash Button
 *  2.  HasMoneyState :
 *      -   Insert Coin
 *      -   Select Item Button
 *      -   Cancel/Refund
 *  3.  SelectionState :
 *      -   Choose Item
 *      -   Cancel/Refund
 *      -   Return Change
 *  4.  DispenseState :
 *      -   Dispense Item
 *
 *
 *  Reference Video : https://www.youtube.com/watch?v=wOXs5Z_z0Ew&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=19
 */
public class T_002_DesignVendingMachine {

    public enum ItemType {
        COKE,
        PEPSI,
        JUICE,
        SODA
    }

    public enum Coin {
        PENNY(1),
        NICKEL(5),
        DIME(10),
        QUARTER(25);

        public int value;

        Coin(int value) {
            this.value = value;
        }
    }

    @Data
    public static class Item {
        ItemType type;
        int price;
    }

    @Data
    public static class ItemShelf {
        int code;
        Item item;
        boolean soldOut;
    }

    @Data
    public static class Inventory {
        ItemShelf[] itemShelves;

        public Inventory(int size) {
            itemShelves = new ItemShelf[size];
            initialEmptyInventory();
        }

        private void initialEmptyInventory() {
            int startCode = 101;
            for (int i = 0; i < itemShelves.length; i++) {
                ItemShelf space = new ItemShelf();
                space.setCode(startCode++);
                space.setSoldOut(true);
                itemShelves[i] = space;
            }
        }

        public void addItem(int code, Item item) throws Exception {
            for (ItemShelf shelfItem : itemShelves) {
                if (shelfItem.code == code) {
                    if (shelfItem.isSoldOut()) {
                        shelfItem.setItem(item);
                        shelfItem.setSoldOut(false);
                    } else {
                        throw new Exception("Item is already present, you can't add more");
                    }
                }
            }
        }

        public Item getItem(int code) throws Exception {
            for (ItemShelf shelfItem : itemShelves) {
                if (shelfItem.code == code) {
                    if (!shelfItem.isSoldOut()) {
                        return shelfItem.getItem();
                    } else {
                        throw new Exception("Item is already sold out");
                    }
                }
            }
            throw new Exception("Invalid Code");
        }

        public void updateSoldOutItem(int code) {
            for (ItemShelf shelfItem : itemShelves) {
                if (shelfItem.code == code) {
                    shelfItem.setSoldOut(true);
                }
            }
        }
    }

    public interface State {
        void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
        void insertCoin(VendingMachine machine , Coin coin) throws Exception;
        void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
        void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
        Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;
        void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
        int getChange(int returnChangeMoney) throws Exception;
        List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    }

    public static class IdleState implements State {
        public IdleState(){
            System.out.println("Currently Vending Machine is in IdleState");
        }

        public IdleState(VendingMachine machine){
            System.out.println("Currently Vending machine is in IdleState");
            machine.setCoinList(new ArrayList<>());
        }

        @Override
        public void clickOnInsertCoinButton(VendingMachine machine) {
            machine.setVendingMachineState(new HasMoneyState());
        }
        @Override
        public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
            throw new Exception("you can not insert Coin in idle state");
        }
        @Override
        public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
            throw new Exception("first you need to click on insert coin button");
        }
        @Override
        public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
            throw new Exception("you can not choose Product in idle state");
        }
        @Override
        public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
            throw new Exception("product can not be dispensed idle state");
        }
        @Override
        public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
            machine.getInventory().addItem(codeNumber, item);
        }
        @Override
        public int getChange(int returnChangeMoney) throws Exception {
            throw new Exception("you can not get change in idle state");
        }
        @Override
        public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
            throw new Exception("you can not get refunded in idle state");
        }
    }

    public static class HasMoneyState implements State {
        public HasMoneyState(){
            System.out.println("Currently Vending Machine is in HasMoneyState");
        }

        @Override
        public void clickOnInsertCoinButton(VendingMachine machine) { }
        @Override
        public void insertCoin(VendingMachine machine, Coin coin) {
            System.out.println("Accepted the coin");
            machine.getCoinList().add(coin);
        }
        @Override
        public void clickOnStartProductSelectionButton(VendingMachine machine) {
            machine.setVendingMachineState(new SelectionState());
        }
        @Override
        public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
            throw new Exception("you need to click on start product selection button first");
        }
        @Override
        public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
            throw new Exception("product can not be dispensed HasMoney state");
        }
        @Override
        public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
            throw new Exception("you can not update inventory in HasMoney  state");
        }
        @Override
        public int getChange(int returnChangeMoney) throws Exception {
            throw new Exception("you can not get change in HasMoney state");
        }
        @Override
        public List<Coin> refundFullMoney(VendingMachine machine) {
            System.out.println("Returned the full amount back in the Coin Dispense Tray");
            machine.setVendingMachineState(new IdleState(machine));
            return machine.getCoinList();
        }
    }

    public static class SelectionState implements State {
        public SelectionState(){
            System.out.println("Currently Vending Machine is in HasMoneyState");
        }

        @Override
        public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
            throw new Exception("you can not click on insert coin button in Selection state");
        }
        @Override
        public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
            throw new Exception("you can not insert Coin in selection state");
        }
        @Override
        public void clickOnStartProductSelectionButton(VendingMachine machine) { }
        @Override
        public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
            //1. get item of this codeNumber
            Item item = machine.getInventory().getItem(codeNumber);
            //2. total amount paid by User
            int paidByUser = 0;
            for(Coin coin: machine.getCoinList()){
                paidByUser += coin.value;
            }
            //3. compare product price and amount paid by user
            if(paidByUser < item.getPrice()){
                System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
                refundFullMoney(machine);
                throw new Exception("insufficient amount");
            } else {
                if(paidByUser > item.getPrice()) {
                    getChange(paidByUser-item.getPrice());
                }
                machine.setVendingMachineState(new DispenseState(machine, codeNumber));
            }
        }
        @Override
        public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
            throw new Exception("product can not be dispensed Selection state");
        }
        @Override
        public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
            throw new Exception("Inventory can not be updated in Selection state");
        }
        @Override
        public int getChange(int returnChangeMoney) {
            System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
            return returnChangeMoney;
        }
        @Override
        public List<Coin> refundFullMoney(VendingMachine machine) {
            System.out.println("Returned the full amount back in the Coin Dispense Tray");
            machine.setVendingMachineState(new IdleState(machine));
            return machine.getCoinList();
        }
    }

    public static class DispenseState implements State {
        DispenseState(VendingMachine machine, int codeNumber) throws Exception{
            System.out.println("Currently Vending machine is in DispenseState");
            dispenseProduct(machine, codeNumber);
        }

        @Override
        public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
            throw new Exception("insert coin button can not clicked on Dispense state");
        }
        @Override
        public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
            throw new Exception("product selection buttion can not be clicked in Dispense state");
        }
        @Override
        public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
            throw new Exception("coin can not be inserted in Dispense state");
        }
        @Override
        public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception{
            throw new Exception("product can not be choosen in Dispense state");
        }
        @Override
        public int getChange(int returnChangeMoney) throws Exception{
            throw new Exception("change can not returned in Dispense state");
        }
        @Override
        public List<Coin> refundFullMoney(VendingMachine machine) throws Exception{
            throw new Exception("refund can not be happen in Dispense state");
        }
        @Override
        public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
            System.out.println("Product has been dispensed");
            Item item = machine.getInventory().getItem(codeNumber);
            machine.getInventory().updateSoldOutItem(codeNumber);
            machine.setVendingMachineState(new IdleState(machine));
            return item;
        }
        @Override
        public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
            throw new Exception("inventory can not be updated in Dispense state");
        }
    }

    @Data
    public static class VendingMachine {
        private State vendingMachineState;
        private Inventory inventory;
        private List<Coin> coinList;

        public VendingMachine() {
            vendingMachineState = new IdleState();
            inventory = new Inventory(10);
            coinList = new ArrayList<>();
        }

        public void fillUpInventory(VendingMachine vendingMachine){
            ItemShelf[] slots = vendingMachine.getInventory().getItemShelves();
            for (int i = 0; i < slots.length; i++) {
                Item newItem = new Item();
                if(i<3) {
                    newItem.setType(ItemType.COKE);
                    newItem.setPrice(12);
                }else if(i<5){
                    newItem.setType(ItemType.PEPSI);
                    newItem.setPrice(9);
                }else if(i<7){
                    newItem.setType(ItemType.JUICE);
                    newItem.setPrice(13);
                }else if(i<10){
                    newItem.setType(ItemType.SODA);
                    newItem.setPrice(7);
                }
                slots[i].setItem(newItem);
                slots[i].setSoldOut(false);
            }
        }

        public void displayInventory(VendingMachine vendingMachine){
            ItemShelf[] slots = vendingMachine.getInventory().getItemShelves();
            for (ItemShelf slot : slots) {
                System.out.println("CodeNumber: " + slot.getCode() +
                        " Item: " + slot.getItem().getType().name() +
                        " Price: " + slot.getItem().getPrice() +
                        " isAvailable: " + !slot.isSoldOut());
            }
        }
    }

    public static void main(String[] args){

        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            vendingMachine.fillUpInventory(vendingMachine);
            vendingMachine.displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            vendingState.insertCoin(vendingMachine, Coin.PENNY);
            vendingState.insertCoin(vendingMachine, Coin.DIME);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            vendingMachine.displayInventory(vendingMachine);
        }
        catch (Exception e){
            vendingMachine.displayInventory(vendingMachine);
        }
    }
}