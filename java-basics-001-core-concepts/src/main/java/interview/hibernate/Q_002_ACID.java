package interview.hibernate;

/**
 *	->	It is very important in some scenarios. Consider A has to transfer the 50$ to B and transaction fails in between.
 *		So, it is very much important to rollback in case of failure.
 *
 *	ACID properties: (Atomicity, Consistency, Isolation, Durability)
 *	===============
 *	->	Atomicity:
 *		---------
 *		->	By this, we mean that either the entire transaction takes place at once or doesn’t happen at all. There is
 *			no midway i.e. transactions do not occur partially. Each transaction is considered as one unit and either
 *			runs to completion or is not executed at all. It involves the following two operations.
 *			->	Abort: If a transaction aborts, changes made to database are not visible.
 *			—>	Commit: If a transaction commits, changes made are visible.
 *		->	Atomicity is also known as the ‘All or nothing rule’.
 *		->	Consider the following transaction T consisting of T1 and T2: Transfer of 100 from account X to account Y.
 *			If the transaction fails after completion of T1 but before completion of T2.( say, after write(X) but before
 *			write(Y)), then amount has been deducted from X but not added to Y. This results in an inconsistent database
 *			state. Therefore, the transaction must be executed in entirety in order to ensure correctness of database state.
 *
 *	->	Consistency:
 *		----------
 *		->	This means that integrity constraints must be maintained so that the database is consistent before and after
 *			the transaction. It refers to the correctness of a database. Referring to the example above, The total amount
 *			before and after the transaction must be maintained.
 *				Total before T occurs = 500 + 200 = 700.
 *				Total after T occurs = 400 + 300 = 700.
 *			Therefore, database is consistent. Inconsistency occurs in case T1 completes but T2 fails. As a result T is incomplete.
 *
 *	->	Isolation:
 *		---------
 *		->	This property ensures that multiple transactions can occur concurrently without leading to the inconsistency
 *			of database state. Transactions occur independently without interference. Changes occurring in a particular
 *			transaction will not be visible to any other transaction until that particular change in that transaction is
 *			written to memory or has been committed. This property ensures that the execution of transactions concurrently
 *			will result in a state that is equivalent to a state achieved these were executed serially in some order.
 *				Let X= 500, Y = 500.
 *			->	Consider two transactions T and T" Suppose T has been executed till Read (Y) and then T" starts. As a
 *				result , interleaving of operations takes place due to which T" reads correct value of X but incorrect
 *				value of Y and sum computed by T": (X+Y = 50, 000+500=50, 500) is thus not consistent with the sum at
 *				end of transaction: T: (X+Y = 50, 000 + 450 = 50, 450).
 *				This results in database inconsistency, due to a loss of 50 units. Hence, transactions must take place
 *				in isolation and changes should be visible only after they have been made to the main memory.
 *		->	Dirty Read : If 2 transaction started simultaneously but one failed and roll back the value to original state.
 *		->	Non Repeatable Read : select a value(T1) , update the value(T2) and then select again(T1) - so different value in 2 reads.
 *		->	Phanthom Read : select a value(T1) , insert the new record(T2) and then select again(T1) - so different count in 2 reads.
 *		->	Isolation Levels:
 *			1.	Read Uncommitted	:	Even in uncommitted value, read is possible.
 *			2.	Read Committed		:	Until value is committed, the value can't be read i.e.  lock would be there. (DR - Solved)
 *			3.	Repeatable Read 	:	Complete data read in transaction will be locked . (DR, NRR - Solved)
 *			4.	Serializable		:	Table lock on certain constraint/condition (DR, NRR, PR - Solved)
 *
 *	->	Durability:
 *		----------
 *		->	This property ensures that once the transaction has completed execution, the updates and modifications to the
 *			database are stored in and written to disk and they persist even if a system failure occurs. These updates
 *			now become permanent and are stored in non-volatile memory. The effects of the transaction, thus, are never lost.
 *
 *	->	The ACID properties, in totality, provide a mechanism to ensure correctness and consistency of a database in a way such
 *		that each transaction is a group of operations that acts a single unit, produces consistent results, acts in isolation
 *		from other operations and updates that it makes are durably stored.
 */
public class Q_002_ACID {
}
