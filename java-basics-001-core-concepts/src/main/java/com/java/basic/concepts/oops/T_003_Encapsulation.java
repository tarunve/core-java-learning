package com.java.basic.concepts.oops;

/*
    Process of binding data and corresponding methods into a single unit.

    Advantages :
        1. Security
        2. Enhancement will become easy.
        3. Improves maintainability of application.

    Can be achieved by :
        By declaring all variables as private. We don't need to check if class have getter & setters
        and if these are public or not.
 */
public class T_003_Encapsulation {
	
	private double balance;
	
	public double getBalance() {
		return balance;
	}
}