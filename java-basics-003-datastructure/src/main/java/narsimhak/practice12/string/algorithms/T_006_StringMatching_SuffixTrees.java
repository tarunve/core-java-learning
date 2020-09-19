package practice12.string.algorithms;

/*
 * 	->	All of the above algorithms preprocess the pattern to make the pattern searching faster. The 
 * 		best time complexity that we could get by preprocessing pattern is O(n) where n is length of 
 * 		the text. In this post, we will discuss an approach that preprocesses the text. A suffix tree 
 * 		is built of the text. After preprocessing text (building suffix tree of text), we can search 
 * 		any pattern in O(m) time where m is length of the pattern.
 * 	->	Preprocessing of text may become costly if the text changes frequently. It is good for fixed 
 * 		text or less frequently changing text though.
 * 	->	A Suffix Tree for a given text is a compressed trie for all suffixes of the given text.
 * 
 * 	How to build a Suffix Tree for a given text?
 * 	--------------------------------------------
 * 	->	As discussed above, Suffix Tree is compressed trie of all suffixes, so following are very abstract 
 * 		steps to build a suffix tree from given text.
 * 		1) Generate all suffixes of given text.
 * 		2) Consider all suffixes as individual words and build a compressed trie.
 * 
 * 	How to search a pattern in the built suffix tree?
 * 	-------------------------------------------------
 * 	->	We have discussed above how to build a Suffix Tree which is needed as a preprocessing step in pattern 
 * 		searching. Following are abstract steps to search a pattern in the built Suffix Tree.
 * 		1) 	Starting from the first character of the pattern and root of Suffix Tree, do following for every character.
 * 			a) 	For the current character of pattern, if there is an edge from the current node of suffix tree, 
 * 				follow the edge.
 * 			b) 	If there is no edge, print “pattern doesn’t exist in text” and return.
 * 		2)	If all characters of pattern have been processed, i.e., there is a path from root for characters of 
 * 			the given pattern, then print “Pattern found”.
 * 
 * 	Applications of Suffix Trees
 * 	----------------------------
 * 	->	Exact String Matching
 * 	->	Longest Repeated Substring
 * 	->	Longest Palindrome
 * 	->	Longest Common Substring
 * 	->	Longest Common Prefix
 */
public class T_006_StringMatching_SuffixTrees {
	
	
}
