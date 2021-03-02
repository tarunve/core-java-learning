package narsimhak.practice05.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 	->	A tree representing an expression is called an expression tree. In expression trees, leaf nodes are 
 * 		operands and non-leaf nodes are operators. That means, an expression tree is a binary tree where internal 
 * 		nodes are operators and leaves are operands. An expression tree consists of binary expression. But for a 
 * 		u-nary operator, one subtree will be empty. The figure below shows simple expression tree for (A + B * C) / D.
 */
public class T_005_ExpressionTrees {
	
	class BinaryTreeNode{
		public int data;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode() {
		}
		
		public BinaryTreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/*
	 * Algorithm for Building Expression Tree from Postfix Expression.
	 */
	public BinaryTreeNode buildExpressionTree(char postfixExpr[], int size){
		Stack<BinaryTreeNode> stack = new Stack<>();
		String[] operands = {"*","/","+","-","%"};
		ArrayList<String> operandsList = (ArrayList<String>) Arrays.asList(operands);
		for(int i=0; i<size; i++){
			if(operandsList.contains(String.valueOf(postfixExpr[i])) ){
				BinaryTreeNode newNode = new BinaryTreeNode();
				newNode.data = postfixExpr[i];
				newNode.left = null;
				newNode.right = null;
				stack.push(newNode);
			}else {
				BinaryTreeNode T2 = stack.pop(), T1 = stack.pop();
				BinaryTreeNode newNode = new BinaryTreeNode();
				newNode.data = postfixExpr[i];
				newNode.left = T1;
				newNode.right = T2;
				stack.push(newNode);
			}
		}
		return stack.peek();
	}
	
}
