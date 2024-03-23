package com.java.basics.designpatterns.solid;

/**
 *	->	The Dependency Inversion Principle is the fifth SOLID design principle represented by the last “D” 
 *		and introduced by Robert C Martin. The goal of the Dependency Inversion Principle is to avoid tightly 
 *		coupled code, as it easily breaks the application. The principle states that:
 *		->	“High-level modules should not depend on low-level modules. Both should depend on abstractions.”
 *			“Abstractions should not depend on details. Details should depend on abstractions.”
 *	->	In other words, you need to decouple high-level and low-level classes. High-level classes usually 
 *		encapsulate complex logic while low-level classes include data or utilities. Typically, most people 
 *		would want to make high-level classes depend on low-level classes. However, according to the Dependency 
 *		Inversion Principle, you need to invert the dependency. Otherwise, when the low-level class is replaced, 
 *		the high-level class will be affected, too.
 *	->	As a solution, you need to create an abstract layer for low-level classes, so that high-level classes 
 *		can depend on abstraction rather than concrete implementations.
 *	->	Robert C Martin also mentions that the Dependency Inversion Principle is a specific combination of the 
 *		Open/Closed and Liskov Substitution Principles.
 *	->	The classical use of this principle of bean configuration in Spring framework.
 *	->	Class should depend on Interface rather than concrete class.
 */	
public class T_006_DependencyInversionPrinciple {

	/*
	 * 	If it is asked to change the Wired Devices to Bluetooth Device, we would need to add new classes
	 * 	for Bluetooth Devices and modify the existing MacBook class which violates the DI principle.
	 */
	static class WithoutDIPrinciple{
		static class WiredKeyBoard { }

		static class WiredMouse { }

		static class MacBook {
			WiredKeyBoard keyBoard;
			WiredMouse mouse;

			MacBook(WiredKeyBoard keyBoard, WiredMouse mouse) {
				this.keyBoard = keyBoard;
				this.mouse = mouse;
			}
		}
	}
	
	/*
	 * Solution to above problem
	 */
	static class WithDIPrinciple{
		interface KeyBoard { }
		static class WiredKeyBoard implements KeyBoard { }
		static class BluetoothKeyBoard implements KeyBoard { }

		interface Mouse { }
		static class WiredMouse implements Mouse { }
		static class BluetoothMouse implements Mouse { }

		static class MacBook {
			KeyBoard keyBoard;
			Mouse mouse;

			MacBook(KeyBoard keyBoard, Mouse mouse) {
				this.keyBoard = keyBoard;
				this.mouse = mouse;
			}
		}
	}
}
