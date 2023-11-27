package enhancements;

/**
 *  Text Block Syntax
 *  -   In Java, a text block is a multi-line string literal. It means we do not need to get into
 *      the mess of explicit line terminators, string concatenations, and delimiters otherwise used
 *      for writing normal string literals.
 *  -   Text blocks comprise multiple lines of text and use three double-quote characters (""") as
 *      the opening and closing delimiters.
 *  -   The opening three double-quote characters are always followed by a line terminator.
 *  -   We cannot have the delimiters and text blocks on a single line. The opening delimiter must
 *      be on its own line. Content has to start on the next line only.
 *  -   If the text content contains single or double quotes, there is no need to escape them.
 *
 *  Text Blocks are Java Strings
 *  -   The instance produced from a text block is of type java.lang.String with the same characteristics
 *      as a traditional double-quoted string. This includes object representation and interning
 *      into string pool.
 *  -   We can use text blocks to pass as method arguments of type String.
 *  -   Text blocks can be used anywhere a string literal can be used. For example, we can use it for string
 *
 *  Best Practices
 * 	-	Only use a text block when it improves the clarity of the code, particularly with multi-line strings.
 * 	-	If a string fits in the use case, always prefer to use strings. They are better for
 * 		application performance.
 * 	-	To maintain the desired indentation, always use the position of closing triple quotes relative
 * 		to the position of the last line on the content.
 * 	-	Avoid in-line text blocks within complex expressions such as lambda expressions or stream
 * 		operations to maintain readability. Consider refactoring to a local variable or to a static
 * 		final field.
 * 	-	Either use only spaces or only tabs for the indentation of a text block. Mixing white space
 * 		will lead to a result with irregular indentation.
 */
public class E_002_javaTextBlocks {

    public static void main(String[] args) {
        String dbSchema = 	"""
			CREATE TABLE 'TEST'.'EMPLOYEE'
			(
			  'ID' INT NOT NULL DEFAULT 0 ,
			  'FIRST_NAME' VARCHAR(100) NOT NULL ,
			  'LAST_NAME' VARCHAR(100) NULL ,
			  'STAT_CD' TINYINT NOT NULL DEFAULT 0
			);
			""";
        System.out.println(dbSchema);

        String string = "Hello";
        String textBlock = """
					World""";

        String joinedString =  string + textBlock;
        System.out.println(joinedString);
    }

}
