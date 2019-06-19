package WCCI.proofofconcept;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class GenreTest {
	@Test
	public void genreShouldHaveName() {
		Genre underTest = new Genre("");
		String genre =	underTest.getGenName();
		assertThat(genre, is(""));
	}
	@Test
	public void genreShouldHaveNamePunk() {
		Genre underTest = new Genre("Punk");
		String genre =	underTest.getGenName();
		assertThat(genre, is("Punk"));
	}
}
