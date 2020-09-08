package com.java.basics.designpatterns.creational;

/*
 * 	->	Specify the kinds of objects to create using a prototypical instance, and create new
 * 		objects by copying this prototype.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To improve performance when object creation is costly and time consuming.
 * 	2.	To simplify and optimize multiple objects creation that will have mostly the same data.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Performance: Cloning is considerable less expensive then creating a new object afresh.
 * 	2.	Objects can be clones very dynamically, without any insistence on up-front instantiation.
 * 		The first created object can be created at any time in the application execution, and
 * 		further duplication can take place at any time ahead.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Deep copy has to be handled carefully.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Biological cell splitting.
 *
 * 	Software Example
 * 	----------------
 * 	1.	Virtual machine images - Have one image per OS which has all the required s/w installed.
 * 	2.	DVD duplication - Duplication of the master DVD to create several copies.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.lang.Obejct clone()
 */
public class T_004_PrototypePattern {
	/*
	 * Create a base machine image by installing the specifies OD and anti-virus software. Provides
	 * a "clone" method so that client can create an object without using time consuming "new"
	 * operator every time.
	 */
	public static class MachineImage implements Cloneable {
		
		StringBuilder image;
		
		public MachineImage(String os, String antivirus) {
			image = new StringBuilder();
			image.append(os).append(" + " + antivirus);
		}

		private MachineImage(String sw) {
			image = new StringBuilder(sw);
		}
		
		public void install(String sw) {
			image.append(sw);
		}

		public void printSw() {
			System.out.println(image);
		}

		@Override
		protected MachineImage clone() throws CloneNotSupportedException {
			return new MachineImage(this.image.toString());
		}
	}

	/*
	 * Client Code - Client creates a base image and clones it to create the images.
	 */
	public static class PrototypeClient {
		
		public static void main(String[] args) throws CloneNotSupportedException {
			MachineImage linuxVM = new MachineImage("Linux", "Symantic");
			MachineImage windowsVM = new MachineImage("Windows", "McFee");

			MachineImage webServer = linuxVM.clone();
			webServer.install(" + Web Server S/W");

			MachineImage webAppServer = webServer.clone();
			webAppServer.install(" App Server S/W");

			MachineImage dbServer = linuxVM.clone();
			dbServer.install(" + Database Server S/W");
			
			MachineImage testMachine = windowsVM.clone();
			
			System.out.print("Web Server Configuration :: ");
			webServer.printSw();
			System.out.print("App Server Configuration :: ");
			webAppServer.printSw();
			System.out.print("DB Server Configuration :: ");
			dbServer.printSw();
			System.out.print("Test Machine Configuration :: ");
			testMachine.printSw();
		}
	}
}
