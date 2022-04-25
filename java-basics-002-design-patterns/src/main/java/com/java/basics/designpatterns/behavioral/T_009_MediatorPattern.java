package com.java.basics.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * 	->	Define an object that encapsulates how a set of objects interact. Mediator promotes loose
 * 		coupling by keeping objects from referring to each other explicitly, and it lets you
 * 		vary their interaction independently.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To facilitate interactions between a set of objects where the communications are complex
 * 		and hard to maintain.
 * 	2.	To have a centralized control for the object interactions.
 *
 * 	Benefits:
 * 	--------
 * 	1.	A mediator promotes loose coupling between colleagues.
 * 	2.	Promotes one-to-many relationships that are easier to understand, implement and maintain
 * 		than many-to-many relationships.
 * 	3.	A mediator simplifies the communication and provides a centralized control.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	A mediator class may become complex if not designed carefully.
 * 	2.	All communications are routed by the Mediator which may impact the performance.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Air Traffic Controller
 * 	2.	Head Speaker of the Parliament - members do not communicate with each other.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.util.Timer (all scheduleXXX() methods)
 * 	2.	java.util.concurrent.Executor execute()
 * 	3.	java.util.concurrent.ExecuterService (the invokeXXX() and submit() methods)
 * 	4.	java.lang.reflect.Method invoke()
 */
public class T_009_MediatorPattern {
	/*
	 * Create an interface that defines the communication rules between objects.
	 */
	public static interface AtcMediator {
		public void registerRunway(Runway runway);
		public void registerGate(Gate gate);
		public boolean getLandingPermission(Flight flight);
		public boolean getTakeOfPermission(Flight flight);
		public void enterRunway(Runway runway);
		public void exitRunway(Runway runway);
		public void enterGate(Gate gate);
		public void exitGate(Gate gate);
	}
	
	/*
	 * Create a mediator object which will enable communication b/w participating objects.
	 */
	public static class AtcMediatorImpl implements AtcMediator {

		private Runway runway;
		private final List<Gate> gates;

		public AtcMediatorImpl() {
			gates = new ArrayList<>();
		}
		
		@Override
		public void registerRunway(Runway runway) {
			this.runway = runway;
		}
		
		@Override
		public void registerGate(Gate gate) {
			gates.add(gate);
		}
		
		@Override
		public boolean getLandingPermission(Flight flight) {
			if (!runway.isInUse()) {
				for (Gate gate : gates) {
					if (!gate.isInUse()) {
						flight.allocateRunway(runway);
						flight.allocateGate(gate);
						return true;
					}
				}
				System.out.println("[ATC Mediator] All gates in use");
			}
			else {
				System.out.println("[ATC Mediator] Runway in use");
			}
			return false;
		}
		
		@Override
		public boolean getTakeOfPermission(Flight flight) {
			return !runway.isInUse();
		}
		
		@Override
		public void enterRunway(Runway runway) {
			runway.setInUse(true);
		}
		
		@Override
		public void exitRunway(Runway runway) {
			runway.setInUse(false);
		}
		
		@Override
		public void enterGate(Gate gate) {
			gate.setInUse(true);
		}
		
		@Override
		public void exitGate(Gate gate) {
			gate.setInUse(false);
		}

	}

	/*
	 * Define Colleagues. Colleagues keep a reference to its mediator object.
	 */
	public static class Flight {
		private final AtcMediator atc;
		private final String flightNum;
		private Runway runway;
		private Gate gate;

		public Flight(AtcMediator atc, String flightNum) {
			this.atc = atc;
			this.flightNum = flightNum;
		}
		
		public String getName() {
			return flightNum;
		}
		
		public Runway getRunway() {
			return runway;
		}
		
		public void allocateRunway(Runway runway) {
			this.runway = runway;
		}
		
		public Gate getGate() {
			return gate;
		}
		
		public void allocateGate(Gate gate) {
			this.gate = gate;
		}
		
		public void land() {
			atc.enterRunway(runway);
			System.out.println(this.flightNum + " is landing, gate is " + gate.getGateNum());
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					atc.exitRunway(runway);
					atc.enterGate(gate);
				}
			}, 1000);
		}

		public void takeOff() {
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					System.out.println(flightNum + " is taking off");
					atc.exitGate(gate);
					atc.enterRunway(runway);

					new java.util.Timer().schedule(new java.util.TimerTask() {
						@Override
						public void run() {
							atc.exitRunway(runway);
						}
					}, 1000);
				}
			}, 5000);
		}
		
		public void landAndTakeOff() throws InterruptedException {
			System.out.println(flightNum + " is requesting landing permission");
			while (!atc.getLandingPermission(this)) {
				Thread.sleep(1000);
			}
			land();
			while (!atc.getTakeOfPermission(this)) {
				Thread.sleep(1000);
			}
			takeOff();
		}
	}
	
	public static class Runway {
		private String runwayNum;
		private boolean inUse;

		public Runway(String runwayNum, boolean inUse) {
			this.runwayNum = runwayNum;
			this.inUse = inUse;
		}
		
		public String getRunwayNum() {
			return runwayNum;
		}
		
		public void setRunwayNum(String runwayNum) {
			this.runwayNum = runwayNum;
		}
		
		public boolean isInUse() {
			return inUse;
		}
		
		public void setInUse(boolean inUse) {
			this.inUse = inUse;
		}
	}

	public static class Gate {
		private final String gateNum;
		private boolean inUse;
		
		public Gate(String gateNum, boolean inUse) {
			this.gateNum = gateNum;
			this.inUse = inUse;
		}
		
		public String getGateNum() {
			return gateNum;
		}
		
		public boolean isInUse() {
			return inUse;
		}

		public void setInUse(boolean inUse) {
			this.inUse = inUse;
		}
	}

	/*
	 * Client code - Client creates mediator and all the colleagues register with the mediator.
	 * When the objects want to interact with other objects, it uses the mediator.
	 */
	public static class MediatorClient {
		
		public static void main(String[] args) throws InterruptedException {
			AtcMediator atcMediator = new AtcMediatorImpl();
			atcMediator.registerRunway(new Runway("RW-1", false));
			atcMediator.registerGate(new Gate("G-1", false));
			atcMediator.registerGate(new Gate("G-2", false));
			atcMediator.registerGate(new Gate("G-3", false));

			for (int i = 0; i < 10; i++) {
				Flight flight = new Flight(atcMediator, "F-00" + (i + 1));
				flight.landAndTakeOff();
			}
		}
	}
}
