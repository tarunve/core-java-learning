package com.java.basics.designpatterns.behavioral;

import java.util.ArrayList;

/*
 * 	->	Without violating encapsulation, capture and externalize an object's internal state
 * 		so that the object can be restored to this state later.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To take snapshots and restore an object back to its previous state(e.g. "undo" or "rollback")
 *
 * 	Benefits:
 * 	--------
 * 	1.	Internal state of the memento object cannot be changed.
 * 	2.	Easy to implement recoverable states.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Too many objects may be created by the Originator which makes maintenance expensive.
 *
 * 	Software Examples:
 * 	-----------------
 * 	1.	Undo functionalities in Text Editors.
 * 	2.	Snapshots of software.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.util.Date (setter methods do that, Date is internally represented by long value)
 * 	2.	All implementations of java.io.Serializable
 */
public class T_010_MementoPattern {
	/*
	 * Create an Originator class. In our example, OS s/s is originator which creates/restores
	 * a memento.
	 */
	public static class OS {
		private StringBuilder installedSw;

		public OS(String os) {
			installedSw = new StringBuilder(os);
		}
		
		public void install(String sw) {
			installedSw.append(" + " + sw);
			System.out.println(installedSw);
		}
		
		public RecoveryImage saveImage() {
			System.out.println("--Saved OS image--");
			return new RecoveryImage(installedSw.toString());
		}

		public void restoreImage(RecoveryImage image) {
			installedSw = new StringBuilder(image.getSystemImage());
			System.out.println("--Restored OS Image--");
			System.out.println(installedSw);
		}
	}
	
	/*
	 * Create a memento class. In this case , the RecoveryImage class is memento which
	 * represents the object that can be saved and restored.
	 */
	public static class RecoveryImage {
		private final String image;
		
		public RecoveryImage(String image) {
			this.image = image;
		}
		
		public String getSystemImage() {
			return image;
		}
	}

	/*
	 * Create a CareTaker class which manages the mementos. The caretaker class can't modify
	 * the contents of memento.
	 */
	public static class RecoveryTool {
		private final ArrayList<RecoveryImage> mementos;

		public RecoveryTool() {
			mementos = new ArrayList<>();
		}
		
		public void addImage(RecoveryImage image) {
			mementos.add(image);
		}
		
		public void deleteImage() {
			mementos.remove(mementos.size() - 1);
		}

		public RecoveryImage getLastGoodImage() {
			return mementos.get(mementos.size() - 1);
		}
	}

	/*
	 * Client code - client uses the CareTaker(RecoveryTool) to "rollback" to previous good state.
	 */
	public static class MementoClient {

		public static void main(String[] args) {
			OS os = new OS("Windows 10");
			os.install("Antivirus");

			RecoveryTool recoveryTool = new RecoveryTool();
			recoveryTool.addImage(os.saveImage());
			os.install("Tomcat Server");
			recoveryTool.addImage(os.saveImage());
			os.install("MySql");
			os.restoreImage(recoveryTool.getLastGoodImage());
			recoveryTool.deleteImage();
			os.restoreImage(recoveryTool.getLastGoodImage());
		}
	}
}
