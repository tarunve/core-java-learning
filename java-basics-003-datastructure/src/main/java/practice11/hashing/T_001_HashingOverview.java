package practice11.hashing;

/*
 * 	->	Hashing is a technique used for storing and retrieving information as quickly as possible. It is
 * 		used to perform optimal searches and is useful in implementing symbol tables.
 * 	->	In the Trees chapter we saw that balanced binary search trees support operations such as insert,
 * 		delete and search in O(logn) time. In applications, if we need these operations in O(1), then
 * 		hashing provides a way. Remember that worst case complexity of hashing is still O(n), but it gives 
 * 		O(1) on the average.
 * 	->	Components of Hashing
 * 		---------------------
 * 		->	Hashing has four key components:
 * 			1) Hash Table
 * 			2) Hash Functions
 * 			3) Collisions
 * 			4) Collision Resolution Techniques
 * 
 * 	1.	HashTable
 * 		---------
 * 		->	Hash table is a generalization of array. With an array, we store the element whose key is k at a
 * 			position k of the array. That means, given a key k, we find the element whose key is k by just
 * 			looking in the kth position of the array. This is called direct addressing.
 * 		->	Direct addressing is applicable when we can afford to allocate an array with one position for 
 * 			every possible key. But if we do not have enough space to allocate a location for each possible
 * 			key, then we need a mechanism to handle this case. Another way of defining the scenario is: if we
 * 			have less locations and more possible keys, then simple array implementation is not enough.
 * 		->	In these cases one option is to use hash tables. Hash table or hash map is a data structure that
 * 			stores the keys and their associated values, and hash table uses a hash function to map keys to
 * 			their associated values. The general convention is that we use a hash table when the number of
 * 			keys actually stored is small relative to the number of possible keys.
 */
public class T_001_HashingOverview {
	
	public static void main(String[] args) {
		
	}
}
