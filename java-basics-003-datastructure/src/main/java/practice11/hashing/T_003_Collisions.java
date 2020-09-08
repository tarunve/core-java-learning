package practice11.hashing;

/*
 * 	->	Hash functions are used to map each key to a different address space, but practically it is not
 * 		possible to create such a hash function and the problem is called collision. Collision is the
 * 		condition where two records are stored in the same location.
 * 	
 * 	Collision Resolution Techniques:
 * 	-------------------------------
 * 	->	The process of finding an alternate location is called collision resolution. Even though hash
 * 		tables have collision problems, they are more efficient in many cases compared to all other data
 * 		structures, like search trees. There are a number of collision resolution techniques, and the most
 * 		popular are direct chaining and open addressing.
 * 		1.	Direct Chaining: An array of linked list application
 * 							○ Separate chaining
 * 		2.	Open Addressing	:	In open addressing all keys are stored in the hash table itself. This approach 
 * 								is also known as closed hashing. This procedure is based on probing. 
 * 			A collision is resolved by probing. Array-based implementation.
 * 								○ Linear probing (linear search)
 * 								○ Quadratic probing (nonlinear search)
 * 								○ Double hashing (use two hash functions)
 * 
 * 	1.	Separate Chaining:
 * 		-----------------
 * 		->	Collision resolution by chaining combines linked representation with hash table. When two or
 * 			more records hash to the same location, these records are constituted into a singly-linked list
 * 			called a chain.
 * 	
 * 	2.	Linear Probing:
 * 		--------------
 * 		->	The interval between probes is fixed at 1. In linear probing, we search the hash table sequentially,
 * 			starting from the original hash location. If a location is occupied, we check the next location. We
 * 			wrap around from the last table location to the first table location if necessary. The function for
 * 			rehashing is the following:
 * 				rehash(key) = (n+1)%TableSize;
 * 		->	One of the problems with linear probing is that table items tend to cluster together in the hash
 * 			table. This means that the table contains groups of consecutively occupied locations that are
 * 			called clustering.
 * 		->	Clusters can get close to one another, and merge into a larger cluster. Thus, the one part of the
 * 			table might be quite dense, even though another part has relatively few items. Clustering causes
 * 			long probe searches and therefore decreases the overall efficiency.
 * 		->	The next location to be probed is determined by the step-size, where other step-sizes (more than
 * 			one) are possible. The step-size should be relatively prime to the table size, i.e. their greatest
 * 			common divisor should be equal to 1. If we choose the table size to be a prime number, then any
 * 			step-size is relatively prime to the table size. Clustering cannot be avoided by larger step-sizes.
 * 
 * 	3.	Quadratic Probing:
 * 		-----------------
 * 		->	The interval between probes increases proportionally to the hash value (the interval thus increasing 
 * 			linearly, and the indices are described by a quadratic function). The problem of Clustering can be 
 * 			eliminated if we use the quadratic probing method.
 * 		->	In quadratic probing, we start from the original hash location i. If a location is occupied, we check 
 * 			the locations i + 12 , i +22, i + 32, i + 42... We wrap around from the last table location to the first 
 * 			table location if necessary. The function for rehashing is the following:
 * 					rehash(key) = (n+k^2)%TableSize;
 * 		->	Even though clustering is avoided by quadratic probing, still there are chances of clustering.
 * 			Clustering is caused by multiple search keys mapped to the same hash key. Thus, the probing sequence 
 * 			for such search keys is prolonged by repeated conflicts along the probing sequence. Both linear and 
 * 			quadratic probing use a probing sequence that is independent of the search key.
 * 
 * 	4.	Double Hashing:
 * 		--------------
 * 		->	The interval between probes is computed by another hash function. Double hashing reduces
 * 			clustering in a better way. The increments for the probing sequence are computed by using a
 * 			second hash function. The second hash function h2 should be:
 * 				h2(key) != 0 and h2!= h1
 * 		->	We first probe the location h1(key). If the location is occupied, we probe the location h1(key) + 
 * 			h2(key), h1(key) + 2 * h2(key), ...
 * 			
 */
public class T_003_Collisions {
	
}
