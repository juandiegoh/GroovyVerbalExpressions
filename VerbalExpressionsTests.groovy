
import org.junit.Test;

import static org.junit.Assert.assertEquals

class VerbalExpressionsTests {

	@Test
	void "Replace_if a match regex it should return a modified string"() {
		def regex = new VerbalExpressions().add("@").somethingBut(".").add("\\.")
		def input = "juan@gmail.com, pep@hotmail.com, another_mail@yahoo.com"

		def expectedResult = "juan@verbalexpressions.com, pep@verbalexpressions.com, another_mail@verbalexpressions.com"
		String result = regex.replace(input, "@verbalexpressions.");
		
		assertEquals expectedResult, result
	}

	@Test
	void "Replace_if not a match regex it should return the same string"() {
		def regex = new VerbalExpressions().add("NOT A MATCH")
		def input = "any string"
		
		def expectedResult = "any string"
		def result = regex.replace(input, "NOT GOING TO BE IN THE RESULT")

		assertEquals expectedResult, result
	}

}

