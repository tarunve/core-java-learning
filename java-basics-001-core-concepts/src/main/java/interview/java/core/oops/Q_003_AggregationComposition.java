package interview.java.core.oops;

/**
 *  Association:
 *  ===========
 *  -   We call association those relationships whose objects have an independent lifecycle
 *      and where there is no ownership between the objects.
 *  -   Let’s take an example of a teacher and student. Multiple students can associate with
 *      a single teacher, and a single student can associate with multiple teachers, but both
 *      have their own lifecycles (both can be create and delete independently); so when a
 *      teacher leaves the school, we don’t need to delete any students, and when a student
 *      leaves the school, we don’t need to delete any teachers.
 *
 *  Aggregation:
 *  ===========
 *  -   We call aggregation those relationships whose objects have an independent lifecycle,
 *      but there is ownership, and child objects cannot belong to another parent object.
 *  -   It is uni-directional in nature.
 *  -   Let’s take an example of a cell phone and a cell phone battery. A single battery can
 *      belong to a phone, but if the phone stops working, and we delete it from our database,
 *      the phone battery will not be deleted because it may still be functional. So in aggregation,
 *      while there is ownership, objects have their own lifecycle.
 *
 *  Composition:
 *  ===========
 *  -   We use the term composition to refer to relationships whose objects don’t have an
 *      independent lifecycle, and if the parent object is deleted, all child objects will
 *      also be deleted.
 *  -   Let’s take an example of the relationship between questions and answers. Single
 *      questions can have multiple answers, and answers cannot belong to multiple questions.
 *      If we delete questions, answers will automatically be deleted.
 */
public class Q_003_AggregationComposition {
}
