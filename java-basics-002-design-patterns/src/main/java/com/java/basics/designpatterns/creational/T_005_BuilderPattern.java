package com.java.basics.designpatterns.creational;

/*
 * 	->	Separate the construction of a complex object from its representation so that the same
 * 		construction process can create different representation.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To avoid dealing with inconsistent object when the object needs to be created over
 * 		several steps.
 * 	2.	To avoid too many constructor arguments.
 * 	3.	To construct an object that should be immutable.
 * 	4.	To encapsulate the complete creation logic.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Construction process can be controlled by the director.
 * 	2.	Useful when many operations have to be done to build an object.
 * 	3.	Avoids Telescoping Constructor Pattern.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Not suitable if a mutable object is required.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Building a house - We need to tell the architect what all we want as part of building.
 * 		The architect then designs and constructs the building. It will be handed over only when
 * 		everything is implemented. We don't get a partial build house(which is unsafe).
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.lang.StringBuilder append()
 * 	2.	java.lang.StringBuffer append()
 */
public class T_005_BuilderPattern {
	/*
	 * Define the Product(House) that gets assembled in the Builder pattern.
	 */
	public static class House {
		public String floorType;
		public String wallType;
		public String roofType;
		
		public void setFloorType(String floorType) {
			this.floorType = floorType;
		}
		public void setWallType(String wallType) {
			this.wallType = wallType;
		}
		public void setRoofType(String roofType) {
			this.roofType = roofType;
		}
		
		@Override
		public String toString() {
			return "Constructing House... \nFloorType : " + floorType + "\nWallType : " + wallType + "\nRoofType : " + roofType;
		}
	}

	/*
	 * Define the builder interface along with concrete builders. The Builder interface contains
	 * methods for the step by step construction of the product. It also has a build method for
	 * retrieving the product object.
	 */
	public interface HouseBuilder {
		HouseBuilder buildFloor();
		HouseBuilder buildWall();
		HouseBuilder buildRoof();
		House build();
	}

	/*
	 * Concrete builders implement the builder interface
	 */
	public static class ConcreteBuilder implements HouseBuilder {
		
		private final House house;
		
		public ConcreteBuilder() {
			house = new House();
		}

		@Override
		public HouseBuilder buildFloor() {
			house.setFloorType("concrete");
			return this;
		}

		@Override
		public HouseBuilder buildWall() {
			house.setWallType("concrete");
			return this;
		}

		@Override
		public HouseBuilder buildRoof() {
			house.setRoofType("concrete");
			return this;
		}

		@Override
		public House build() {
			return house;
		}
	}

	public static class WoodenHouseBuilder implements HouseBuilder {
		
		private final House house;
		
		public WoodenHouseBuilder() {
			house = new House();
		}

		@Override
		public HouseBuilder buildFloor() {
			house.setFloorType("wood");
			return this;
		}

		@Override
		public HouseBuilder buildWall() {
			house.setWallType("wood");
			return this;
		}

		@Override
		public HouseBuilder buildRoof() {
			house.setRoofType("wood");
			return this;
		}

		@Override
		public House build() {
			return house;
		}
	}
	
	/*
	 * A Director object is responsible for constructing a Product. It does this via the
	 * Builder interface to a concrete builder. It constructs a Product via the various
	 * Builder methods. The director class ensures that all the required operations are
	 * performed before the object is returned to the client in 'consistent' state.
	 */
	public static class HouseBuilderDirector {
		private final HouseBuilder builder;
		
		public HouseBuilderDirector(HouseBuilder builder) {
			this.builder = builder;
		}
		
		public House construct() {
			return builder.buildFloor().buildWall().buildRoof().build();
		}
	}

	/*
	 * Client code
	 */
	public static class BuilderPattern {

		public static void main(String[] args) {
			HouseBuilder builder = new ConcreteBuilder();
			HouseBuilderDirector houseBuilderDirector = new HouseBuilderDirector(builder);
			System.out.println(houseBuilderDirector.construct());
			
			builder = new WoodenHouseBuilder();
			houseBuilderDirector = new HouseBuilderDirector(builder);
			System.out.println(houseBuilderDirector.construct());
		}
	}
}
