package practice11.hashing;

/*
 * 	->	The hash function is used to transform the key into the index. Ideally, the hash function should map
 * 		each possible key to a unique slot index, but it is difficult to achieve in practice.
 * 	->	Given a collection of elements, a hash function that maps each item into a unique slot is referred
 * 		to as a perfect hash function. If we know the elements and the collection will never change, then
 * 		it is possible to construct a perfect hash function. Unfortunately, given an arbitrary collection of
 * 		elements, there is no systematic way to construct a perfect hash function. Luckily, we do not need
 * 		the hash function to be perfect to still gain performance efficiency.
 * 	->	Our goal is to create a hash function that minimizes the number of collisions, is easy to compute, and 
 * 		evenly distributes the elements in the hash table. There are a number of common ways to extend the simple 
 * 		remainder method.
 * 
 * 	How to choose Hash Function:	
 * 	---------------------------
 * 	->	The basic problems associated with the creation of hash tables are:
 * 		• 	An efficient hash function should be designed so that it distributes the index values of inserted objects 
 * 			uniformly across the table.
 * 		• 	An efficient collision resolution algorithm should be designed so that it computes an alternative index 
 * 			for a key whose hash index corresponds to a location previously inserted in the hash table.
 * 		• 	We must choose a hash function which can be calculated quickly, returns values within the range of 
 * 			locations in our table, and minimizes collisions.
 * 
 * 	Characteristics of Good Hash Functions
 * 	--------------------------------------
 * 	->	A good hash function should have the following characteristics:
 * 		•	Minimize collision
 * 		• 	Be easy and quick to compute
 * 		• 	Distribute key values evenly in the hash table
 * 		• 	Use all the information provided in the key
 * 		• 	Have a high load factor for a given set of keys
 * 
 * 	Load Factor
 * 	==========
 * 	->	The load factor of a non-empty hash table is the number of items stored in the table divided by the
 * 		size of the table. This is the decision parameter used when we want to rehash or expand the	existing 
 * 		hash table entries. This also helps us in determining the efficiency of the hashing function. That 
 * 		means, it tells whether the hash function is distributing the keys uniformly or not.
 * 			Load Factor = Number of elements in hash table / HashTable size.
 */
public class T_002_HashFunctions {
	
}
