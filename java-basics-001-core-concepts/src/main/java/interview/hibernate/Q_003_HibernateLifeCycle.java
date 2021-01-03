package interview.hibernate;

/**
 *  ->  In Hibernate, either we create an object of an entity and save it into the database,
 *      or we fetch the data of an entity from the database. Here, each entity is associated
 *      with the lifecycle. The entity object passes through the different stages of the lifecycle.
 *  ->  The Hibernate lifecycle contains the following states:-
 *      1.  Transient state
 *          ->  The transient state is the initial state of an object.
 *          ->  Once we create an instance of POJO class, then the object entered in the transient
 *              state.
 *          ->  Here, an object is not associated with the Session. So, the transient state is
 *              not related to any database.
 *          ->  Hence, modifications in the data don't affect any changes in the database.
 *          ->  The transient objects exist in the heap memory. They are independent of Hibernate.
 *                      Employee e=new Employee(); //Here, object enters in the transient state.
 *                      e.setId(101);
 *                      e.setFirstName("Gaurav");
 *                      e.setLastName("Sharma");
 *      2.  Persistent state:
 *          ->  As soon as the object associated with the Session, it entered in the persistent state.
 *          ->  Hence, we can say that an object is in the persistence state when we save or persist it.
 *          ->  Here, each object represents the row of the database table.
 *          ->  So, modifications in the data make changes in the database.
 *                      session.save(e);
 *                      session.persist(e);
 *                      session.update(e);
 *                      session.saveOrUpdate(e);
 *                      session.lock(e);
 *                      session.merge(e);
 *      3.  Detached state:
 *          ->  Once we either close the session or clear its cache, then the object entered into
 *              the detached state.
 *          ->  As an object is no more associated with the Session, modifications in the data don't
 *              affect any changes in the database.
 *          ->  However, the detached object still has a representation in the database.
 *          ->  If we want to persist the changes made to a detached object, it is required to reattach
 *              the application to a valid Hibernate session.
 *          ->  To associate the detached object with the new hibernate session, use any of these
 *              methods - load(), merge(), refresh(), update() or save() on a new session with the
 *              reference of the detached object.
 *                      session.close();
 *                      session.clear();
 *                      session.detach(e);
 *                      session.evict(e);
 */
public class Q_003_HibernateLifeCycle {
}
