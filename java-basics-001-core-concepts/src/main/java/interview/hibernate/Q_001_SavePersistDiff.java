package interview.hibernate;


/**
 *  Save:
 *  ----
 *  ->  Returns generated Id after saving. Its return type is Serializable.
 *  ->  Saves the changes to the database outside of the transaction.
 *  ->  Assigns the generated id to the entity you are persisting.
 *  ->  session.save() for a detached object will create a new row in the table.
 *
 *  Persist:
 *  -------
 *  ->  Does not return generated Id after saving. Its return type is void.
 *  ->  Does not save the changes to the database outside of the transaction.
 *  ->  Assigns the generated Id to the entity you are persisting.
 *  ->  session.persist() for a detached object will throw a PersistentObjectException,
 *      as it is not allowed.
 */
public class Q_001_SavePersistDiff {
}
