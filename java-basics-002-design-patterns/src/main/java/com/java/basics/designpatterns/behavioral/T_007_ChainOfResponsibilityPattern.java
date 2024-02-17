package com.java.basics.designpatterns.behavioral;

import java.util.Scanner;

/*
 * 	->	Avoid coupling the sender of a request to its receiver by giving more than one
 * 		object a chance to handle the request. Chain the receiving objects and pass the
 * 		request along the chain until an object handles it.
 *
 * 	When to use:
 * 	-----------
 * 	1.	When a request needs to be processed by multiple processors.
 * 	2.	To achieve loose coupling between sender and receivers.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Client doesn't need to know about all the processors. It sends the request to
 * 		the first processor in the chain.
 * 	2.	Unlike the decorator pattern, the chain can be broken at any point to prevent other
 * 		processors from handling the request.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Since there is no explicit handler/receiver for the request, there is a possibility
 * 		that the request remains unprocessed.
 * 	2.	Incorrectly configured chain may cause some requests to be skipped.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Escalation Matrix
 * 	2.	Reimbursement Approval Hierarchy.
 *
 * 	Software Examples:
 * 	-----------------
 * 	1.	Windows Event handlers - Events are propagated until it gets processed.
 * 	2.	Exception Handling - Exceptions are re-thrown if the handler is incapable of handling it.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.util.logging.Logger log()
 * 	2.	javax.servlet.Filter doFilter()
 */
public class T_007_ChainOfResponsibilityPattern {
	/*
	 *	Create a Cash Dispenser class that will take the denomination as the constructor argument.
	 *	This class has a reference to the next Cash Dispenser.
	 */
	public static class CashDispenser {
		protected int denominator;
		protected CashDispenser next = null;

		public CashDispenser(int value) {
			this.denominator = value;
		}

		public void setNextDispenser(CashDispenser d) {
			if (next == null)
				next = d;
			else
				next.setNextDispenser(d);
		}
		
		public void dispense(int amount) {
			if (amount >= denominator) {
				int num = amount / denominator;
				int balance = amount % denominator;
				System.out.println(num + " * " + denominator + "$");
				if (balance != 0 && next != null) {
					next.dispense(balance);
				}
			} else if (next != null) {
				next.dispense(amount);
			}
		}
	}

	/*
	 * Client Code - Client creates dispensers for various denominations and chain them
	 * to form a linked list. The client just launches the dispense activity only once and
	 * the request is passed through the chain automatically (until it gets processed).
	 */
	public static class ChainClient {
		
		public static void main(String[] args) {
			CashDispenser dispenser = new CashDispenser(100);
			dispenser.setNextDispenser(new CashDispenser(50));
			dispenser.setNextDispenser(new CashDispenser(20));
			dispenser.setNextDispenser(new CashDispenser(10));
			dispenser.setNextDispenser(new CashDispenser(5));
			dispenser.setNextDispenser(new CashDispenser(1));

			int amount = 0;
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the amount to withdraw : ");
			amount = in.nextInt();

			dispenser.dispense(amount);
			in.close();
		}
	}
}
