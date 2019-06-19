package WCCI.proofofconcept;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuthorMapTest {

	AuthorMap underTest = new AuthorMap();
	
	@Test
	public void ShouldBeAbleToAddAuthorToMap() {
		underTest.addAuthorToMap(new Author("Dan"));
		String expectedName = underTest.getName("Dan");
		assertEquals("Dan", expectedName);
	}
	
	@Test
	public void ShouldBeAbleToAddEmployeeToLIstTwice() {
		underTest.addAuthorToMap(new Author("Dan"));
		underTest.addAuthorToMap(new Author("Ron"));
		int expectedSize = underTest.getAuthorMapSize();
		assertEquals(2,expectedSize);	}
	
}
