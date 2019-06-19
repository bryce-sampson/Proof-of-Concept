package WCCI.proofofconcept;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenreMapTest {

	GenreMap underTest = new GenreMap();
	
	@Test
	public void ShouldBeAbleToAddGenreToMap() {
		underTest.addGenreToMap(new Genre("Punk"));
		String expectedName = underTest.getGenName("Punk");
		assertEquals("Punk", expectedName);
	}
}
