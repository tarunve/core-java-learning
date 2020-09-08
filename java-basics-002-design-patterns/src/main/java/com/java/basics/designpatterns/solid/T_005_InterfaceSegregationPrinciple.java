package com.java.basics.designpatterns.solid;

/**
 *	->	The Interface Segregation Principle is the fourth SOLID design principle represented by the letter 
 *		“I” in the acronym. It was Robert C Martin who first defined the principle by stating that 
 *		“clients should not be forced to depend on methods they don’t use.” By clients, he means classes 
 *		that implement interfaces. In other words, interfaces shouldn’t include too many functionalities.
 *	->	The violation of Interface Segregation Principle harms code readability and forces programmers to 
 *		write dummy methods that do nothing. In a well-designed application, you should avoid interface 
 *		pollution (also called fat interfaces). The solution is to create smaller interfaces that you can 
 *		implement more flexibly.
 *	->	The best place to look for IS Principle examples is Java AWT event handlers for handling GUI events 
 *		fired from keyboard and mouse. It has different listener classes for each kind of event. We only need 
 *		to write handlers for events, we wish to handle. Nothing is mandatory. Some of the listeners are :
 *		->	FocusListener
 *		->	KeyListener
 *		->	MouseMotionListener	
 *		->	MouseWheelListener
 *		->	TextListener
 *		->	WindowFocusListener
 */
public class T_005_InterfaceSegregationPrinciple {
	
	/*
	 * IS principle is violated.	
	 */
	static class WithoutISPrinciple{
		interface BookAction {
			void seeReviews();
			void searchSecondhand();
			void listenSample();
		}
		
		class HardcoverUI implements BookAction {
			@Override
			public void seeReviews() {}
			@Override
			public void searchSecondhand() {}
			@Override
			public void listenSample() {}
		}

		class AudiobookUI implements BookAction {
			@Override
			public void seeReviews() {}
			@Override
			public void searchSecondhand() {}
			@Override
			public void listenSample() {}
		}
	}
	
	/*
	 * IS principle is not violated
	 */
	static class WithISPrinciple{
		interface BookAction {
			void seeReviews();
		}

		interface HardcoverAction extends BookAction {
			void searchSecondhand();
		}

		interface AudioAction extends BookAction {
			void listenSample();
		}
		
		class HardcoverUI implements HardcoverAction {
			@Override
			public void seeReviews() {}
			@Override
			public void searchSecondhand() {}
		}

		class AudiobookUI implements AudioAction {
			@Override
			public void seeReviews() {}
			@Override
			public void listenSample() {}

		}
	}
}
