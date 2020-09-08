package com.java.basics.designpatterns.behavioral;

import java.util.Stack;

/*
 * 	->	Given a language, define a representation for the grammar along with an interpreter
 * 		that uses the representation to interpret sentences in the language.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To easily solve "repeated problems" in a well-defined domain with help of a 'language'.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Grammars can be easily modified or extended by inheritance.
 * 	2.	Expressions can be interpreted in new ways by adding new operations to expression.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Grammars containing many rules can be hard to manage and maintain.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Language Interpreter.
 *
 * 	Software Examples:
 * 	-----------------
 * 	1.	Software Compiler
 * 	2.	SQL evaluation engine
 * 	3.	XML parser
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.util.Pattern
 * 	2.	All subclasses of java.text.Format
 */
public class T_008_InterpreterPattern {
	/*
	 * Create an interface for the basic expressions.
	 */
	public static interface Exp {
		public int evaluate();
	}

	/*
	 * Create concrete expressions including the terminal and non-terminal expressions.
	 */
	public static class Number implements Exp {

		private final int n;

		public Number(int n) {
			this.n = n;
		}

		@Override
		public int evaluate() {
			return n;
		}
	}

	public static class AddExp implements Exp {
		
		Exp first;
		Exp second;
		
		public AddExp(Exp n1, Exp n2) {
			this.first = n1;
			this.second = n2;
		}
		
		@Override
		public int evaluate() {
			return first.evaluate() + second.evaluate();
		}
	}

	public static class SubtractExp implements Exp {
		
		Exp first;
		Exp second;
		
		public SubtractExp(Exp n1, Exp n2) {
			this.first = n1;
			this.second = n2;
		}
		
		@Override
		public int evaluate() {
			return first.evaluate() - second.evaluate();
		}
	}

	public static class MultiplyExp implements Exp {
		
		Exp first;
		Exp second;
		
		public MultiplyExp(Exp n1, Exp n2) {
			this.first = n1;
			this.second = n2;
		}
		
		@Override
		public int evaluate() {
			return first.evaluate() * second.evaluate();
		}
	}

	public static class DivideExp implements Exp {
		
		Exp first;
		Exp second;
		
		public DivideExp(Exp n1, Exp n2) {
			this.first = n1;
			this.second = n2;
		}
		
		@Override
		public int evaluate() {
			return first.evaluate() / second.evaluate();
		}
	}

	/*
	 * Client code - The client uses the abstract syntax tree representing a particular
	 * sentence in the language that the grammar defines. The abstract syntax tree is assembled
	 * from instances of the NonTerminal Expression and Terminal Expression classes. The client
	 * then invokes the interpret method/operation.
	 */
	public static class InterpretClient {

		public static void main(String[] args) {
			String postfix = "543-2+*";
			final String OPERATORS = "+-*/";
			Stack<Exp> stack = new Stack<>();
			
			for (char c : postfix.toCharArray()) {
				Exp resultExp;
				if (OPERATORS.indexOf(c) == -1)
					resultExp = new Number(c - 48);
				else {
					Exp right = stack.pop();
					Exp left = stack.pop();
					switch (c) {
						case '+':
							resultExp = new AddExp(left, right);
							break;
						case '-':
							resultExp = new SubtractExp(left, right);
							break;
						case '*':
							resultExp = new MultiplyExp(left, right);
							break;
						case '/':
							resultExp = new DivideExp(left, right);
							break;
						default:
							resultExp = new Number(0);
					}
				}
				stack.push(new Number(resultExp.evaluate()));
			}
			System.out.println("Result " + stack.pop().evaluate());
		}
	}
}
