package com.java.basics.lowleveldesign;

import lombok.Data;

/**
 *  Theory : https://github.com/crack-interviews/grokking-the-object-oriented-design-interview-master/blob/master/object-oriented-design-case-studies/design-an-atm.md
 */
public class T_003_DesignATM {

    public enum TransactionType {
        CASH_WITHDRAWAL,
        BALANCE_CHECK;

        public static void showAllTransactionTypes(){
            for(TransactionType type: TransactionType.values()){
                System.out.println(type.name());
            }
        }
    }

    public static class UserBankAccount {
        int balance;

        public void withdrawalBalance(int amount) {
            balance = balance - amount;
        }
    }

    @Data
    public static class Card {
        private int cardNumber;
        private int cvv;
        private int expiryDate;
        private int holderName;
        private static int PIN_NUMBER = 112211;
        private UserBankAccount bankAccount;

        public boolean isCorrectPINEntered(int pin) {
            return pin == PIN_NUMBER;
        }

        public int getBankBalance(){
            return bankAccount.balance;
        }

        public void deductBankBalance(int amount){
            bankAccount.withdrawalBalance(amount);
        }
    }

    @Data
    public static class User {
        Card card;
        UserBankAccount bankAccount;
    }

    @Data
    public static class ATM {
        private static final ATM atmObject = new ATM(); //Singleton: eager initialization
        private ATMState currentATMState;
        private int atmBalance;
        private int noOfTwoThousandNotes;
        private int noOfFiveHundredNotes;
        private int noOfOneHundredNotes;

        private ATM() { }

        public static ATM getATMObject() {
            atmObject.setCurrentATMState(new IdleState());
            return atmObject;
        }

        public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes,
                                  int noOfFiveHundredNotes, int noOfOneHundredNotes) {
            this.atmBalance = atmBalance;
            this.noOfTwoThousandNotes = noOfTwoThousandNotes;
            this.noOfFiveHundredNotes = noOfFiveHundredNotes;
            this.noOfOneHundredNotes = noOfOneHundredNotes;
        }

        public void deductATMBalance(int amount) {
            atmBalance = atmBalance - amount;
        }
        public void deductTwoThousandNotes(int number) {
            noOfTwoThousandNotes = noOfTwoThousandNotes - number;
        }
        public void deductFiveHundredNotes(int number) {
            noOfFiveHundredNotes = noOfFiveHundredNotes - number;
        }
        public void deductOneHundredNotes(int number) {
            noOfOneHundredNotes = noOfOneHundredNotes - number;
        }
        public void printCurrentATMStatus(){
            System.out.println("Balance: " + atmBalance);
            System.out.println("2kNotes: " + noOfTwoThousandNotes);
            System.out.println("500Notes: " + noOfFiveHundredNotes);
            System.out.println("100Notes: " + noOfOneHundredNotes);

        }
    }

    /**
     *  State Patten for ATM state change.
     */
    public abstract static class ATMState {
        public void insertCard(ATM atm, Card card) {
            System.out.println("OOPS!! Something went wrong");
        }
        public void authenticatePin(ATM atm, Card card, int pin){
            System.out.println("OOPS!! Something went wrong");
        }
        public void selectOperation(ATM atm, Card card, TransactionType txnType){
            System.out.println("OOPS!! Something went wrong");
        }
        public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
            System.out.println("OOPS!! Something went wrong");
        }
        public void displayBalance(ATM atm, Card card){
            System.out.println("OOPS!! Something went wrong");
        }
        public void returnCard(){
            System.out.println("OOPS!! Something went wrong");
        }
        public void exit(ATM atm){
            System.out.println("OOPS!! Something went wrong");
        }
    }

    public static class IdleState extends ATMState {
        @Override
        public void insertCard(ATM atm, Card card) {
            System.out.println("Card is inserted");
            atm.setCurrentATMState(new HasCardState());
        }
    }

    public static class HasCardState extends ATMState{
        public HasCardState(){
            System.out.println("enter your card pin number");
        }
        @Override
        public void authenticatePin(ATM atm, Card card, int pin){
            boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

            if(isCorrectPinEntered) {
                atm.setCurrentATMState(new SelectOperationState());
            } else {
                System.out.println("Invalid PIN Number");
                exit(atm);
            }
        }
        @Override
        public void exit(ATM atm){
            returnCard();
            atm.setCurrentATMState(new IdleState());
            System.out.println("Exit happens");
        }
        @Override
        public void returnCard(){
            System.out.println("Please collect your card");
        }
    }

    public static class SelectOperationState extends ATMState{
        public SelectOperationState(){
            showOperations();
        }
        @Override
        public void selectOperation(ATM atmObject, Card card, TransactionType txnType){
            switch (txnType) {
                case CASH_WITHDRAWAL:
                    atmObject.setCurrentATMState(new CashWithdrawalState());
                    break;
                case BALANCE_CHECK:
                    atmObject.setCurrentATMState(new CheckBalanceState());
                    break;
                default: {
                    System.out.println("Invalid Option");
                    exit(atmObject);
                }
            }
        }
        @Override
        public void exit(ATM atmObject){
            returnCard();
            atmObject.setCurrentATMState(new IdleState());
            System.out.println("Exit happens");
        }
        @Override
        public void returnCard(){
            System.out.println("Please collect your card");
        }
        private void showOperations(){
            System.out.println("Please select the Operation");
            TransactionType.showAllTransactionTypes();
        }
    }

    public static class CheckBalanceState extends ATMState{
        public CheckBalanceState() { }
        @Override
        public void displayBalance(ATM atm, Card card){
            System.out.println("Your Balance is: " + card.getBankBalance());
            exit(atm);
        }
        @Override
        public void exit(ATM atmObject){
            returnCard();
            atmObject.setCurrentATMState(new IdleState());
            System.out.println("Exit happens");
        }
        @Override
        public void returnCard(){
            System.out.println("Please collect your card");
        }
    }

    public static class CashWithdrawalState extends ATMState {
        public CashWithdrawalState() {
            System.out.println("Please enter the Withdrawal Amount");
        }
        public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {
            if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
                System.out.println("Insufficient fund in the ATM Machine");
                exit(atmObject);
            } else if (card.getBankBalance() < withdrawalAmountRequest) {
                System.out.println("Insufficient fund in the your Bank Account");
                exit(atmObject);
            } else {
                card.deductBankBalance(withdrawalAmountRequest);
                atmObject.deductATMBalance(withdrawalAmountRequest);

                //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
                CashWithdrawProcessor withdrawProcessor =
                        new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

                withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
                exit(atmObject);
            }
        }
        @Override
        public void exit(ATM atmObject) {
            returnCard();
            atmObject.setCurrentATMState(new IdleState());
            System.out.println("Exit happens");
        }
        @Override
        public void returnCard() {
            System.out.println("Please collect your card");
        }
    }

    /**
     *  Chain of Responsibility Patter for dispensing the cash.
     */
    public abstract static class CashWithdrawProcessor {
        CashWithdrawProcessor nextCashWithdrawalProcessor;

        CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
            this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
        }

        public void withdraw(ATM atm, int remainingAmount) {
            if (nextCashWithdrawalProcessor != null) {
                nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
            }
        }
    }

    public static class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
        public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
            super(nextCashWithdrawProcessor);
        }

        public void withdraw(ATM atm, int remainingAmount){
            int required =  remainingAmount/500;
            int balance = remainingAmount%500;
            if(required <= atm.getNoOfFiveHundredNotes()) {
                atm.deductFiveHundredNotes(required);
            } else if(required > atm.getNoOfFiveHundredNotes()) {
                atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
                balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
            }

            if(balance != 0){
                super.withdraw(atm, balance);
            }
        }
    }

    public static class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
        public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
            super(nextCashWithdrawProcessor);
        }

        public void withdraw(ATM atm, int remainingAmount){
            int required =  remainingAmount/100;
            int balance = remainingAmount%100;
            if(required <= atm.getNoOfOneHundredNotes()) {
                atm.deductOneHundredNotes(required);
            } else if(required > atm.getNoOfOneHundredNotes()) {
                atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
                balance = balance + (required-atm.getNoOfOneHundredNotes()) * 100;
            }

            if(balance != 0){
                System.out.println("Something went wrong");
            }
        }
    }

    public static class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
        public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
            super(nextCashWithdrawProcessor);
        }

        public void withdraw(ATM atm, int remainingAmount) {
            int required =  remainingAmount/2000;
            int balance = remainingAmount%2000;
            if(required <= atm.getNoOfTwoThousandNotes()) {
                atm.deductTwoThousandNotes(required);
            } else if(required > atm.getNoOfTwoThousandNotes()) {
                atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
                balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
            }

            if(balance != 0){
                super.withdraw(atm, balance);
            }
        }
    }

    public static class ATMRoom {
        ATM atm;
        User user;

        public void initialize() {
            //create ATM
            atm = ATM.getATMObject();
            atm.setAtmBalance(3500, 1,2,5);
            //create User
            this.user = createUser();
        }
        private User createUser(){
            User user = new User();
            user.setCard(createCard());
            return user;
        }
        private Card createCard(){
            Card card = new Card();
            card.setBankAccount(createBankAccount());
            return card;
        }
        private UserBankAccount createBankAccount() {
            UserBankAccount bankAccount = new UserBankAccount();
            bankAccount.balance = 3000;
            return bankAccount;
        }
    }

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
    }
}
