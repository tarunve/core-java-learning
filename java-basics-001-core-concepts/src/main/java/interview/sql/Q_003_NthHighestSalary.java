package interview.sql;

/**
 *  1.  SELECT name, salary FROM Employee e1
 *      WHERE N-1 = (SELECT COUNT(DISTINCT salary) FROM Employee e2 WHERE e2.salary > e1.salary)
 *
 *  2.  SELECT * FROM ( SELECT e.*, ROW_NUMBER() OVER (ORDER BY salary DESC) rn FROM Employee e )
 *      WHERE rn = N;
 *
 */
public class Q_003_NthHighestSalary {}
