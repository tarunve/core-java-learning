package interview.sql;

/**
 *  1.  DELETE FROM MyTable
 *      LEFT OUTER JOIN (
 *          SELECT MIN(RowId) as RowId, Col1, Col2, Col3
 *          FROM MyTable
 *          GROUP BY Col1, Col2, Col3
 *      ) as KeepRows ON
 *      MyTable.RowId = KeepRows.RowId
 *      WHERE
 *          KeepRows.RowId IS NULL
 *
 *  2.  DELETE FROM MyTable
 *      WHERE
 *          RowID NOT IN (SELECT MIN(RowID) FROM MyTable GROUP BY Col1,Col2,Col3)
 */
public class Q_002_DeleteDuplicateRecord {}
