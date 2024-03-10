package com.java.basics.designpatterns.behavioral;

import lombok.Data;

/*
 * 	->	Allow an object to alter its behavior when its internal state changes. The object will
 * 		appear to change its class.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To encapsulate varying behavior for the same object based on its internal state.
 * 	2.	To have the ability to change the behavior at run time.
 *
 * 	Benefits:
 * 	--------
 * 	1.	New States can be added easily as the state specific behavior is encapsulated in that
 * 		state class.
 * 	2.	Avoids too many conditional statements.
 * 	3.	State class aggregates the state specific behavior which results in increased cohesion.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Electro-mechanical machines(ATM machine, Gear box, Microwave oven) which can have many stetes.
 *
 * 	Software Example
 * 	----------------
 * 	1.	FSM - Finite State Machine
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	javax.faces.lifecycle.LifeCycle execute() (controlled by FacesServlet, the bahavior is
 * 		dependent on current phase of JSF life cycle.
 */
public class T_006_StatePattern {
	
	/*
	 * Define a State abstract base class and represent the different "states" of the state machine
	 * as derived classes of the State base class. Define state-specific behavior in appropriate
	 * State derived classes.
	 */
	public interface AtmState {
		void withdraw(int amount);
		void refill(int amount);
	}

	public static class Working implements AtmState {
		
		Atm atm;
		
		public Working(Atm atm) {
			this.atm = atm;
		}
		
		@Override
		public void withdraw(int amount) {
			int cashStock = atm.getCashStock();
			if (amount > cashStock) {
				amount = cashStock;
				System.out.print("Partial Amount ");
			}
			System.out.println(amount + "$ is dispensed");
			int newStock = cashStock - amount;
			atm.setCashStock(newStock);
			if (newStock == 0)
				atm.setCurrentState(new NoCash(atm));
		}
		
		@Override
		public void refill(int amount) {
			System.out.println(amount + "$ is loaded");
			atm.setCashStock(atm.getCashStock() + amount);
		}
	}
	
	public static class NoCash implements AtmState {
		
		Atm atm;
		
		public NoCash(Atm atm) {
			this.atm = atm;
		}
		
		@Override
		public void withdraw(int amount) {
			System.out.println("Out of cash");
		}
		
		@Override
		public void refill(int amount) {
			System.out.println(amount + "$ is loaded");
			atm.setCurrentState(new Working(atm));
			atm.setCashStock(atm.getCashStock() + amount);
		}
	}

	/*
	 * Define a "context" class to present a single interface to the outside world. Maintain a
	 * pointer to the current "state" in the "context" class. To change the state of the state
	 * machine, change the current "state" pointer.
	 */
	@Data
	public static class Atm {

		int cashStock;
		AtmState currentState;

		public Atm() {
			currentState = new NoCash(this);
		}
		
		public void withdraw(int amount) {
			currentState.withdraw(amount);
		}
		
		public void refill(int amount) {
			currentState.refill(amount);
		}
	}
	
	/*
	 * Client code - client interacts with the context.
	 */
	public static class StateClient {

		public static void main(String[] args) {
			Atm atm = new Atm();
			atm.refill(100);
			atm.withdraw(50);
			atm.withdraw(30);
			atm.withdraw(30);
			atm.withdraw(30);
			atm.refill(50);
			atm.withdraw(50);
		}
	}
}
